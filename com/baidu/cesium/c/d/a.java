package com.baidu.cesium.c.d;
/* loaded from: classes13.dex */
public class a {
    private c ajn;

    private a() {
    }

    public static a si() {
        a aVar = new a();
        aVar.ajn = new c();
        aVar.ajn.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.ajn.a(i, dVar, b.ajh);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.ajn.l(bArr, 0, bArr.length);
    }
}
