package com.baidu.helios.common.a;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.helios.common.a.a.a.b arQ;

    private a() {
    }

    public static a uG() {
        a aVar = new a();
        aVar.arQ = new com.baidu.helios.common.a.a.a.b();
        aVar.arQ.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, com.baidu.helios.common.a.b.a aVar) {
        this.arQ.a(i, aVar, com.baidu.helios.common.a.a.a.a.akD);
    }

    public final byte[] y(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.arQ.l(bArr, 0, bArr.length);
    }
}
