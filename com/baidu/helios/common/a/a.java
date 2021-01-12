package com.baidu.helios.common.a;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.helios.common.a.a.a.b asR;

    private a() {
    }

    public static a ve() {
        a aVar = new a();
        aVar.asR = new com.baidu.helios.common.a.a.a.b();
        aVar.asR.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, com.baidu.helios.common.a.b.a aVar) {
        this.asR.a(i, aVar, com.baidu.helios.common.a.a.a.a.ano);
    }

    public final byte[] v(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.asR.l(bArr, 0, bArr.length);
    }
}
