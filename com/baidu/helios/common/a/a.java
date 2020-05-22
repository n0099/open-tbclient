package com.baidu.helios.common.a;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.helios.common.a.a.a.b aqy;

    private a() {
    }

    public static a uo() {
        a aVar = new a();
        aVar.aqy = new com.baidu.helios.common.a.a.a.b();
        aVar.aqy.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, com.baidu.helios.common.a.b.a aVar) {
        this.aqy.a(i, aVar, com.baidu.helios.common.a.a.a.a.ajh);
    }

    public final byte[] w(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.aqy.l(bArr, 0, bArr.length);
    }
}
