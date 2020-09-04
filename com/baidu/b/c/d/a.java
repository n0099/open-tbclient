package com.baidu.b.c.d;
/* loaded from: classes20.dex */
public class a {
    private c acS;

    private a() {
    }

    public static a sG() {
        a aVar = new a();
        aVar.acS = new c();
        aVar.acS.a("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.acS.a(i, dVar, b.acM);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.acS.k(bArr, 0, bArr.length);
    }
}
