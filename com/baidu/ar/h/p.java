package com.baidu.ar.h;

import android.content.Context;
/* loaded from: classes10.dex */
public class p {
    public static boolean A(Context context) {
        return context != null && context.getResources().getConfiguration().orientation == 2;
    }

    public static float z(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().density;
        }
        return 0.0f;
    }
}
