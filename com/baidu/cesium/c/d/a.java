package com.baidu.cesium.c.d;
/* loaded from: classes6.dex */
public class a {
    private c anu;

    private a() {
    }

    public static a tN() {
        a aVar = new a();
        aVar.anu = new c();
        aVar.anu.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.anu.a(i, dVar, b.ano);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.anu.l(bArr, 0, bArr.length);
    }
}
