package com.baidu.b.a;
/* loaded from: classes7.dex */
class f {

    /* renamed from: a  reason: collision with root package name */
    public static int f1243a = 5;
    public static int b = 40;
    private b acP = new b(b);

    public f() {
        this.acP.a(0, b, true);
    }

    public void a(b bVar, int i, int i2, int i3) {
        b c = this.acP.c(i, i + i2);
        switch (i3) {
            case 0:
                c.a(bVar);
                break;
            case 1:
                c.c(bVar);
                break;
            case 2:
                c.d(bVar);
                break;
            case 3:
                c.b(bVar);
                break;
            default:
                c.c(bVar);
                break;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.acP.a(i + i4, c.c(i4));
        }
    }

    public byte[] a() {
        return this.acP.a();
    }
}
