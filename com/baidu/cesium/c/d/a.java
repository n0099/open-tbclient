package com.baidu.cesium.c.d;
/* loaded from: classes13.dex */
public class a {
    private c aiJ;

    private a() {
    }

    public static a rY() {
        a aVar = new a();
        aVar.aiJ = new c();
        aVar.aiJ.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.aiJ.a(i, dVar, b.aiD);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.aiJ.l(bArr, 0, bArr.length);
    }
}
