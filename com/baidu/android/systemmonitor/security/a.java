package com.baidu.android.systemmonitor.security;

import com.baidu.android.common.security.AESUtil;
import com.baidu.android.common.security.Base64;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public final class a {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private a() {
    }

    public static String a(String str) {
        String str2 = "";
        try {
            str2 = c("bdsystemmonitor_2013@mic");
        } catch (NoSuchAlgorithmException e) {
        }
        return URLEncoder.encode(Base64.encode(AESUtil.encrypt("2013010111143000", str2.substring(str2.length() / 2), str.getBytes()), "utf-8"), "utf-8");
    }

    public static String b(String str) {
        String str2 = "";
        try {
            str2 = c("bdsystemmonitor_2013@mic");
        } catch (NoSuchAlgorithmException e) {
        }
        String substring = str2.substring(str2.length() / 2);
        byte[] bArr = null;
        try {
            bArr = Base64.decode(URLDecoder.decode(str, "utf-8").getBytes());
        } catch (Exception e2) {
        }
        return new String(AESUtil.decrypt("2013010111143000", substring, bArr));
    }

    private static String c(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(str.getBytes());
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder(digest.length * 2);
        for (int i = 0; i < digest.length; i++) {
            sb.append(a[(digest[i] & 240) >>> 4]);
            sb.append(a[digest[i] & 15]);
        }
        return sb.toString();
    }
}
