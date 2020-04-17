package com.baidu.cesium.c.d;
/* loaded from: classes13.dex */
public class a {
    private c aiF;

    private a() {
    }

    public static a rZ() {
        a aVar = new a();
        aVar.aiF = new c();
        aVar.aiF.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.aiF.a(i, dVar, b.aiz);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.aiF.l(bArr, 0, bArr.length);
    }
}
