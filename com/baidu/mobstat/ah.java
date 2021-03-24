package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes2.dex */
public class ah {
    public static int a(Context context, float f2) {
        if (context == null) {
            return 0;
        }
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float b(Context context, float f2) {
        if (context == null) {
            return 0.0f;
        }
        return (f2 / context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int c(Context context, float f2) {
        if (context == null) {
            return 0;
        }
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
