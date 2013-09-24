package com.baidu.android.systemmonitor.security.md5;
/* loaded from: classes.dex */
class b {

    /* renamed from: a  reason: collision with root package name */
    int[] f736a;
    long b;
    byte[] c;

    public b() {
        this.c = new byte[64];
        this.b = 0L;
        this.f736a = new int[4];
        this.f736a[0] = 1732584193;
        this.f736a[1] = -271733879;
        this.f736a[2] = -1732584194;
        this.f736a[3] = 271733878;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(b bVar) {
        this();
        for (int i = 0; i < this.c.length; i++) {
            this.c[i] = bVar.c[i];
        }
        for (int i2 = 0; i2 < this.f736a.length; i2++) {
            this.f736a[i2] = bVar.f736a[i2];
        }
        this.b = bVar.b;
    }
}
