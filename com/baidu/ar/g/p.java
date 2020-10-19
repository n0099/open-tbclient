package com.baidu.ar.g;

import android.content.Context;
/* loaded from: classes14.dex */
public class p {
    public static float y(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().density;
        }
        return 0.0f;
    }

    public static boolean z(Context context) {
        return context != null && context.getResources().getConfiguration().orientation == 2;
    }
}
