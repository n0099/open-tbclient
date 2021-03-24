package com.alipay.security.mobile.module.a.a;

import java.security.MessageDigest;
/* loaded from: classes.dex */
public final class b {
    public static String a(String str) {
        try {
            if (com.alipay.security.mobile.module.a.a.a(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                sb.append(String.format("%02x", Byte.valueOf(digest[i])));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
