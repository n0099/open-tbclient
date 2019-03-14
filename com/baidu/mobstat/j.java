package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes6.dex */
public class j {
    public static void a(Context context) {
        i.a.a(context);
        af.a(context).a(n.AP_LIST, System.currentTimeMillis());
    }

    public static void a(Context context, boolean z) {
        l.a.a(context, z);
        af.a(context).a(z ? n.APP_SYS_LIST : n.APP_USER_LIST, System.currentTimeMillis());
    }

    public static void b(Context context, boolean z) {
        m.a.a(context, z);
        af.a(context).a(z ? n.APP_TRACE_CURRENT : n.APP_TRACE_HIS, System.currentTimeMillis());
    }

    public static void b(Context context) {
        k.a.a(context);
        af.a(context).a(n.APP_APK, System.currentTimeMillis());
    }
}
