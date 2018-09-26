package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes3.dex */
public class ao {
    public static int a(Context context, float f) {
        if (context == null) {
            return 0;
        }
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float b(Context context, float f) {
        if (context == null) {
            return 0.0f;
        }
        return (f / context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int c(Context context, float f) {
        if (context == null) {
            return 0;
        }
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
