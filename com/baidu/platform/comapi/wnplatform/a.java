package com.baidu.platform.comapi.wnplatform;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f10235a;

    /* renamed from: b  reason: collision with root package name */
    public int f10236b;

    /* renamed from: c  reason: collision with root package name */
    public int f10237c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10238d;

    /* renamed from: e  reason: collision with root package name */
    public int f10239e;

    /* renamed from: com.baidu.platform.comapi.wnplatform.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0128a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f10240a = new a();
    }

    public static a a() {
        return C0128a.f10240a;
    }

    public boolean b() {
        return (this.f10236b & 1) == 1;
    }

    public boolean c() {
        return (this.f10236b & 2) == 2;
    }

    public boolean d() {
        return (this.f10236b & 4) == 4;
    }

    public int e() {
        return this.f10236b;
    }

    public boolean f() {
        return this.f10235a == 0;
    }

    public boolean g() {
        int i = this.f10235a;
        return i == 1 || i == 2;
    }

    public int h() {
        return this.f10237c;
    }

    public boolean i() {
        return this.f10238d;
    }

    public a() {
        this.f10239e = 0;
    }

    public void a(int i) {
        this.f10236b = i;
        if (a().i()) {
            return;
        }
        this.f10236b &= -5;
    }

    public void b(int i) {
        this.f10235a = i;
    }

    public void c(int i) {
        this.f10237c = i;
    }
}
