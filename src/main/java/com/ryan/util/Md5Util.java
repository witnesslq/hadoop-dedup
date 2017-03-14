package com.ryan.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility class to generate MD5
 *
 * @author Ryan Tao
 * @github lemonjing
 */
public class Md5Util {
    /**
     * get md5 hash from byte array
     *
     * @param bytes
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String getMd5(byte[] bytes) throws NoSuchAlgorithmException {
        Parameters.checkNotNull(bytes);
        Parameters.checkCondition(bytes.length >= 0);
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(bytes);
        byte[] md5Bytes = md.digest();

        return bytesToHexString(md5Bytes);

    }

    /**
     * byte array to hex string
     *
     * @param bytes
     * @return
     */
    private static String bytesToHexString(byte[] bytes) {
        String hex = "";
        for (int i = 0; i < bytes.length; i++) {
            hex += byteToHexString(bytes[i]);
        }

        return hex;
    }

    /**
     * byte to hex string
     *
     * @param b
     * @return
     */
    private static String byteToHexString(byte b) {
        char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = digit[(b >>> 4) & 0x0F];
        tempArr[1] = digit[b & 0x0F];

        String res = new String(tempArr);

        return res;
    }
}
