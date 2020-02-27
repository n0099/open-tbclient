package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a cXp = null;

    public static void v(Context context, int i) {
        if (cXp != null) {
            cXp.v(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (cXp != null) {
            cXp.b(context, i, z);
        }
    }

    public static void dM(Context context) {
        if (cXp != null) {
            cXp.dM(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (cXp != null) {
            cXp.c(context, i, z);
        }
    }

    public static Class<?> aFs() {
        if (cXp == null) {
            return null;
        }
        return cXp.aFs();
    }

    public static String aFt() {
        if (cXp == null) {
            return null;
        }
        return cXp.aFt();
    }

    public static void a(a aVar) {
        cXp = aVar;
    }

    public static int getCurrentTabType() {
        if (cXp == null) {
            return -1;
        }
        return cXp.getCurrentTabType();
    }
}
