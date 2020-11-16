package com.baidu.helios.common.cc;
/* loaded from: classes10.dex */
class d {
    public static int c = 5;
    public static int d = 40;
    private a awk = new a(d);

    public d() {
        this.awk.a(0, d, true);
    }

    public void a(a aVar, int i, int i2, int i3) {
        a d2 = this.awk.d(i, i + i2);
        switch (i3) {
            case 0:
                d2.b(aVar);
                break;
            case 1:
                d2.d(aVar);
                break;
            case 2:
                d2.e(aVar);
                break;
            case 3:
                d2.c(aVar);
                break;
            default:
                d2.d(aVar);
                break;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.awk.a(i + i4, d2.d(i4));
        }
    }

    public byte[] b() {
        return this.awk.a();
    }
}
