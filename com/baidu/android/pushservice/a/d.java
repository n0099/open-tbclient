package com.baidu.android.pushservice.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.m;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public e f2688a;

    /* renamed from: b  reason: collision with root package name */
    public c f2689b;

    public d(c cVar) {
        this.f2689b = cVar;
    }

    public static d a(Context context, String str) {
        b.a(context).b(context);
        e b2 = b.a(context).b(str);
        if (b2 != null && !TextUtils.isEmpty(b2.f2679b)) {
            d dVar = new d(c.PUSH_CLIENT);
            dVar.f2688a = b2;
            return dVar;
        }
        m.a("ClientTypeInfo*BBind* isRegisteredClientByAppid not PushClient! appid=" + str, context);
        return new d(c.UNKNOWN_CLIENT);
    }

    public c a() {
        return this.f2689b;
    }
}
