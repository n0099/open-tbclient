package com.baidu.cesium.a;
/* loaded from: classes13.dex */
class e {
    public static int c = 5;
    public static int d = 40;
    private b aiy = new b(d);

    public e() {
        this.aiy.a(0, d, true);
    }

    public void a(b bVar, int i, int i2, int i3) {
        b d2 = this.aiy.d(i, i + i2);
        switch (i3) {
            case 0:
                d2.b(bVar);
                break;
            case 1:
                d2.d(bVar);
                break;
            case 2:
                d2.e(bVar);
                break;
            case 3:
                d2.c(bVar);
                break;
            default:
                d2.d(bVar);
                break;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.aiy.a(i + i4, d2.d(i4));
        }
    }

    public byte[] b() {
        return this.aiy.a();
    }
}
