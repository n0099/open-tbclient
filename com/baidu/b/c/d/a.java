package com.baidu.b.c.d;
/* loaded from: classes7.dex */
public class a {
    private c adH;

    private a() {
    }

    public static a sL() {
        a aVar = new a();
        aVar.adH = new c();
        aVar.adH.a("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.adH.a(i, dVar, b.adB);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.adH.k(bArr, 0, bArr.length);
    }
}
