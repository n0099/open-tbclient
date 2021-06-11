package com.alipay.android.phone.mrpc.core;
/* loaded from: classes.dex */
public final class p extends u {

    /* renamed from: c  reason: collision with root package name */
    public int f1663c;

    /* renamed from: d  reason: collision with root package name */
    public String f1664d;

    /* renamed from: e  reason: collision with root package name */
    public long f1665e;

    /* renamed from: f  reason: collision with root package name */
    public long f1666f;

    /* renamed from: g  reason: collision with root package name */
    public String f1667g;

    /* renamed from: h  reason: collision with root package name */
    public HttpUrlHeader f1668h;

    public p(HttpUrlHeader httpUrlHeader, int i2, String str, byte[] bArr) {
        this.f1668h = httpUrlHeader;
        this.f1663c = i2;
        this.f1664d = str;
        this.f1681a = bArr;
    }

    public final HttpUrlHeader a() {
        return this.f1668h;
    }

    public final void a(long j) {
        this.f1665e = j;
    }

    public final void a(String str) {
        this.f1667g = str;
    }

    public final void b(long j) {
        this.f1666f = j;
    }
}
