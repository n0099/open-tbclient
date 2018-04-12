package com.baidu.android.pushservice.h;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class e {
    public String a;
    public int b;
    public int c;
    private int d;
    private String e;
    private long f;
    private String g;
    private int h;
    private String i;
    private int j;
    private String k;
    private String l;
    private int m;
    private int n;
    private String o;
    private String p;
    private String q;
    private String r;

    public String a() {
        return this.e;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(String str) {
        this.e = str;
    }

    public String b() {
        return this.r;
    }

    public void b(int i) {
        this.h = i;
    }

    public void b(String str) {
        this.g = str;
    }

    public l c() {
        return new l(this.e, this.f, this.g, this.n, this.o);
    }

    public void c(int i) {
        this.j = i;
    }

    public void c(String str) {
        this.i = str;
    }

    public h d() {
        h hVar = new h(c());
        hVar.a = this.m;
        hVar.i = this.k;
        hVar.b = this.i;
        hVar.c = this.q;
        return hVar;
    }

    public void d(int i) {
        this.m = i;
    }

    public void d(String str) {
        this.k = str;
    }

    public j e() {
        j jVar = new j(c());
        jVar.c = this.h;
        jVar.a = this.i;
        jVar.b = this.j;
        String str = this.q;
        if (!TextUtils.isEmpty(str)) {
            jVar.k = str;
        }
        return jVar;
    }

    public void e(int i) {
        this.n = i;
    }

    public void e(String str) {
        this.l = str;
    }

    public b f() {
        b bVar = new b(c());
        bVar.a = this.k;
        bVar.b = this.l;
        bVar.c = this.p;
        return bVar;
    }

    public void f(int i) {
        this.b = i;
    }

    public void f(String str) {
        this.o = str;
    }

    public f g() {
        f fVar = new f(c());
        fVar.a = this.k;
        return fVar;
    }

    public void g(int i) {
        this.c = i;
    }

    public void g(String str) {
        this.p = str;
    }

    public g h() {
        g gVar = new g(c());
        gVar.j = this.r;
        gVar.a = this.a;
        gVar.b = this.b;
        gVar.c = this.c;
        return gVar;
    }

    public void h(String str) {
        this.r = str;
    }

    public void i(String str) {
        this.q = str;
    }

    public void j(String str) {
        this.a = str;
    }
}
