package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a ekf = null;

    public static void r(Context context, int i) {
        if (ekf != null) {
            ekf.r(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (ekf != null) {
            ekf.c(context, i, z);
        }
    }

    public static void dS(Context context) {
        if (ekf != null) {
            ekf.dS(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (ekf != null) {
            ekf.d(context, i, z);
        }
    }

    public static Class<?> biV() {
        if (ekf == null) {
            return null;
        }
        return ekf.biV();
    }

    public static String biW() {
        if (ekf == null) {
            return null;
        }
        return ekf.biW();
    }

    public static void a(a aVar) {
        ekf = aVar;
    }

    public static int getCurrentTabType() {
        if (ekf == null) {
            return -1;
        }
        return ekf.getCurrentTabType();
    }
}
