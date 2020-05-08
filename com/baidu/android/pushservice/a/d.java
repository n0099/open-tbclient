package com.baidu.android.pushservice.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.i.m;
/* loaded from: classes8.dex */
public class d {
    public e a;
    private c b;

    public d(c cVar) {
        this.b = cVar;
    }

    public static d a(Context context, String str) {
        b.a(context).b(context);
        e b = b.a(context).b(str);
        if (b == null || TextUtils.isEmpty(b.b)) {
            m.a("ClientTypeInfo*BBind* isRegisteredClientByAppid not PushClient! appid=" + str, context);
            return new d(c.UNKNOWN_CLIENT);
        }
        d dVar = new d(c.PUSH_CLIENT);
        dVar.a = b;
        return dVar;
    }

    public c a() {
        return this.b;
    }
}
