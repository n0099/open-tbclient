package com.baidu.cesium.c.a;

import java.security.SecureRandom;
/* loaded from: classes6.dex */
public class c {
    public static final SecureRandom adv = new SecureRandom();
    private e amw;

    public c() {
        this.amw = null;
        this.amw = new e(new b(), 16);
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
        this.amw.a(i, bArr, bArr2, adv);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.amw.m(bArr, 0, bArr.length);
    }
}
