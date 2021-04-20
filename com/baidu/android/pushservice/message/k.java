package com.baidu.android.pushservice.message;

import java.io.Serializable;
/* loaded from: classes.dex */
public class k implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f3516a;

    /* renamed from: b  reason: collision with root package name */
    public String f3517b;

    /* renamed from: c  reason: collision with root package name */
    public long f3518c;

    /* renamed from: d  reason: collision with root package name */
    public int f3519d;

    /* renamed from: e  reason: collision with root package name */
    public int f3520e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f3521f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f3522g;

    /* renamed from: h  reason: collision with root package name */
    public long f3523h;
    public boolean i = false;

    public int a() {
        return this.f3520e;
    }

    public void a(int i) {
        this.f3520e = i;
    }

    public void a(long j) {
        this.f3523h = j;
    }

    public void a(String str) {
        this.f3516a = str;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void a(byte[] bArr) {
        this.f3521f = bArr;
    }

    public long b() {
        return this.f3523h;
    }

    public void b(int i) {
        this.f3519d = i;
    }

    public void b(long j) {
        this.f3518c = j;
    }

    public void b(String str) {
        this.f3517b = str;
    }

    public void b(byte[] bArr) {
        this.f3522g = bArr;
    }

    public String c() {
        return this.f3516a;
    }

    public String d() {
        return this.f3517b;
    }

    public long e() {
        return this.f3518c;
    }

    public String f() {
        return String.valueOf(this.f3518c);
    }

    public int g() {
        return this.f3519d;
    }

    public byte[] h() {
        return this.f3521f;
    }

    public byte[] i() {
        return this.f3522g;
    }

    public String toString() {
        return "type:" + this.f3519d + " appid:" + this.f3516a + " msgId:" + this.f3518c + " isAlarm:  " + this.i + " pkgName:  " + this.f3517b + "  notifyId: " + this.f3520e;
    }
}
