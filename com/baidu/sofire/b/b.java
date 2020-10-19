package com.baidu.sofire.b;

import java.security.MessageDigest;
/* loaded from: classes15.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f3594a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", com.baidu.pass.biometrics.face.liveness.d.b.f2751a, "c", "d", "e", "f"};

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (Throwable th) {
            return null;
        }
    }
}
