package com.baidu.helios.common.a;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.helios.common.a.a.a.b awJ;

    private a() {
    }

    public static a Ad() {
        a aVar = new a();
        aVar.awJ = new com.baidu.helios.common.a.a.a.b();
        aVar.awJ.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, com.baidu.helios.common.a.b.a aVar) {
        this.awJ.a(i, aVar, com.baidu.helios.common.a.a.a.a.acK);
    }

    public final byte[] z(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.awJ.k(bArr, 0, bArr.length);
    }
}
