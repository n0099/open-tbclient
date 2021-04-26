package com.alipay.android.phone.mrpc.core;
/* loaded from: classes.dex */
public final class p extends u {

    /* renamed from: c  reason: collision with root package name */
    public int f1650c;

    /* renamed from: d  reason: collision with root package name */
    public String f1651d;

    /* renamed from: e  reason: collision with root package name */
    public long f1652e;

    /* renamed from: f  reason: collision with root package name */
    public long f1653f;

    /* renamed from: g  reason: collision with root package name */
    public String f1654g;

    /* renamed from: h  reason: collision with root package name */
    public HttpUrlHeader f1655h;

    public p(HttpUrlHeader httpUrlHeader, int i2, String str, byte[] bArr) {
        this.f1655h = httpUrlHeader;
        this.f1650c = i2;
        this.f1651d = str;
        this.f1668a = bArr;
    }

    public final HttpUrlHeader a() {
        return this.f1655h;
    }

    public final void a(long j) {
        this.f1652e = j;
    }

    public final void a(String str) {
        this.f1654g = str;
    }

    public final void b(long j) {
        this.f1653f = j;
    }
}
