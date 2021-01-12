package com.baidu.cesium.c.a;

import java.security.SecureRandom;
/* loaded from: classes6.dex */
public class c {
    public static final SecureRandom ano = new SecureRandom();
    private e anp;

    public c() {
        this.anp = null;
        this.anp = new e(new b(), 16);
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
        this.anp.a(i, bArr, bArr2, ano);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.anp.k(bArr, 0, bArr.length);
    }
}
