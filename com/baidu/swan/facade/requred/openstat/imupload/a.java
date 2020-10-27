package com.baidu.swan.facade.requred.openstat.imupload;

import android.annotation.SuppressLint;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes16.dex */
public class a {
    @SuppressLint({"DefaultLocale"})
    public static String u(String str, long j) {
        return md5(String.format("%d%s%d", 1, str.toLowerCase(), Long.valueOf(j)));
    }

    private static String md5(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
