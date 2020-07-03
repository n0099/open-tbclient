package com.baidu.cesium.c.a;

import java.security.SecureRandom;
/* loaded from: classes13.dex */
public class c {
    public static final SecureRandom akD = new SecureRandom();
    private e akE;

    public c() {
        this.akE = null;
        this.akE = new e(new b(), 16);
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
        this.akE.a(i, bArr, bArr2, akD);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.akE.k(bArr, 0, bArr.length);
    }
}
