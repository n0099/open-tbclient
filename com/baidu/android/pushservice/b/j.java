package com.baidu.android.pushservice.b;

import android.content.Context;
/* loaded from: classes2.dex */
public class j extends e {
    private static volatile j d;

    private j(Context context) {
        super(context, c.WEBAPP_CLIENT);
    }

    public static synchronized j a(Context context) {
        j jVar;
        synchronized (j.class) {
            if (d == null) {
                d = new j(context);
            } else {
                d.b = context.getApplicationContext();
            }
            jVar = d;
        }
        return jVar;
    }
}
