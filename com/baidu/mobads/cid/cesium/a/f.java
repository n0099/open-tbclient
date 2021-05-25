package com.baidu.mobads.cid.cesium.a;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static int f8039a = 5;

    /* renamed from: b  reason: collision with root package name */
    public static int f8040b = 40;

    /* renamed from: c  reason: collision with root package name */
    public b f8041c;

    public f() {
        b bVar = new b(f8040b);
        this.f8041c = bVar;
        bVar.a(0, f8040b, true);
    }

    public void a(b bVar, int i2, int i3, int i4) {
        b c2 = this.f8041c.c(i2, i2 + i3);
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
            this.f8041c.a(i2 + i5, c2.c(i5));
        }
    }

    public byte[] a() {
        return this.f8041c.a();
    }
}
