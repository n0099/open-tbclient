package com.baidu.android.pushservice.message;

import java.io.Serializable;
/* loaded from: classes.dex */
public class k implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f3555a;

    /* renamed from: b  reason: collision with root package name */
    public String f3556b;

    /* renamed from: c  reason: collision with root package name */
    public long f3557c;

    /* renamed from: d  reason: collision with root package name */
    public int f3558d;

    /* renamed from: e  reason: collision with root package name */
    public int f3559e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f3560f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f3561g;

    /* renamed from: h  reason: collision with root package name */
    public long f3562h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3563i = false;

    public int a() {
        return this.f3559e;
    }

    public void a(int i2) {
        this.f3559e = i2;
    }

    public void a(long j) {
        this.f3562h = j;
    }

    public void a(String str) {
        this.f3555a = str;
    }

    public void a(boolean z) {
        this.f3563i = z;
    }

    public void a(byte[] bArr) {
        this.f3560f = bArr;
    }

    public long b() {
        return this.f3562h;
    }

    public void b(int i2) {
        this.f3558d = i2;
    }

    public void b(long j) {
        this.f3557c = j;
    }

    public void b(String str) {
        this.f3556b = str;
    }

    public void b(byte[] bArr) {
        this.f3561g = bArr;
    }

    public String c() {
        return this.f3555a;
    }

    public String d() {
        return this.f3556b;
    }

    public long e() {
        return this.f3557c;
    }

    public String f() {
        return String.valueOf(this.f3557c);
    }

    public int g() {
        return this.f3558d;
    }

    public byte[] h() {
        return this.f3560f;
    }

    public byte[] i() {
        return this.f3561g;
    }

    public String toString() {
        return "type:" + this.f3558d + " appid:" + this.f3555a + " msgId:" + this.f3557c + " isAlarm:  " + this.f3563i + " pkgName:  " + this.f3556b + "  notifyId: " + this.f3559e;
    }
}
