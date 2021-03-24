package com.baidu.mapsdkplatform.comapi.synchronization.data;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f7784a;

    /* renamed from: b  reason: collision with root package name */
    public String f7785b;

    /* renamed from: c  reason: collision with root package name */
    public String f7786c;

    /* renamed from: d  reason: collision with root package name */
    public b f7787d;

    /* renamed from: e  reason: collision with root package name */
    public int f7788e;

    /* renamed from: f  reason: collision with root package name */
    public int f7789f;

    /* renamed from: g  reason: collision with root package name */
    public a f7790g;

    /* renamed from: h  reason: collision with root package name */
    public String f7791h;
    public String i;
    public int j;

    /* loaded from: classes2.dex */
    public enum a {
        GPS,
        COMMON,
        BD09LL,
        BD09MC
    }

    /* loaded from: classes2.dex */
    public enum b {
        DRIVING,
        RIDING
    }

    public f() {
        this.f7787d = b.DRIVING;
        this.f7789f = 15;
        this.f7790g = a.BD09LL;
        this.f7787d = b.DRIVING;
        this.f7790g = a.BD09LL;
        this.f7789f = 15;
    }

    public String a() {
        return this.f7784a;
    }

    public void a(int i) {
        this.f7788e = i;
    }

    public void a(String str) {
        this.f7784a = str;
    }

    public String b() {
        return this.f7785b;
    }

    public void b(String str) {
        this.f7785b = str;
    }

    public String c() {
        return this.f7786c;
    }

    public void c(String str) {
        this.f7786c = str;
    }

    public String d() {
        return this.f7791h;
    }

    public void d(String str) {
        this.f7791h = str;
    }

    public String e() {
        return this.i;
    }

    public void e(String str) {
        this.i = str;
    }

    public a f() {
        return this.f7790g;
    }

    public b g() {
        return this.f7787d;
    }

    public int h() {
        return this.f7788e;
    }

    public int i() {
        return this.f7789f;
    }

    public int j() {
        return this.j;
    }
}
