package com.baidu.location;
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    protected String f475a;
    protected String b;
    protected boolean c;
    protected int d;
    protected int e;
    protected String f;
    protected int g;
    protected boolean h;
    protected boolean i;
    protected boolean j;
    protected boolean k;
    protected float l;
    protected int m;
    protected String n;

    public j() {
        this.f475a = "gcj02";
        this.b = "detail";
        this.c = false;
        this.d = 0;
        this.e = 12000;
        this.f = "SDK2.0";
        this.g = 1;
        this.h = false;
        this.i = true;
        this.j = false;
        this.k = false;
        this.l = 500.0f;
        this.m = 3;
        this.n = "com.baidu.location.service_v2.9";
    }

    public j(j jVar) {
        this.f475a = "gcj02";
        this.b = "detail";
        this.c = false;
        this.d = 0;
        this.e = 12000;
        this.f = "SDK2.0";
        this.g = 1;
        this.h = false;
        this.i = true;
        this.j = false;
        this.k = false;
        this.l = 500.0f;
        this.m = 3;
        this.n = "com.baidu.location.service_v2.9";
        this.f475a = jVar.f475a;
        this.b = jVar.b;
        this.c = jVar.c;
        this.d = jVar.d;
        this.e = jVar.e;
        this.f = jVar.f;
        this.g = jVar.g;
        this.h = jVar.h;
        this.k = jVar.k;
        this.l = jVar.l;
        this.m = jVar.m;
        this.n = jVar.n;
        this.i = jVar.i;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("gcj02") || lowerCase.equals("bd09") || lowerCase.equals("bd09ll")) {
            this.f475a = lowerCase;
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean a() {
        return this.i;
    }

    public boolean a(j jVar) {
        return this.f475a.equals(jVar.f475a) && this.b.equals(jVar.b) && this.c == jVar.c && this.d == jVar.d && this.e == jVar.e && this.f.equals(jVar.f) && this.h == jVar.h && this.g == jVar.g && this.m == jVar.m && this.k == jVar.k && this.l == jVar.l && this.i == jVar.i;
    }

    public void b(String str) {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        this.b = str;
    }

    public void b(boolean z) {
        this.i = z;
    }

    public void c(String str) {
        if (str.length() > 64) {
            str = str.substring(0, 64);
        }
        this.f = str;
    }

    public void d(String str) {
        this.n = str;
    }
}
