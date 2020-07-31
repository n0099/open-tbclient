package com.baidu.helios.common.a;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.helios.common.a.a.a.b arM;

    private a() {
    }

    public static a uG() {
        a aVar = new a();
        aVar.arM = new com.baidu.helios.common.a.a.a.b();
        aVar.arM.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, com.baidu.helios.common.a.b.a aVar) {
        this.arM.a(i, aVar, com.baidu.helios.common.a.a.a.a.aky);
    }

    public final byte[] y(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.arM.l(bArr, 0, bArr.length);
    }
}
