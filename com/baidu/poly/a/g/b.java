package com.baidu.poly.a.g;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes9.dex */
public class b {
    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String dF(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    public static String g(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(str.hashCode());
        }
    }
}
