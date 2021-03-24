package com.alipay.security.mobile.module.http.v2;

import android.content.Context;
import com.alipay.security.mobile.module.http.d;
import com.alipay.security.mobile.module.http.model.c;
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static a f2110a;

    /* renamed from: b  reason: collision with root package name */
    public static com.alipay.security.mobile.module.http.a f2111b;

    public static a a(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (f2110a == null) {
            f2111b = d.a(context, str);
            f2110a = new b();
        }
        return f2110a;
    }

    @Override // com.alipay.security.mobile.module.http.v2.a
    public c a(com.alipay.security.mobile.module.http.model.d dVar) {
        return com.alipay.security.mobile.module.http.model.b.a(f2111b.a(com.alipay.security.mobile.module.http.model.b.a(dVar)));
    }

    @Override // com.alipay.security.mobile.module.http.v2.a
    public boolean a(String str) {
        return f2111b.a(str);
    }
}
