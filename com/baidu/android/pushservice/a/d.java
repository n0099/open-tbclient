package com.baidu.android.pushservice.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.i.l;
/* loaded from: classes6.dex */
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
        l.b("ClientTypeInfo*BBind* isRegisteredClientByAppid not PushClient! appid=" + str, context);
        g e = h.a(context).e(str);
        if (e == null || e.c() == null) {
            return new d(c.UNKNOWN_CLIENT);
        }
        d dVar2 = new d(c.SDK_CLIENT);
        dVar2.b = e;
        return dVar2;
    }

    public c a() {
        return this.c;
    }
}
