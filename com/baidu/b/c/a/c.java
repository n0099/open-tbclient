package com.baidu.b.c.a;

import java.security.SecureRandom;
/* loaded from: classes3.dex */
public class c {
    public static final SecureRandom adf = new SecureRandom();
    private e adg;

    public c() {
        this.adg = null;
        this.adg = new e(new b(), 16);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        c cVar = new c();
        cVar.a(2, bArr, bArr2);
        return cVar.a(bArr3);
    }

    public void a(int i, byte[] bArr, byte[] bArr2) {
        this.adg.a(i, bArr, bArr2, adf);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.adg.k(bArr, 0, bArr.length);
    }
}
