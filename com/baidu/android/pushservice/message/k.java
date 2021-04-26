package com.baidu.android.pushservice.message;

import java.io.Serializable;
/* loaded from: classes.dex */
public class k implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f3554a;

    /* renamed from: b  reason: collision with root package name */
    public String f3555b;

    /* renamed from: c  reason: collision with root package name */
    public long f3556c;

    /* renamed from: d  reason: collision with root package name */
    public int f3557d;

    /* renamed from: e  reason: collision with root package name */
    public int f3558e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f3559f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f3560g;

    /* renamed from: h  reason: collision with root package name */
    public long f3561h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3562i = false;

    public int a() {
        return this.f3558e;
    }

    public void a(int i2) {
        this.f3558e = i2;
    }

    public void a(long j) {
        this.f3561h = j;
    }

    public void a(String str) {
        this.f3554a = str;
    }

    public void a(boolean z) {
        this.f3562i = z;
    }

    public void a(byte[] bArr) {
        this.f3559f = bArr;
    }

    public long b() {
        return this.f3561h;
    }

    public void b(int i2) {
        this.f3557d = i2;
    }

    public void b(long j) {
        this.f3556c = j;
    }

    public void b(String str) {
        this.f3555b = str;
    }

    public void b(byte[] bArr) {
        this.f3560g = bArr;
    }

    public String c() {
        return this.f3554a;
    }

    public String d() {
        return this.f3555b;
    }

    public long e() {
        return this.f3556c;
    }

    public String f() {
        return String.valueOf(this.f3556c);
    }

    public int g() {
        return this.f3557d;
    }

    public byte[] h() {
        return this.f3559f;
    }

    public byte[] i() {
        return this.f3560g;
    }

    public String toString() {
        return "type:" + this.f3557d + " appid:" + this.f3554a + " msgId:" + this.f3556c + " isAlarm:  " + this.f3562i + " pkgName:  " + this.f3555b + "  notifyId: " + this.f3558e;
    }
}
