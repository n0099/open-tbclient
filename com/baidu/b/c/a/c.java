package com.baidu.b.c.a;

import java.security.SecureRandom;
/* loaded from: classes20.dex */
public class c {
    public static final SecureRandom acM = new SecureRandom();
    private e acN;

    public c() {
        this.acN = null;
        this.acN = new e(new b(), 16);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        c cVar = new c();
        cVar.a(2, bArr, bArr2);
        return cVar.a(bArr3);
    }

    public void a(int i, byte[] bArr, byte[] bArr2) {
        this.acN.a(i, bArr, bArr2, acM);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.acN.k(bArr, 0, bArr.length);
    }
}
