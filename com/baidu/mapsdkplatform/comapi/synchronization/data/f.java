package com.baidu.mapsdkplatform.comapi.synchronization.data;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f7820a;

    /* renamed from: b  reason: collision with root package name */
    public String f7821b;

    /* renamed from: c  reason: collision with root package name */
    public String f7822c;

    /* renamed from: d  reason: collision with root package name */
    public b f7823d;

    /* renamed from: e  reason: collision with root package name */
    public int f7824e;

    /* renamed from: f  reason: collision with root package name */
    public int f7825f;

    /* renamed from: g  reason: collision with root package name */
    public a f7826g;

    /* renamed from: h  reason: collision with root package name */
    public String f7827h;
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
        this.f7823d = b.DRIVING;
        this.f7825f = 15;
        this.f7826g = a.BD09LL;
        this.f7823d = b.DRIVING;
        this.f7826g = a.BD09LL;
        this.f7825f = 15;
    }

    public String a() {
        return this.f7820a;
    }

    public void a(int i) {
        this.f7824e = i;
    }

    public void a(String str) {
        this.f7820a = str;
    }

    public String b() {
        return this.f7821b;
    }

    public void b(String str) {
        this.f7821b = str;
    }

    public String c() {
        return this.f7822c;
    }

    public void c(String str) {
        this.f7822c = str;
    }

    public String d() {
        return this.f7827h;
    }

    public void d(String str) {
        this.f7827h = str;
    }

    public String e() {
        return this.i;
    }

    public void e(String str) {
        this.i = str;
    }

    public a f() {
        return this.f7826g;
    }

    public b g() {
        return this.f7823d;
    }

    public int h() {
        return this.f7824e;
    }

    public int i() {
        return this.f7825f;
    }

    public int j() {
        return this.j;
    }
}
