package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a dKY = null;

    public static void q(Context context, int i) {
        if (dKY != null) {
            dKY.q(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (dKY != null) {
            dKY.b(context, i, z);
        }
    }

    public static void dF(Context context) {
        if (dKY != null) {
            dKY.dF(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (dKY != null) {
            dKY.c(context, i, z);
        }
    }

    public static Class<?> aTO() {
        if (dKY == null) {
            return null;
        }
        return dKY.aTO();
    }

    public static String aTP() {
        if (dKY == null) {
            return null;
        }
        return dKY.aTP();
    }

    public static void a(a aVar) {
        dKY = aVar;
    }

    public static int getCurrentTabType() {
        if (dKY == null) {
            return -1;
        }
        return dKY.getCurrentTabType();
    }
}
