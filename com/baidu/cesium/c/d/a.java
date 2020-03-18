package com.baidu.cesium.c.d;
/* loaded from: classes13.dex */
public class a {
    private c Qg;

    private a() {
    }

    public static a nG() {
        a aVar = new a();
        aVar.Qg = new c();
        aVar.Qg.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.Qg.a(i, dVar, b.PZ);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.Qg.j(bArr, 0, bArr.length);
    }
}
