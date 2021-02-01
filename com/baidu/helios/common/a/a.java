package com.baidu.helios.common.a;
/* loaded from: classes5.dex */
public class a {
    private com.baidu.helios.common.a.a.a.b asH;

    private a() {
    }

    public static a vb() {
        a aVar = new a();
        aVar.asH = new com.baidu.helios.common.a.a.a.b();
        aVar.asH.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, com.baidu.helios.common.a.b.a aVar) {
        this.asH.a(i, aVar, com.baidu.helios.common.a.a.a.a.ane);
    }

    public final byte[] v(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.asH.l(bArr, 0, bArr.length);
    }
}
