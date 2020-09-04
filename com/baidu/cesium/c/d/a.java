package com.baidu.cesium.c.d;
/* loaded from: classes9.dex */
public class a {
    private c alK;

    private a() {
    }

    public static a up() {
        a aVar = new a();
        aVar.alK = new c();
        aVar.alK.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.alK.a(i, dVar, b.acM);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.alK.k(bArr, 0, bArr.length);
    }
}
