package com.baidu.mapsdkplatform.comapi.synchronization.data;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f7900a;

    /* renamed from: b  reason: collision with root package name */
    public String f7901b;

    /* renamed from: c  reason: collision with root package name */
    public String f7902c;

    /* renamed from: d  reason: collision with root package name */
    public b f7903d;

    /* renamed from: e  reason: collision with root package name */
    public int f7904e;

    /* renamed from: f  reason: collision with root package name */
    public int f7905f;

    /* renamed from: g  reason: collision with root package name */
    public a f7906g;

    /* renamed from: h  reason: collision with root package name */
    public String f7907h;

    /* renamed from: i  reason: collision with root package name */
    public String f7908i;
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
        this.f7903d = b.DRIVING;
        this.f7905f = 15;
        this.f7906g = a.BD09LL;
        this.f7903d = b.DRIVING;
        this.f7906g = a.BD09LL;
        this.f7905f = 15;
    }

    public String a() {
        return this.f7900a;
    }

    public void a(int i2) {
        this.f7904e = i2;
    }

    public void a(String str) {
        this.f7900a = str;
    }

    public String b() {
        return this.f7901b;
    }

    public void b(String str) {
        this.f7901b = str;
    }

    public String c() {
        return this.f7902c;
    }

    public void c(String str) {
        this.f7902c = str;
    }

    public String d() {
        return this.f7907h;
    }

    public void d(String str) {
        this.f7907h = str;
    }

    public String e() {
        return this.f7908i;
    }

    public void e(String str) {
        this.f7908i = str;
    }

    public a f() {
        return this.f7906g;
    }

    public b g() {
        return this.f7903d;
    }

    public int h() {
        return this.f7904e;
    }

    public int i() {
        return this.f7905f;
    }

    public int j() {
        return this.j;
    }
}
