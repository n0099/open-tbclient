package com.baidu.mapsdkplatform.comapi.synchronization.data;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f8103a;

    /* renamed from: b  reason: collision with root package name */
    public String f8104b;

    /* renamed from: c  reason: collision with root package name */
    public String f8105c;

    /* renamed from: d  reason: collision with root package name */
    public b f8106d;

    /* renamed from: e  reason: collision with root package name */
    public int f8107e;

    /* renamed from: f  reason: collision with root package name */
    public int f8108f;

    /* renamed from: g  reason: collision with root package name */
    public a f8109g;

    /* renamed from: h  reason: collision with root package name */
    public String f8110h;

    /* renamed from: i  reason: collision with root package name */
    public String f8111i;
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
        this.f8106d = b.DRIVING;
        this.f8108f = 15;
        this.f8109g = a.BD09LL;
        this.f8106d = b.DRIVING;
        this.f8109g = a.BD09LL;
        this.f8108f = 15;
    }

    public String a() {
        return this.f8103a;
    }

    public void a(int i2) {
        this.f8107e = i2;
    }

    public void a(String str) {
        this.f8103a = str;
    }

    public String b() {
        return this.f8104b;
    }

    public void b(String str) {
        this.f8104b = str;
    }

    public String c() {
        return this.f8105c;
    }

    public void c(String str) {
        this.f8105c = str;
    }

    public String d() {
        return this.f8110h;
    }

    public void d(String str) {
        this.f8110h = str;
    }

    public String e() {
        return this.f8111i;
    }

    public void e(String str) {
        this.f8111i = str;
    }

    public a f() {
        return this.f8109g;
    }

    public b g() {
        return this.f8106d;
    }

    public int h() {
        return this.f8107e;
    }

    public int i() {
        return this.f8108f;
    }

    public int j() {
        return this.j;
    }
}
