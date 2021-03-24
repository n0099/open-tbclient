package com.alipay.android.phone.mrpc.core;
/* loaded from: classes.dex */
public final class p extends u {

    /* renamed from: c  reason: collision with root package name */
    public int f1684c;

    /* renamed from: d  reason: collision with root package name */
    public String f1685d;

    /* renamed from: e  reason: collision with root package name */
    public long f1686e;

    /* renamed from: f  reason: collision with root package name */
    public long f1687f;

    /* renamed from: g  reason: collision with root package name */
    public String f1688g;

    /* renamed from: h  reason: collision with root package name */
    public HttpUrlHeader f1689h;

    public p(HttpUrlHeader httpUrlHeader, int i, String str, byte[] bArr) {
        this.f1689h = httpUrlHeader;
        this.f1684c = i;
        this.f1685d = str;
        this.f1701a = bArr;
    }

    public final HttpUrlHeader a() {
        return this.f1689h;
    }

    public final void a(long j) {
        this.f1686e = j;
    }

    public final void a(String str) {
        this.f1688g = str;
    }

    public final void b(long j) {
        this.f1687f = j;
    }
}
