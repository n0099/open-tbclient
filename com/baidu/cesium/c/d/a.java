package com.baidu.cesium.c.d;
/* loaded from: classes6.dex */
public class a {
    private c amB;

    private a() {
    }

    public static a uv() {
        a aVar = new a();
        aVar.amB = new c();
        aVar.amB.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.amB.a(i, dVar, b.adv);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.amB.k(bArr, 0, bArr.length);
    }
}
