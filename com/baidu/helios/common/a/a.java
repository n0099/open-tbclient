package com.baidu.helios.common.a;
/* loaded from: classes15.dex */
public class a {
    private com.baidu.helios.common.a.a.a.b axD;

    private a() {
    }

    public static a yZ() {
        a aVar = new a();
        aVar.axD = new com.baidu.helios.common.a.a.a.b();
        aVar.axD.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, com.baidu.helios.common.a.b.a aVar) {
        this.axD.a(i, aVar, com.baidu.helios.common.a.a.a.a.afc);
    }

    public final byte[] w(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.axD.k(bArr, 0, bArr.length);
    }
}
