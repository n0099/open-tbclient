package com.baidu.cesium.c.a;

import java.security.SecureRandom;
/* loaded from: classes19.dex */
public class c {
    public static final SecureRandom adB = new SecureRandom();
    private e amD;

    public c() {
        this.amD = null;
        this.amD = new e(new b(), 16);
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
        this.amD.a(i, bArr, bArr2, adB);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.amD.m(bArr, 0, bArr.length);
    }
}
