package com.baidu.helios.common.a;
/* loaded from: classes14.dex */
public class a {
    private com.baidu.helios.common.a.a.a.b auh;

    private a() {
    }

    public static a ve() {
        a aVar = new a();
        aVar.auh = new com.baidu.helios.common.a.a.a.b();
        aVar.auh.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, com.baidu.helios.common.a.b.a aVar) {
        this.auh.a(i, aVar, com.baidu.helios.common.a.a.a.a.aoD);
    }

    public final byte[] x(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.auh.l(bArr, 0, bArr.length);
    }
}
