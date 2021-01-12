package com.baidu.android.pushservice.message;

import java.io.Serializable;
/* loaded from: classes14.dex */
public class k implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private String f1477a;

    /* renamed from: b  reason: collision with root package name */
    private String f1478b;
    private long c;
    private int d;
    private byte[] e;
    private byte[] f;
    private long g;
    private boolean h = false;

    public long a() {
        return this.g;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.g = j;
    }

    public void a(String str) {
        this.f1477a = str;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void a(byte[] bArr) {
        this.e = bArr;
    }

    public String b() {
        return this.f1477a;
    }

    public void b(long j) {
        this.c = j;
    }

    public void b(String str) {
        this.f1478b = str;
    }

    public void b(byte[] bArr) {
        this.f = bArr;
    }

    public String c() {
        return this.f1478b;
    }

    public long d() {
        return this.c;
    }

    public String e() {
        return String.valueOf(this.c);
    }

    public int f() {
        return this.d;
    }

    public byte[] g() {
        return this.e;
    }

    public byte[] h() {
        return this.f;
    }

    public String toString() {
        return "type:" + this.d + " appid:" + this.f1477a + " msgId:" + this.c + " isAlarm:  " + this.h + " pkgName:  " + this.f1478b;
    }
}
