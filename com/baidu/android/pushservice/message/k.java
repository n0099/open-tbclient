package com.baidu.android.pushservice.message;

import java.io.Serializable;
/* loaded from: classes.dex */
public class k implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f3558a;

    /* renamed from: b  reason: collision with root package name */
    public String f3559b;

    /* renamed from: c  reason: collision with root package name */
    public long f3560c;

    /* renamed from: d  reason: collision with root package name */
    public int f3561d;

    /* renamed from: e  reason: collision with root package name */
    public int f3562e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f3563f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f3564g;

    /* renamed from: h  reason: collision with root package name */
    public long f3565h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3566i = false;

    public int a() {
        return this.f3562e;
    }

    public void a(int i2) {
        this.f3562e = i2;
    }

    public void a(long j) {
        this.f3565h = j;
    }

    public void a(String str) {
        this.f3558a = str;
    }

    public void a(boolean z) {
        this.f3566i = z;
    }

    public void a(byte[] bArr) {
        this.f3563f = bArr;
    }

    public long b() {
        return this.f3565h;
    }

    public void b(int i2) {
        this.f3561d = i2;
    }

    public void b(long j) {
        this.f3560c = j;
    }

    public void b(String str) {
        this.f3559b = str;
    }

    public void b(byte[] bArr) {
        this.f3564g = bArr;
    }

    public String c() {
        return this.f3558a;
    }

    public String d() {
        return this.f3559b;
    }

    public long e() {
        return this.f3560c;
    }

    public String f() {
        return String.valueOf(this.f3560c);
    }

    public int g() {
        return this.f3561d;
    }

    public byte[] h() {
        return this.f3563f;
    }

    public byte[] i() {
        return this.f3564g;
    }

    public String toString() {
        return "type:" + this.f3561d + " appid:" + this.f3558a + " msgId:" + this.f3560c + " isAlarm:  " + this.f3566i + " pkgName:  " + this.f3559b + "  notifyId: " + this.f3562e;
    }
}
