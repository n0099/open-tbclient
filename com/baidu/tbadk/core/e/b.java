package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a cXr = null;

    public static void v(Context context, int i) {
        if (cXr != null) {
            cXr.v(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (cXr != null) {
            cXr.b(context, i, z);
        }
    }

    public static void dM(Context context) {
        if (cXr != null) {
            cXr.dM(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (cXr != null) {
            cXr.c(context, i, z);
        }
    }

    public static Class<?> aFu() {
        if (cXr == null) {
            return null;
        }
        return cXr.aFu();
    }

    public static String aFv() {
        if (cXr == null) {
            return null;
        }
        return cXr.aFv();
    }

    public static void a(a aVar) {
        cXr = aVar;
    }

    public static int getCurrentTabType() {
        if (cXr == null) {
            return -1;
        }
        return cXr.getCurrentTabType();
    }
}
