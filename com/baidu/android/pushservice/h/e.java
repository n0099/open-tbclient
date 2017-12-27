package com.baidu.android.pushservice.h;

import android.text.TextUtils;
/* loaded from: classes2.dex */
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

    public n c() {
        return new n(this.e, this.f, this.g, this.n, this.o);
    }

    public void c(int i) {
        this.j = i;
    }

    public void c(String str) {
        this.i = str;
    }

    public i d() {
        i iVar = new i(c());
        iVar.a = this.m;
        iVar.i = this.k;
        iVar.b = this.i;
        iVar.c = this.q;
        return iVar;
    }

    public void d(int i) {
        this.m = i;
    }

    public void d(String str) {
        this.k = str;
    }

    public k e() {
        k kVar = new k(c());
        kVar.c = this.h;
        kVar.a = this.i;
        kVar.b = this.j;
        String str = this.q;
        if (!TextUtils.isEmpty(str)) {
            kVar.k = str;
        }
        return kVar;
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

    public h h() {
        h hVar = new h(c());
        hVar.j = this.r;
        hVar.a = this.a;
        hVar.b = this.b;
        hVar.c = this.c;
        return hVar;
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
