package com.baidu.platform.comapi.wnplatform;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f10236a;

    /* renamed from: b  reason: collision with root package name */
    public int f10237b;

    /* renamed from: c  reason: collision with root package name */
    public int f10238c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10239d;

    /* renamed from: e  reason: collision with root package name */
    public int f10240e;

    /* renamed from: com.baidu.platform.comapi.wnplatform.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0129a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f10241a = new a();
    }

    public static a a() {
        return C0129a.f10241a;
    }

    public boolean b() {
        return (this.f10237b & 1) == 1;
    }

    public boolean c() {
        return (this.f10237b & 2) == 2;
    }

    public boolean d() {
        return (this.f10237b & 4) == 4;
    }

    public int e() {
        return this.f10237b;
    }

    public boolean f() {
        return this.f10236a == 0;
    }

    public boolean g() {
        int i = this.f10236a;
        return i == 1 || i == 2;
    }

    public int h() {
        return this.f10238c;
    }

    public boolean i() {
        return this.f10239d;
    }

    public a() {
        this.f10240e = 0;
    }

    public void a(int i) {
        this.f10237b = i;
        if (a().i()) {
            return;
        }
        this.f10237b &= -5;
    }

    public void b(int i) {
        this.f10236a = i;
    }

    public void c(int i) {
        this.f10238c = i;
    }
}
