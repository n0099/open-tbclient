package com.baidu.cesium.c.d;
/* loaded from: classes18.dex */
public class a {
    private c amj;

    private a() {
    }

    public static a uv() {
        a aVar = new a();
        aVar.amj = new c();
        aVar.amj.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.amj.a(i, dVar, b.adf);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.amj.k(bArr, 0, bArr.length);
    }
}
