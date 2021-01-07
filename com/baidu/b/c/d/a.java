package com.baidu.b.c.d;
/* loaded from: classes3.dex */
public class a {
    private c afi;

    private a() {
    }

    public static a so() {
        a aVar = new a();
        aVar.afi = new c();
        aVar.afi.a("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.afi.a(i, dVar, b.afc);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.afi.k(bArr, 0, bArr.length);
    }
}
