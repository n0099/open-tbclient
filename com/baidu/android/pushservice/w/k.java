package com.baidu.android.pushservice.w;

import java.io.Serializable;
/* loaded from: classes.dex */
public class k implements Serializable {
    public String a;
    public String b;
    public long c;
    public int d;
    public int e;
    public int f;
    public int h;
    public byte[] i;
    public byte[] j;
    public long k;
    public long m;
    public String n;
    public String o;
    public int p;
    public int q;
    public String r;
    public String s;
    public String g = "";
    public boolean l = false;

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(long j) {
        this.k = j;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public void a(byte[] bArr) {
        this.i = bArr;
    }

    public String b() {
        return this.o;
    }

    public void b(int i) {
        this.e = i;
    }

    public void b(long j) {
        this.m = j;
    }

    public void b(String str) {
        this.o = str;
    }

    public void b(byte[] bArr) {
        this.j = bArr;
    }

    public long c() {
        return this.k;
    }

    public void c(int i) {
        this.q = i;
    }

    public void c(long j) {
        this.c = j;
    }

    public void c(String str) {
        this.s = str;
    }

    public int d() {
        return this.h;
    }

    public void d(int i) {
        this.f = i;
    }

    public void d(String str) {
        this.b = str;
    }

    public long e() {
        return this.m;
    }

    public void e(int i) {
        this.d = i;
    }

    public void e(String str) {
        this.r = str;
    }

    public String f() {
        return this.s;
    }

    public void f(int i) {
        this.p = i;
    }

    public void f(String str) {
        this.n = str;
    }

    public long g() {
        return this.c;
    }

    public void g(String str) {
        this.g = str;
    }

    public String h() {
        return String.valueOf(this.c);
    }

    public int i() {
        return this.e;
    }

    public String j() {
        return this.b;
    }

    public byte[] k() {
        return this.i;
    }

    public String l() {
        return this.r;
    }

    public int m() {
        return this.q;
    }

    public byte[] n() {
        return this.j;
    }

    public int o() {
        return this.f;
    }

    public String p() {
        return this.n;
    }

    public int q() {
        return this.d;
    }

    public String r() {
        return this.g;
    }

    public int s() {
        return this.p;
    }

    public String toString() {
        return "type:" + this.d + " appid:" + this.a + " msgId:" + this.c + " isAlarm:  " + this.l + " pkgName:  " + this.b + "  notifyId: " + this.e + "  source:" + this.f + "  foregroundShow: " + this.h + "  widgetBadgeNum: " + this.g + " logExt:" + this.s;
    }
}
