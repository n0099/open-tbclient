package com.baidu.cesium.c.d;
/* loaded from: classes13.dex */
public class a {
    private c Qf;

    private a() {
    }

    public static a nH() {
        a aVar = new a();
        aVar.Qf = new c();
        aVar.Qf.b("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.Qf.a(i, dVar, b.PY);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Null input buffer");
        }
        return this.Qf.j(bArr, 0, bArr.length);
    }
}
