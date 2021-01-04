package com.baidu.cesium.c.d;
/* loaded from: classes4.dex */
public class a {
    private c aoj;

    private a() {
    }

    public static a tW() {
        a aVar = new a();
        aVar.aoj = new c();
        aVar.aoj.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.aoj.a(i, dVar, b.afc);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.aoj.k(bArr, 0, bArr.length);
    }
}
