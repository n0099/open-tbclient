package com.alipay.security.mobile.module.http.v2;

import android.content.Context;
import com.alipay.security.mobile.module.http.d;
import com.alipay.security.mobile.module.http.model.c;
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static a f2135a;

    /* renamed from: b  reason: collision with root package name */
    public static com.alipay.security.mobile.module.http.a f2136b;

    public static a a(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (f2135a == null) {
            f2136b = d.a(context, str);
            f2135a = new b();
        }
        return f2135a;
    }

    @Override // com.alipay.security.mobile.module.http.v2.a
    public c a(com.alipay.security.mobile.module.http.model.d dVar) {
        return com.alipay.security.mobile.module.http.model.b.a(f2136b.a(com.alipay.security.mobile.module.http.model.b.a(dVar)));
    }

    @Override // com.alipay.security.mobile.module.http.v2.a
    public boolean a(String str) {
        return f2136b.a(str);
    }
}
