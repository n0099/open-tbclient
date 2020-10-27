package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a eEM = null;

    public static void r(Context context, int i) {
        if (eEM != null) {
            eEM.r(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (eEM != null) {
            eEM.c(context, i, z);
        }
    }

    public static void dY(Context context) {
        if (eEM != null) {
            eEM.dY(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (eEM != null) {
            eEM.d(context, i, z);
        }
    }

    public static Class<?> bnx() {
        if (eEM == null) {
            return null;
        }
        return eEM.bnx();
    }

    public static String bny() {
        if (eEM == null) {
            return null;
        }
        return eEM.bny();
    }

    public static void a(a aVar) {
        eEM = aVar;
    }

    public static int getCurrentTabType() {
        if (eEM == null) {
            return -1;
        }
        return eEM.getCurrentTabType();
    }
}
