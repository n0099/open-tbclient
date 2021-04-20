package com.baidu.platform.comapi.wnplatform;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f9794a;

    /* renamed from: b  reason: collision with root package name */
    public int f9795b;

    /* renamed from: c  reason: collision with root package name */
    public int f9796c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9797d;

    /* renamed from: e  reason: collision with root package name */
    public int f9798e;

    /* renamed from: com.baidu.platform.comapi.wnplatform.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0128a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f9799a = new a();
    }

    public static a a() {
        return C0128a.f9799a;
    }

    public boolean b() {
        return (this.f9795b & 1) == 1;
    }

    public boolean c() {
        return (this.f9795b & 2) == 2;
    }

    public boolean d() {
        return (this.f9795b & 4) == 4;
    }

    public int e() {
        return this.f9795b;
    }

    public boolean f() {
        return this.f9794a == 0;
    }

    public boolean g() {
        int i = this.f9794a;
        return i == 1 || i == 2;
    }

    public int h() {
        return this.f9796c;
    }

    public boolean i() {
        return this.f9797d;
    }

    public a() {
        this.f9798e = 0;
    }

    public void a(int i) {
        this.f9795b = i;
        if (a().i()) {
            return;
        }
        this.f9795b &= -5;
    }

    public void b(int i) {
        this.f9794a = i;
    }

    public void c(int i) {
        this.f9796c = i;
    }
}
