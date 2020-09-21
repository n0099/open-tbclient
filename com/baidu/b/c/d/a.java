package com.baidu.b.c.d;
/* loaded from: classes3.dex */
public class a {
    private c adl;

    private a() {
    }

    public static a sL() {
        a aVar = new a();
        aVar.adl = new c();
        aVar.adl.a("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.adl.a(i, dVar, b.adf);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.adl.k(bArr, 0, bArr.length);
    }
}
