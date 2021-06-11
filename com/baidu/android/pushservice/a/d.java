package com.baidu.android.pushservice.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.m;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public e f2745a;

    /* renamed from: b  reason: collision with root package name */
    public c f2746b;

    public d(c cVar) {
        this.f2746b = cVar;
    }

    public static d a(Context context, String str) {
        b.a(context).b(context);
        e b2 = b.a(context).b(str);
        if (b2 != null && !TextUtils.isEmpty(b2.f2736b)) {
            d dVar = new d(c.PUSH_CLIENT);
            dVar.f2745a = b2;
            return dVar;
        }
        m.a("ClientTypeInfo*BBind* isRegisteredClientByAppid not PushClient! appid=" + str, context);
        return new d(c.UNKNOWN_CLIENT);
    }

    public c a() {
        return this.f2746b;
    }
}
