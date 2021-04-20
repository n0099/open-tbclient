package com.alipay.apmobilesecuritysdk.b;

import com.alipay.security.mobile.module.http.d;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f1741b = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f1742a = 0;

    public static a a() {
        return f1741b;
    }

    public final void a(int i) {
        this.f1742a = i;
    }

    public final int b() {
        return this.f1742a;
    }

    public final String c() {
        String a2 = d.a();
        if (com.alipay.security.mobile.module.a.a.b(a2)) {
            return a2;
        }
        int i = this.f1742a;
        return i != 1 ? i != 3 ? i != 4 ? "https://mobilegw.alipay.com/mgw.htm" : "http://mobilegw.aaa.alipay.net/mgw.htm" : "http://mobilegw-1-64.test.alipay.net/mgw.htm" : "http://mobilegw.stable.alipay.net/mgw.htm";
    }
}
