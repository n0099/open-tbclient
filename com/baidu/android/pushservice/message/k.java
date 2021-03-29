package com.baidu.android.pushservice.message;

import java.io.Serializable;
/* loaded from: classes.dex */
public class k implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f3481a;

    /* renamed from: b  reason: collision with root package name */
    public String f3482b;

    /* renamed from: c  reason: collision with root package name */
    public long f3483c;

    /* renamed from: d  reason: collision with root package name */
    public int f3484d;

    /* renamed from: e  reason: collision with root package name */
    public int f3485e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f3486f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f3487g;

    /* renamed from: h  reason: collision with root package name */
    public long f3488h;
    public boolean i = false;

    public int a() {
        return this.f3485e;
    }

    public void a(int i) {
        this.f3485e = i;
    }

    public void a(long j) {
        this.f3488h = j;
    }

    public void a(String str) {
        this.f3481a = str;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void a(byte[] bArr) {
        this.f3486f = bArr;
    }

    public long b() {
        return this.f3488h;
    }

    public void b(int i) {
        this.f3484d = i;
    }

    public void b(long j) {
        this.f3483c = j;
    }

    public void b(String str) {
        this.f3482b = str;
    }

    public void b(byte[] bArr) {
        this.f3487g = bArr;
    }

    public String c() {
        return this.f3481a;
    }

    public String d() {
        return this.f3482b;
    }

    public long e() {
        return this.f3483c;
    }

    public String f() {
        return String.valueOf(this.f3483c);
    }

    public int g() {
        return this.f3484d;
    }

    public byte[] h() {
        return this.f3486f;
    }

    public byte[] i() {
        return this.f3487g;
    }

    public String toString() {
        return "type:" + this.f3484d + " appid:" + this.f3481a + " msgId:" + this.f3483c + " isAlarm:  " + this.i + " pkgName:  " + this.f3482b + "  notifyId: " + this.f3485e;
    }
}
