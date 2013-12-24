package com.baidu.android.systemmonitor.security.md5;
/* loaded from: classes.dex */
class a {
    int[] a;
    long b;
    byte[] c;

    public a() {
        this.c = new byte[64];
        this.b = 0L;
        this.a = new int[4];
        this.a[0] = 1732584193;
        this.a[1] = -271733879;
        this.a[2] = -1732584194;
        this.a[3] = 271733878;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(a aVar) {
        this();
        for (int i = 0; i < this.c.length; i++) {
            this.c[i] = aVar.c[i];
        }
        for (int i2 = 0; i2 < this.a.length; i2++) {
            this.a[i2] = aVar.a[i2];
        }
        this.b = aVar.b;
    }
}
