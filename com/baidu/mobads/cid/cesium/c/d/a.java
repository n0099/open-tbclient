package com.baidu.mobads.cid.cesium.c.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public c f8160a;

    public static a a() {
        a aVar = new a();
        c cVar = new c();
        aVar.f8160a = cVar;
        cVar.a("PKCS1Padding");
        return aVar;
    }

    public void a(int i, d dVar) {
        this.f8160a.a(i, dVar, b.f8161a);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr != null) {
            return this.f8160a.a(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("Null input buffer");
    }
}
