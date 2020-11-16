package com.baidu.helios.common.a;
/* loaded from: classes18.dex */
public class a {
    private com.baidu.helios.common.a.a.a.b awm;

    private a() {
    }

    public static a zQ() {
        a aVar = new a();
        aVar.awm = new com.baidu.helios.common.a.a.a.b();
        aVar.awm.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, com.baidu.helios.common.a.b.a aVar) {
        this.awm.a(i, aVar, com.baidu.helios.common.a.a.a.a.adB);
    }

    public final byte[] z(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.awm.k(bArr, 0, bArr.length);
    }
}
