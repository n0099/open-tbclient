package com.baidu.android.pushservice.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.q;
/* loaded from: classes2.dex */
public class d {
    public f a;
    public g b;
    private c c;

    public d(c cVar) {
        this.c = cVar;
    }

    public static d a(Context context, String str) {
        b.a(context).b(context);
        f d = b.a(context).d(str);
        if (d != null && !TextUtils.isEmpty(d.c)) {
            d dVar = new d(c.PUSH_CLIENT);
            dVar.a = d;
            return dVar;
        }
        q.b("ClientTypeInfo*BBind* isRegisteredClientByAppid not PushClient! appid=" + str, context);
        g b = h.a(context).b(str);
        if (b == null || b.c() == null) {
            return ((i) j.a(context).b(str)) != null ? new d(c.WEBAPP_CLIENT) : new d(c.UNKNOWN_CLIENT);
        }
        d dVar2 = new d(c.SDK_CLIENT);
        dVar2.b = b;
        return dVar2;
    }

    public c a() {
        return this.c;
    }
}
