package com.baidu.mobads.cid.cesium.a;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static int f8139a = 5;

    /* renamed from: b  reason: collision with root package name */
    public static int f8140b = 40;

    /* renamed from: c  reason: collision with root package name */
    public b f8141c;

    public f() {
        b bVar = new b(f8140b);
        this.f8141c = bVar;
        bVar.a(0, f8140b, true);
    }

    public void a(b bVar, int i2, int i3, int i4) {
        b c2 = this.f8141c.c(i2, i2 + i3);
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    c2.d(bVar);
                } else if (i4 == 3) {
                    c2.b(bVar);
                }
            }
            c2.c(bVar);
        } else {
            c2.a(bVar);
        }
        for (int i5 = 0; i5 < i3; i5++) {
            this.f8141c.a(i2 + i5, c2.c(i5));
        }
    }

    public byte[] a() {
        return this.f8141c.a();
    }
}
