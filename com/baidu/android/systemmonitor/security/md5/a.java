package com.baidu.android.systemmonitor.security.md5;
/* loaded from: classes.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    int[] f702a;
    long b;
    byte[] c;

    public a() {
        this.c = new byte[64];
        this.b = 0L;
        this.f702a = new int[4];
        this.f702a[0] = 1732584193;
        this.f702a[1] = -271733879;
        this.f702a[2] = -1732584194;
        this.f702a[3] = 271733878;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(a aVar) {
        this();
        for (int i = 0; i < this.c.length; i++) {
            this.c[i] = aVar.c[i];
        }
        for (int i2 = 0; i2 < this.f702a.length; i2++) {
            this.f702a[i2] = aVar.f702a[i2];
        }
        this.b = aVar.b;
    }
}
