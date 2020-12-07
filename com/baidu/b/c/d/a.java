package com.baidu.b.c.d;
/* loaded from: classes26.dex */
public class a {
    private c aeD;

    private a() {
    }

    public static a sO() {
        a aVar = new a();
        aVar.aeD = new c();
        aVar.aeD.a("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.aeD.a(i, dVar, b.aex);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.aeD.k(bArr, 0, bArr.length);
    }
}
