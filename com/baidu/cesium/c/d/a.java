package com.baidu.cesium.c.d;
/* loaded from: classes3.dex */
public class a {
    private c akE;

    private a() {
    }

    public static a sF() {
        a aVar = new a();
        aVar.akE = new c();
        aVar.akE.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.akE.a(i, dVar, b.aky);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.akE.l(bArr, 0, bArr.length);
    }
}
