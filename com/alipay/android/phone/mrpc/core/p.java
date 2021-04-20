package com.alipay.android.phone.mrpc.core;
/* loaded from: classes.dex */
public final class p extends u {

    /* renamed from: c  reason: collision with root package name */
    public int f1709c;

    /* renamed from: d  reason: collision with root package name */
    public String f1710d;

    /* renamed from: e  reason: collision with root package name */
    public long f1711e;

    /* renamed from: f  reason: collision with root package name */
    public long f1712f;

    /* renamed from: g  reason: collision with root package name */
    public String f1713g;

    /* renamed from: h  reason: collision with root package name */
    public HttpUrlHeader f1714h;

    public p(HttpUrlHeader httpUrlHeader, int i, String str, byte[] bArr) {
        this.f1714h = httpUrlHeader;
        this.f1709c = i;
        this.f1710d = str;
        this.f1726a = bArr;
    }

    public final HttpUrlHeader a() {
        return this.f1714h;
    }

    public final void a(long j) {
        this.f1711e = j;
    }

    public final void a(String str) {
        this.f1713g = str;
    }

    public final void b(long j) {
        this.f1712f = j;
    }
}
