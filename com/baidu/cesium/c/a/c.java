package com.baidu.cesium.c.a;

import java.security.SecureRandom;
/* loaded from: classes13.dex */
public class c {
    public static final SecureRandom PY = new SecureRandom();
    private e PZ;

    public c() {
        this.PZ = null;
        this.PZ = new e(new b(), 16);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        c cVar = new c();
        cVar.a(1, bArr, bArr2);
        return cVar.a(bArr3);
    }

    public static byte[] c(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        c cVar = new c();
        cVar.a(2, bArr, bArr2);
        return cVar.a(bArr3);
    }

    public void a(int i, byte[] bArr, byte[] bArr2) {
        this.PZ.a(i, bArr, bArr2, PY);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.PZ.i(bArr, 0, bArr.length);
    }
}
