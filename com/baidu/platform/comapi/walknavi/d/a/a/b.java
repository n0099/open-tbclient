package com.baidu.platform.comapi.walknavi.d.a.a;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class b implements Serializable {
    private String b;
    private String c;
    private String d;
    private String[] e;
    private String f;
    private String g;
    private int h;
    private String i;
    private String l;
    private String m;

    /* renamed from: a  reason: collision with root package name */
    private int f2912a = Integer.MIN_VALUE;
    private boolean j = false;
    private boolean k = true;

    public void a(int i) {
        this.f2912a = i;
    }

    public int a() {
        return this.f2912a;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.d;
    }

    public void a(String[] strArr) {
        this.e = strArr;
    }

    public void d(String str) {
        this.f = str;
    }

    public void e(String str) {
        this.g = str;
    }

    public void b(int i) {
        this.h = i;
    }

    public int e() {
        return this.h;
    }

    public void f(String str) {
        this.i = str;
    }

    public boolean f() {
        return this.j;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public boolean g() {
        return this.k;
    }

    public void b(boolean z) {
        this.k = z;
    }

    public void g(String str) {
        this.l = str;
    }

    public String h() {
        return this.m;
    }

    public void h(String str) {
        this.m = str;
    }

    public String toString() {
        return "ARResource [ err_code = " + this.f2912a + ", err_msg = " + this.b + ", , version_code = " + this.g + ", ar_resource = " + this.d + " ]";
    }
}
