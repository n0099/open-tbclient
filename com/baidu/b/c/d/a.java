package com.baidu.b.c.d;
/* loaded from: classes7.dex */
public class a {
    private c adC;

    private a() {
    }

    public static a sL() {
        a aVar = new a();
        aVar.adC = new c();
        aVar.adC.a("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.adC.a(i, dVar, b.adw);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.adC.k(bArr, 0, bArr.length);
    }
}
