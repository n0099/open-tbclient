package com.baidu.mapsdkplatform.comapi.synchronization.data;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f7800a;

    /* renamed from: b  reason: collision with root package name */
    public String f7801b;

    /* renamed from: c  reason: collision with root package name */
    public String f7802c;

    /* renamed from: d  reason: collision with root package name */
    public b f7803d;

    /* renamed from: e  reason: collision with root package name */
    public int f7804e;

    /* renamed from: f  reason: collision with root package name */
    public int f7805f;

    /* renamed from: g  reason: collision with root package name */
    public a f7806g;

    /* renamed from: h  reason: collision with root package name */
    public String f7807h;

    /* renamed from: i  reason: collision with root package name */
    public String f7808i;
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
        this.f7803d = b.DRIVING;
        this.f7805f = 15;
        this.f7806g = a.BD09LL;
        this.f7803d = b.DRIVING;
        this.f7806g = a.BD09LL;
        this.f7805f = 15;
    }

    public String a() {
        return this.f7800a;
    }

    public void a(int i2) {
        this.f7804e = i2;
    }

    public void a(String str) {
        this.f7800a = str;
    }

    public String b() {
        return this.f7801b;
    }

    public void b(String str) {
        this.f7801b = str;
    }

    public String c() {
        return this.f7802c;
    }

    public void c(String str) {
        this.f7802c = str;
    }

    public String d() {
        return this.f7807h;
    }

    public void d(String str) {
        this.f7807h = str;
    }

    public String e() {
        return this.f7808i;
    }

    public void e(String str) {
        this.f7808i = str;
    }

    public a f() {
        return this.f7806g;
    }

    public b g() {
        return this.f7803d;
    }

    public int h() {
        return this.f7804e;
    }

    public int i() {
        return this.f7805f;
    }

    public int j() {
        return this.j;
    }
}
