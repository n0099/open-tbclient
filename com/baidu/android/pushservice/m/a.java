package com.baidu.android.pushservice.m;
/* loaded from: classes.dex */
public class a {
    public String a = "";
    public int b = 0;
    public int c = 1800;
    public int d = 20;
    public int e = 0;
    public long f = 0;

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(String str) {
        this.a = str;
    }

    public int b() {
        return this.e;
    }

    public void b(int i) {
        this.c = i;
    }

    public int c() {
        return this.c;
    }

    public void c(int i) {
        this.d = i;
    }

    public long d() {
        return this.f;
    }

    public void d(int i) {
        this.b = i;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.b;
    }

    public String toString() {
        return "PushConfig{action='" + this.a + "', status=" + this.b + ", interval=" + this.c + ", powerLimit=" + this.d + ", foregroundStart=" + this.e + ", lastFetchTime=" + this.f + '}';
    }
}
