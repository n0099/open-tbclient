package com.baidu.helios.common.b.a;

import java.security.MessageDigest;
/* loaded from: classes3.dex */
public class f {
    public static byte[] Z(String str, String str2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes(str2));
            return messageDigest.digest();
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] A(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception e) {
            return null;
        }
    }

    public static String B(byte[] bArr) {
        return a.c(A(bArr), false);
    }
}
