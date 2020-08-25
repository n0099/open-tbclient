package com.baidu.cesium.c.d;
/* loaded from: classes9.dex */
public class a {
    private c alI;

    private a() {
    }

    public static a up() {
        a aVar = new a();
        aVar.alI = new c();
        aVar.alI.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.alI.a(i, dVar, b.acK);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.alI.k(bArr, 0, bArr.length);
    }
}
