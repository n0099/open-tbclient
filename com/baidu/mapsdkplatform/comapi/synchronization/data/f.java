package com.baidu.mapsdkplatform.comapi.synchronization.data;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f7843a;

    /* renamed from: b  reason: collision with root package name */
    public String f7844b;

    /* renamed from: c  reason: collision with root package name */
    public String f7845c;

    /* renamed from: d  reason: collision with root package name */
    public b f7846d;

    /* renamed from: e  reason: collision with root package name */
    public int f7847e;

    /* renamed from: f  reason: collision with root package name */
    public int f7848f;

    /* renamed from: g  reason: collision with root package name */
    public a f7849g;

    /* renamed from: h  reason: collision with root package name */
    public String f7850h;

    /* renamed from: i  reason: collision with root package name */
    public String f7851i;
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
        this.f7846d = b.DRIVING;
        this.f7848f = 15;
        this.f7849g = a.BD09LL;
        this.f7846d = b.DRIVING;
        this.f7849g = a.BD09LL;
        this.f7848f = 15;
    }

    public String a() {
        return this.f7843a;
    }

    public void a(int i2) {
        this.f7847e = i2;
    }

    public void a(String str) {
        this.f7843a = str;
    }

    public String b() {
        return this.f7844b;
    }

    public void b(String str) {
        this.f7844b = str;
    }

    public String c() {
        return this.f7845c;
    }

    public void c(String str) {
        this.f7845c = str;
    }

    public String d() {
        return this.f7850h;
    }

    public void d(String str) {
        this.f7850h = str;
    }

    public String e() {
        return this.f7851i;
    }

    public void e(String str) {
        this.f7851i = str;
    }

    public a f() {
        return this.f7849g;
    }

    public b g() {
        return this.f7846d;
    }

    public int h() {
        return this.f7847e;
    }

    public int i() {
        return this.f7848f;
    }

    public int j() {
        return this.j;
    }
}
