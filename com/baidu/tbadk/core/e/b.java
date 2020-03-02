package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a cXq = null;

    public static void v(Context context, int i) {
        if (cXq != null) {
            cXq.v(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (cXq != null) {
            cXq.b(context, i, z);
        }
    }

    public static void dM(Context context) {
        if (cXq != null) {
            cXq.dM(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (cXq != null) {
            cXq.c(context, i, z);
        }
    }

    public static Class<?> aFu() {
        if (cXq == null) {
            return null;
        }
        return cXq.aFu();
    }

    public static String aFv() {
        if (cXq == null) {
            return null;
        }
        return cXq.aFv();
    }

    public static void a(a aVar) {
        cXq = aVar;
    }

    public static int getCurrentTabType() {
        if (cXq == null) {
            return -1;
        }
        return cXq.getCurrentTabType();
    }
}
