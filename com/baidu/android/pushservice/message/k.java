package com.baidu.android.pushservice.message;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class k implements Serializable {
    private String a;
    private String b;
    private long c;
    private int d;
    private byte[] e;
    private long f;
    private long g;
    private long h;
    private boolean i = false;

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void a(byte[] bArr) {
        this.e = bArr;
    }

    public boolean a() {
        return this.i;
    }

    public long b() {
        return this.f;
    }

    public void b(long j) {
        this.g = j;
    }

    public void b(String str) {
        this.b = str;
    }

    public long c() {
        return this.g;
    }

    public void c(long j) {
        this.h = j;
    }

    public long d() {
        return this.h;
    }

    public void d(long j) {
        this.c = j;
    }

    public String e() {
        return this.a;
    }

    public String f() {
        return this.b;
    }

    public long g() {
        return this.c;
    }

    public String h() {
        return String.valueOf(this.c);
    }

    public int i() {
        return this.d;
    }

    public byte[] j() {
        return this.e;
    }

    public String toString() {
        return "type:" + this.d + " appid:" + this.a + " msgId:" + this.c + " isAlarm:  " + this.i + " pkgName:  " + this.b;
    }
}
