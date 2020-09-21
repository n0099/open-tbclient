package com.baidu.b.d;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public final class c {
    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-1").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
