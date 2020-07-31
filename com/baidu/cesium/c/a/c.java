package com.baidu.cesium.c.a;

import java.security.SecureRandom;
/* loaded from: classes3.dex */
public class c {
    public static final SecureRandom aky = new SecureRandom();
    private e akz;

    public c() {
        this.akz = null;
        this.akz = new e(new b(), 16);
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
        this.akz.a(i, bArr, bArr2, aky);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.akz.k(bArr, 0, bArr.length);
    }
}
