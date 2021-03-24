package com.baidu.android.pushservice.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.m;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public e f2687a;

    /* renamed from: b  reason: collision with root package name */
    public c f2688b;

    public d(c cVar) {
        this.f2688b = cVar;
    }

    public static d a(Context context, String str) {
        b.a(context).b(context);
        e b2 = b.a(context).b(str);
        if (b2 != null && !TextUtils.isEmpty(b2.f2678b)) {
            d dVar = new d(c.PUSH_CLIENT);
            dVar.f2687a = b2;
            return dVar;
        }
        m.a("ClientTypeInfo*BBind* isRegisteredClientByAppid not PushClient! appid=" + str, context);
        return new d(c.UNKNOWN_CLIENT);
    }

    public c a() {
        return this.f2688b;
    }
}
