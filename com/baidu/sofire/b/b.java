package com.baidu.sofire.b;

import com.baidu.minivideo.plugin.capture.utils.EncryptUtils;
import java.security.MessageDigest;
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f3501a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", com.baidu.pass.biometrics.face.liveness.d.b.f2804a, "c", "d", "e", "f"};

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return MessageDigest.getInstance(EncryptUtils.ENCRYPT_MD5).digest(bArr);
        } catch (Throwable th) {
            return null;
        }
    }
}
