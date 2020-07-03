package com.baidu.cesium.c.d;
/* loaded from: classes13.dex */
public class a {
    private c akJ;

    private a() {
    }

    public static a sD() {
        a aVar = new a();
        aVar.akJ = new c();
        aVar.akJ.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.akJ.a(i, dVar, b.akD);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.akJ.l(bArr, 0, bArr.length);
    }
}
