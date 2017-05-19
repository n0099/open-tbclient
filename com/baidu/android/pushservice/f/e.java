package com.baidu.android.pushservice.f;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class e {
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
        return this.l;
    }

    public void b(int i) {
        this.e = i;
    }

    public void b(String str) {
        this.d = str;
    }

    public m c() {
        return new m(this.b, this.c, this.d, this.k, this.l);
    }

    public void c(int i) {
        this.g = i;
    }

    public void c(String str) {
        this.f = str;
    }

    public h d() {
        h hVar = new h(c());
        hVar.a = this.j;
        hVar.j = this.h;
        return hVar;
    }

    public void d(int i) {
        this.j = i;
    }

    public void d(String str) {
        this.h = str;
    }

    public j e() {
        j jVar = new j(c());
        jVar.c = this.e;
        jVar.a = this.f;
        jVar.b = this.g;
        String str = this.n;
        if (!TextUtils.isEmpty(str)) {
            jVar.k = str;
        }
        return jVar;
    }

    public void e(int i) {
        this.k = i;
    }

    public void e(String str) {
        this.i = str;
    }

    public b f() {
        b bVar = new b(c());
        bVar.a = this.h;
        bVar.b = this.i;
        bVar.c = this.m;
        return bVar;
    }

    public void f(String str) {
        this.l = str;
    }

    public f g() {
        f fVar = new f(c());
        fVar.a = this.h;
        return fVar;
    }

    public void g(String str) {
        this.m = str;
    }

    public void h(String str) {
        this.n = str;
    }
}
