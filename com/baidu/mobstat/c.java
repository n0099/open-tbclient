package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes15.dex */
public class c {
    public static void a(Context context) {
        b.f3775a.a(context);
        y.a(context).a(g.AP_LIST, System.currentTimeMillis());
    }

    public static void a(Context context, boolean z) {
        e.f3852a.a(context, z);
        y.a(context).a(z ? g.APP_SYS_LIST : g.APP_USER_LIST, System.currentTimeMillis());
    }

    public static void b(Context context, boolean z) {
        f.f3853a.a(context, z);
        y.a(context).a(z ? g.APP_TRACE_CURRENT : g.APP_TRACE_HIS, System.currentTimeMillis());
    }

    public static void b(Context context) {
        d.f3843a.a(context);
        y.a(context).a(g.APP_APK, System.currentTimeMillis());
    }
}
