package com.alipay.apmobilesecuritysdk.b;

import com.alipay.security.mobile.module.http.d;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f1683b = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f1684a = 0;

    public static a a() {
        return f1683b;
    }

    public final void a(int i2) {
        this.f1684a = i2;
    }

    public final int b() {
        return this.f1684a;
    }

    public final String c() {
        String a2 = d.a();
        if (com.alipay.security.mobile.module.a.a.b(a2)) {
            return a2;
        }
        int i2 = this.f1684a;
        return i2 != 1 ? i2 != 3 ? i2 != 4 ? "https://mobilegw.alipay.com/mgw.htm" : "http://mobilegw.aaa.alipay.net/mgw.htm" : "http://mobilegw-1-64.test.alipay.net/mgw.htm" : "http://mobilegw.stable.alipay.net/mgw.htm";
    }
}
