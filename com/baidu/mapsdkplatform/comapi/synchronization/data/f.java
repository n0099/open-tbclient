package com.baidu.mapsdkplatform.comapi.synchronization.data;
/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private String f3118a;

    /* renamed from: b  reason: collision with root package name */
    private String f3119b;
    private String c;
    private b d;
    private int e;
    private int f;
    private a g;
    private String h;
    private String i;
    private int j;

    /* loaded from: classes4.dex */
    public enum a {
        GPS,
        COMMON,
        BD09LL,
        BD09MC
    }

    /* loaded from: classes4.dex */
    public enum b {
        DRIVING,
        RIDING
    }

    public f() {
        this.d = b.DRIVING;
        this.f = 15;
        this.g = a.BD09LL;
        this.d = b.DRIVING;
        this.g = a.BD09LL;
        this.f = 15;
    }

    public String a() {
        return this.f3118a;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(String str) {
        this.f3118a = str;
    }

    public String b() {
        return this.f3119b;
    }

    public void b(String str) {
        this.f3119b = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String d() {
        return this.h;
    }

    public void d(String str) {
        this.h = str;
    }

    public String e() {
        return this.i;
    }

    public void e(String str) {
        this.i = str;
    }

    public a f() {
        return this.g;
    }

    public b g() {
        return this.d;
    }

    public int h() {
        return this.e;
    }

    public int i() {
        return this.f;
    }

    public int j() {
        return this.j;
    }
}
