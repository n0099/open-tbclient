package com.baidu.cesium.c.d;
/* loaded from: classes5.dex */
public class a {
    private c ank;

    private a() {
    }

    public static a tK() {
        a aVar = new a();
        aVar.ank = new c();
        aVar.ank.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.ank.a(i, dVar, b.ane);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.ank.l(bArr, 0, bArr.length);
    }
}
