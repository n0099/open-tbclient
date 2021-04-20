package com.baidu.mobads.cid.cesium.a;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static int f8036a = 5;

    /* renamed from: b  reason: collision with root package name */
    public static int f8037b = 40;

    /* renamed from: c  reason: collision with root package name */
    public b f8038c;

    public f() {
        b bVar = new b(f8037b);
        this.f8038c = bVar;
        bVar.a(0, f8037b, true);
    }

    public void a(b bVar, int i, int i2, int i3) {
        b c2 = this.f8038c.c(i, i + i2);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    c2.d(bVar);
                } else if (i3 == 3) {
                    c2.b(bVar);
                }
            }
            c2.c(bVar);
        } else {
            c2.a(bVar);
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.f8038c.a(i + i4, c2.c(i4));
        }
    }

    public byte[] a() {
        return this.f8038c.a();
    }
}
