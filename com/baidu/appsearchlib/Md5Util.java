package com.baidu.appsearchlib;

import java.security.MessageDigest;
/* loaded from: classes9.dex */
public class Md5Util {
    private static MessageDigest md5;

    static {
        md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getMd5(String str) {
        byte[] digest = md5.digest(str.getBytes());
        StringBuilder sb = new StringBuilder(40);
        for (byte b : digest) {
            if (((b & 255) >> 4) == 0) {
                sb.append("0").append(Integer.toHexString(b & 255));
            } else {
                sb.append(Integer.toHexString(b & 255));
            }
        }
        return sb.toString();
    }
}
