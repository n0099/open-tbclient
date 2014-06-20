package com.baidu.android.moplus;

import android.content.Context;
import com.baidu.android.moplus.util.MoPlusInternal;
/* loaded from: classes.dex */
public final class MoPlusConstants {
    private MoPlusConstants() {
    }

    public static void disableService(Context context) {
        if (!com.baidu.android.moplus.util.a.b(context, context.getPackageName())) {
            startService(context);
            return;
        }
        MoPlusInternal.disableService(context);
        com.baidu.android.systemmonitor.util.f.d(context);
        if (com.baidu.android.moplus.util.a.q(context) < 0) {
            com.baidu.android.moplus.util.a.p(context);
        } else if (System.currentTimeMillis() - com.baidu.android.moplus.util.a.q(context) >= 1296000000) {
            MoPlusInternal.enableService(context);
            com.baidu.android.systemmonitor.util.f.c(context);
        }
    }

    public static void enableService(Context context, boolean z) {
        if (!com.baidu.android.moplus.util.a.b(context, context.getPackageName())) {
            MoPlusInternal.enableService(context);
            com.baidu.android.systemmonitor.util.f.c(context);
        } else if (z || System.currentTimeMillis() - com.baidu.android.moplus.util.a.q(context) >= 1296000000) {
            MoPlusInternal.enableService(context);
            com.baidu.android.systemmonitor.util.f.c(context);
        }
    }

    public static void restartService(Context context) {
        if (!com.baidu.android.moplus.util.a.e(context, context.getPackageName())) {
            startService(context);
            return;
        }
        enableService(context, false);
        com.baidu.android.moplus.util.a.h(context, null);
    }

    public static void startService(Context context) {
        enableService(context, false);
        com.baidu.android.moplus.util.a.b(context);
    }
}
