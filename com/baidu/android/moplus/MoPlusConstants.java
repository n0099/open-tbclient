package com.baidu.android.moplus;

import android.content.Context;
/* loaded from: classes.dex */
public final class MoPlusConstants {
    private MoPlusConstants() {
    }

    public static void restartService(Context context) {
        if (com.baidu.android.moplus.util.b.e(context, context.getPackageName())) {
            com.baidu.android.moplus.util.b.h(context, null);
        } else {
            com.baidu.android.moplus.util.b.b(context);
        }
    }

    public static void startService(Context context) {
        com.baidu.android.moplus.util.b.b(context);
    }
}
