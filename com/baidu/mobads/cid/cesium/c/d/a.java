package com.baidu.mobads.cid.cesium.c.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public c f8265a;

    public static a a() {
        a aVar = new a();
        c cVar = new c();
        aVar.f8265a = cVar;
        cVar.a("PKCS1Padding");
        return aVar;
    }

    public void a(int i2, d dVar) {
        this.f8265a.a(i2, dVar, b.f8266a);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr != null) {
            return this.f8265a.a(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
