package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a dYg = null;

    public static void q(Context context, int i) {
        if (dYg != null) {
            dYg.q(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (dYg != null) {
            dYg.c(context, i, z);
        }
    }

    public static void dL(Context context) {
        if (dYg != null) {
            dYg.dL(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (dYg != null) {
            dYg.d(context, i, z);
        }
    }

    public static Class<?> aZG() {
        if (dYg == null) {
            return null;
        }
        return dYg.aZG();
    }

    public static String aZH() {
        if (dYg == null) {
            return null;
        }
        return dYg.aZH();
    }

    public static void a(a aVar) {
        dYg = aVar;
    }

    public static int getCurrentTabType() {
        if (dYg == null) {
            return -1;
        }
        return dYg.getCurrentTabType();
    }
}
