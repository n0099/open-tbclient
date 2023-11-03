package com.baidu.android.pushservice.k;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes.dex */
public class d {
    public c a;
    public e b;

    public d(c cVar) {
        this.a = cVar;
    }

    public static d a(Context context, String str) {
        b.a(context).b(context);
        e b = b.a(context).b(str);
        if (b == null || TextUtils.isEmpty(b.b)) {
            return new d(c.UNKNOWN_CLIENT);
        }
        d dVar = new d(c.PUSH_CLIENT);
        dVar.b = b;
        return dVar;
    }

    public c a() {
        return this.a;
    }
}
