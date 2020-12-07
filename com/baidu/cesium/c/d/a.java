package com.baidu.cesium.c.d;
/* loaded from: classes14.dex */
public class a {
    private c anH;

    private a() {
    }

    public static a ux() {
        a aVar = new a();
        aVar.anH = new c();
        aVar.anH.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.anH.a(i, dVar, b.aex);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.anH.k(bArr, 0, bArr.length);
    }
}
