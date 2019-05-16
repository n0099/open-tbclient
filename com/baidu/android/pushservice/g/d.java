package com.baidu.android.pushservice.g;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class d {
    private int a;
    private String b;
    private long c;
    private String d;
    private int e;
    private String f;
    private int g;
    private String h;
    private String i;
    private int j;
    private int k;
    private String l;
    private String m;
    private String n;
    private String o;

    public String a() {
        return this.b;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(long j) {
        this.c = j;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.o;
    }

    public void b(int i) {
        this.e = i;
    }

    public void b(String str) {
        this.d = str;
    }

    public j c() {
        return new j(this.b, this.c, this.d, this.k, this.l);
    }

    public void c(int i) {
        this.g = i;
    }

    public void c(String str) {
        this.f = str;
    }

    public f d() {
        f fVar = new f(c());
        fVar.a = this.j;
        fVar.i = this.h;
        fVar.b = this.f;
        fVar.c = this.n;
        return fVar;
    }

    public void d(int i) {
        this.j = i;
    }

    public void d(String str) {
        this.h = str;
    }

    public h e() {
        h hVar = new h(c());
        hVar.c = this.e;
        hVar.a = this.f;
        hVar.b = this.g;
        String str = this.n;
        if (!TextUtils.isEmpty(str)) {
            hVar.k = str;
        }
        return hVar;
    }

    public void e(int i) {
        this.k = i;
    }

    public void e(String str) {
        this.i = str;
    }

    public a f() {
        a aVar = new a(c());
        aVar.a = this.h;
        aVar.b = this.i;
        aVar.c = this.m;
        return aVar;
    }

    public void f(String str) {
        this.l = str;
    }

    public e g() {
        e eVar = new e(c());
        eVar.a = this.h;
        return eVar;
    }

    public void g(String str) {
        this.m = str;
    }

    public void h(String str) {
        this.o = str;
    }

    public void i(String str) {
        this.n = str;
    }
}
