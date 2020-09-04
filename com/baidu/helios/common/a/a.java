package com.baidu.helios.common.a;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.helios.common.a.a.a.b awL;

    private a() {
    }

    public static a Ad() {
        a aVar = new a();
        aVar.awL = new com.baidu.helios.common.a.a.a.b();
        aVar.awL.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, com.baidu.helios.common.a.b.a aVar) {
        this.awL.a(i, aVar, com.baidu.helios.common.a.a.a.a.acM);
    }

    public final byte[] z(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.awL.k(bArr, 0, bArr.length);
    }
}
