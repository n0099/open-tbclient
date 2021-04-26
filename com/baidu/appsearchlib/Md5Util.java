package com.baidu.appsearchlib;

import java.security.MessageDigest;
/* loaded from: classes.dex */
public class Md5Util {
    public static MessageDigest md5;

    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e2) {
            System.out.println(e2.getMessage());
        }
    }

    public static String getMd5(String str) {
        byte[] digest = md5.digest(str.getBytes());
        StringBuilder sb = new StringBuilder(40);
        for (byte b2 : digest) {
            int i2 = b2 & 255;
            if ((i2 >> 4) == 0) {
                sb.append("0");
                sb.append(Integer.toHexString(i2));
            } else {
                sb.append(Integer.toHexString(i2));
            }
        }
        return sb.toString();
    }
}
