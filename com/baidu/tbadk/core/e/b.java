package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a aSg = null;

    public static void u(Context context, int i) {
        if (aSg != null) {
            aSg.u(context, i);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (aSg != null) {
            aSg.d(context, i, z);
        }
    }

    public static void aP(Context context) {
        if (aSg != null) {
            aSg.aP(context);
        }
    }

    public static void e(Context context, int i, boolean z) {
        if (aSg != null) {
            aSg.e(context, i, z);
        }
    }

    public static Class<?> Bn() {
        if (aSg == null) {
            return null;
        }
        return aSg.Bn();
    }

    public static String Bo() {
        if (aSg == null) {
            return null;
        }
        return aSg.Bo();
    }

    public static void a(a aVar) {
        aSg = aVar;
    }

    public static int getCurrentTabType() {
        if (aSg == null) {
            return -1;
        }
        return aSg.getCurrentTabType();
    }
}
