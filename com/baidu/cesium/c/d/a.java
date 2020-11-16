package com.baidu.cesium.c.d;
/* loaded from: classes19.dex */
public class a {
    private c amI;

    private a() {
    }

    public static a uu() {
        a aVar = new a();
        aVar.amI = new c();
        aVar.amI.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.amI.a(i, dVar, b.adB);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.amI.k(bArr, 0, bArr.length);
    }
}
