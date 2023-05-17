package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes3.dex */
public class c {
    public static void a(Context context) {
        if (!bu.a().d()) {
            return;
        }
        b.a.a(context);
        w.a(context).a(g.AP_LIST, System.currentTimeMillis());
    }

    public static void b(Context context) {
        if (!bu.a().d()) {
            return;
        }
        d.a.a(context);
        w.a(context).a(g.APP_APK, System.currentTimeMillis());
    }

    public static void a(Context context, boolean z) {
        g gVar;
        if (!bu.a().d()) {
            return;
        }
        e.a.a(context, z);
        long currentTimeMillis = System.currentTimeMillis();
        w a = w.a(context);
        if (z) {
            gVar = g.APP_SYS_LIST;
        } else {
            gVar = g.APP_USER_LIST;
        }
        a.a(gVar, currentTimeMillis);
    }

    public static void b(Context context, boolean z) {
        g gVar;
        if (!bu.a().d()) {
            return;
        }
        f.a.a(context, z);
        long currentTimeMillis = System.currentTimeMillis();
        w a = w.a(context);
        if (z) {
            gVar = g.APP_TRACE_CURRENT;
        } else {
            gVar = g.APP_TRACE_HIS;
        }
        a.a(gVar, currentTimeMillis);
    }
}
