package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a dRO = null;

    public static void q(Context context, int i) {
        if (dRO != null) {
            dRO.q(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (dRO != null) {
            dRO.b(context, i, z);
        }
    }

    public static void dG(Context context) {
        if (dRO != null) {
            dRO.dG(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (dRO != null) {
            dRO.c(context, i, z);
        }
    }

    public static Class<?> aVG() {
        if (dRO == null) {
            return null;
        }
        return dRO.aVG();
    }

    public static String aVH() {
        if (dRO == null) {
            return null;
        }
        return dRO.aVH();
    }

    public static void a(a aVar) {
        dRO = aVar;
    }

    public static int getCurrentTabType() {
        if (dRO == null) {
            return -1;
        }
        return dRO.getCurrentTabType();
    }
}
