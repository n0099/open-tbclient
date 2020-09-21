package com.baidu.helios.common.a;
/* loaded from: classes25.dex */
public class a {
    private com.baidu.helios.common.a.a.a.b axn;

    private a() {
    }

    public static a Ar() {
        a aVar = new a();
        aVar.axn = new com.baidu.helios.common.a.a.a.b();
        aVar.axn.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, com.baidu.helios.common.a.b.a aVar) {
        this.axn.a(i, aVar, com.baidu.helios.common.a.a.a.a.adf);
    }

    public final byte[] z(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.axn.k(bArr, 0, bArr.length);
    }
}
