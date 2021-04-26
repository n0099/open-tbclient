package com.baidu.platform.comapi.wnplatform;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f10158a;

    /* renamed from: b  reason: collision with root package name */
    public int f10159b;

    /* renamed from: c  reason: collision with root package name */
    public int f10160c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10161d;

    /* renamed from: e  reason: collision with root package name */
    public int f10162e;

    /* renamed from: com.baidu.platform.comapi.wnplatform.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0128a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f10163a = new a();
    }

    public static a a() {
        return C0128a.f10163a;
    }

    public boolean b() {
        return (this.f10159b & 1) == 1;
    }

    public boolean c() {
        return (this.f10159b & 2) == 2;
    }

    public boolean d() {
        return (this.f10159b & 4) == 4;
    }

    public int e() {
        return this.f10159b;
    }

    public boolean f() {
        return this.f10158a == 0;
    }

    public boolean g() {
        int i2 = this.f10158a;
        return i2 == 1 || i2 == 2;
    }

    public int h() {
        return this.f10160c;
    }

    public boolean i() {
        return this.f10161d;
    }

    public a() {
        this.f10162e = 0;
    }

    public void a(int i2) {
        this.f10159b = i2;
        if (a().i()) {
            return;
        }
        this.f10159b &= -5;
    }

    public void b(int i2) {
        this.f10158a = i2;
    }

    public void c(int i2) {
        this.f10160c = i2;
    }
}
