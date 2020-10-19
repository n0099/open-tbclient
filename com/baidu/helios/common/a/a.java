package com.baidu.helios.common.a;
/* loaded from: classes11.dex */
public class a {
    private com.baidu.helios.common.a.a.a.b axW;

    private a() {
    }

    public static a Az() {
        a aVar = new a();
        aVar.axW = new com.baidu.helios.common.a.a.a.b();
        aVar.axW.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, com.baidu.helios.common.a.b.a aVar) {
        this.axW.a(i, aVar, com.baidu.helios.common.a.a.a.a.adv);
    }

    public final byte[] z(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.axW.k(bArr, 0, bArr.length);
    }
}
