package com.baidu.mapsdkplatform.comapi.synchronization.data;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f7785a;

    /* renamed from: b  reason: collision with root package name */
    public String f7786b;

    /* renamed from: c  reason: collision with root package name */
    public String f7787c;

    /* renamed from: d  reason: collision with root package name */
    public b f7788d;

    /* renamed from: e  reason: collision with root package name */
    public int f7789e;

    /* renamed from: f  reason: collision with root package name */
    public int f7790f;

    /* renamed from: g  reason: collision with root package name */
    public a f7791g;

    /* renamed from: h  reason: collision with root package name */
    public String f7792h;
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
        this.f7788d = b.DRIVING;
        this.f7790f = 15;
        this.f7791g = a.BD09LL;
        this.f7788d = b.DRIVING;
        this.f7791g = a.BD09LL;
        this.f7790f = 15;
    }

    public String a() {
        return this.f7785a;
    }

    public void a(int i) {
        this.f7789e = i;
    }

    public void a(String str) {
        this.f7785a = str;
    }

    public String b() {
        return this.f7786b;
    }

    public void b(String str) {
        this.f7786b = str;
    }

    public String c() {
        return this.f7787c;
    }

    public void c(String str) {
        this.f7787c = str;
    }

    public String d() {
        return this.f7792h;
    }

    public void d(String str) {
        this.f7792h = str;
    }

    public String e() {
        return this.i;
    }

    public void e(String str) {
        this.i = str;
    }

    public a f() {
        return this.f7791g;
    }

    public b g() {
        return this.f7788d;
    }

    public int h() {
        return this.f7789e;
    }

    public int i() {
        return this.f7790f;
    }

    public int j() {
        return this.j;
    }
}
