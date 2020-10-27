package com.baidu.cesium.c.d;
/* loaded from: classes6.dex */
public class a {
    private c amC;

    private a() {
    }

    public static a uv() {
        a aVar = new a();
        aVar.amC = new c();
        aVar.amC.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.amC.a(i, dVar, b.adw);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.amC.k(bArr, 0, bArr.length);
    }
}
