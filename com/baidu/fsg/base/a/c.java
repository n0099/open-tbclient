package com.baidu.fsg.base.a;

import android.annotation.SuppressLint;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final long f1914a;

    /* renamed from: b  reason: collision with root package name */
    private long f1915b;
    private long c;
    private long d;
    @SuppressLint({"InlinedApi"})
    private int e = 1;

    public c(long j) {
        this.f1914a = j;
    }

    public int a() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public long b() {
        return this.f1915b;
    }

    public void a(long j) {
        this.f1915b = j;
    }

    public long c() {
        return this.c;
    }

    public void b(long j) {
        this.c = j;
    }

    public long d() {
        return this.f1914a;
    }

    public long e() {
        return this.d;
    }

    public void c(long j) {
        this.d = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadItem=(id: " + this.f1914a);
        sb.append(", current bytes: " + this.f1915b);
        sb.append(", total bytes: " + this.c);
        sb.append(", speed: " + this.d);
        sb.append(", state: " + this.e);
        sb.append(")");
        return sb.toString();
    }
}
