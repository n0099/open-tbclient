package com.baidu.b.c.d;
/* loaded from: classes20.dex */
public class a {
    private c acQ;

    private a() {
    }

    public static a sG() {
        a aVar = new a();
        aVar.acQ = new c();
        aVar.acQ.a("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.acQ.a(i, dVar, b.acK);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.acQ.k(bArr, 0, bArr.length);
    }
}
