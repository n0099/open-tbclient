package com.baidu.android.pushservice.message;

import java.io.Serializable;
/* loaded from: classes.dex */
public class k implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f3577a;

    /* renamed from: b  reason: collision with root package name */
    public String f3578b;

    /* renamed from: c  reason: collision with root package name */
    public long f3579c;

    /* renamed from: d  reason: collision with root package name */
    public int f3580d;

    /* renamed from: e  reason: collision with root package name */
    public int f3581e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f3582f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f3583g;

    /* renamed from: h  reason: collision with root package name */
    public long f3584h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3585i = false;

    public int a() {
        return this.f3581e;
    }

    public void a(int i2) {
        this.f3581e = i2;
    }

    public void a(long j) {
        this.f3584h = j;
    }

    public void a(String str) {
        this.f3577a = str;
    }

    public void a(boolean z) {
        this.f3585i = z;
    }

    public void a(byte[] bArr) {
        this.f3582f = bArr;
    }

    public long b() {
        return this.f3584h;
    }

    public void b(int i2) {
        this.f3580d = i2;
    }

    public void b(long j) {
        this.f3579c = j;
    }

    public void b(String str) {
        this.f3578b = str;
    }

    public void b(byte[] bArr) {
        this.f3583g = bArr;
    }

    public String c() {
        return this.f3577a;
    }

    public String d() {
        return this.f3578b;
    }

    public long e() {
        return this.f3579c;
    }

    public String f() {
        return String.valueOf(this.f3579c);
    }

    public int g() {
        return this.f3580d;
    }

    public byte[] h() {
        return this.f3582f;
    }

    public byte[] i() {
        return this.f3583g;
    }

    public String toString() {
        return "type:" + this.f3580d + " appid:" + this.f3577a + " msgId:" + this.f3579c + " isAlarm:  " + this.f3585i + " pkgName:  " + this.f3578b + "  notifyId: " + this.f3581e;
    }
}
