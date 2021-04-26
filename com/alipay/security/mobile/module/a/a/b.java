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
            for (int i2 = 0; i2 < digest.length; i2++) {
                sb.append(String.format("%02x", Byte.valueOf(digest[i2])));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
