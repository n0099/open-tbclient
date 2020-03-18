package com.baidu.cesium.c.a;

import java.security.SecureRandom;
/* loaded from: classes13.dex */
public class c {
    public static final SecureRandom PZ = new SecureRandom();
    private e Qa;

    public c() {
        this.Qa = null;
        this.Qa = new e(new b(), 16);
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
        this.Qa.a(i, bArr, bArr2, PZ);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.Qa.i(bArr, 0, bArr.length);
    }
}
