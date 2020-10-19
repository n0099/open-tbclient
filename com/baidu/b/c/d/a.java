package com.baidu.b.c.d;
/* loaded from: classes7.dex */
public class a {
    private c adB;

    private a() {
    }

    public static a sL() {
        a aVar = new a();
        aVar.adB = new c();
        aVar.adB.a("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.adB.a(i, dVar, b.adv);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.adB.k(bArr, 0, bArr.length);
    }
}
