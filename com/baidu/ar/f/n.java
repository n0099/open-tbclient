package com.baidu.ar.f;

import android.content.Context;
/* loaded from: classes3.dex */
public class n {
    public static float x(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().density;
        }
        return 0.0f;
    }

    public static boolean y(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
