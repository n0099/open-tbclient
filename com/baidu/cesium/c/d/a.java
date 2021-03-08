package com.baidu.cesium.c.d;
/* loaded from: classes6.dex */
public class a {
    private c aoJ;

    private a() {
    }

    public static a tK() {
        a aVar = new a();
        aVar.aoJ = new c();
        aVar.aoJ.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.aoJ.a(i, dVar, b.aoD);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.aoJ.l(bArr, 0, bArr.length);
    }
}
