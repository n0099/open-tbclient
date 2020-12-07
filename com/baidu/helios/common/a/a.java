package com.baidu.helios.common.a;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.helios.common.a.a.a.b axk;

    private a() {
    }

    public static a zI() {
        a aVar = new a();
        aVar.axk = new com.baidu.helios.common.a.a.a.b();
        aVar.axk.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, com.baidu.helios.common.a.b.a aVar) {
        this.axk.a(i, aVar, com.baidu.helios.common.a.a.a.a.aex);
    }

    public final byte[] z(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.axk.k(bArr, 0, bArr.length);
    }
}
