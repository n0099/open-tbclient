package com.baidu.sofire.b;

import com.baidu.searchbox.ugc.model.PublishType;
import java.security.MessageDigest;
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f3600a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", PublishType.TYPE_VIDEO_SHARE, "a", com.baidu.pass.biometrics.face.liveness.d.b.f2755a, "c", "d", "e", "f"};

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
