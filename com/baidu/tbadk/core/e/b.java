package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a eKB = null;

    public static void r(Context context, int i) {
        if (eKB != null) {
            eKB.r(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (eKB != null) {
            eKB.c(context, i, z);
        }
    }

    public static void dY(Context context) {
        if (eKB != null) {
            eKB.dY(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (eKB != null) {
            eKB.d(context, i, z);
        }
    }

    public static Class<?> bpX() {
        if (eKB == null) {
            return null;
        }
        return eKB.bpX();
    }

    public static String bpY() {
        if (eKB == null) {
            return null;
        }
        return eKB.bpY();
    }

    public static void a(a aVar) {
        eKB = aVar;
    }

    public static int getCurrentTabType() {
        if (eKB == null) {
            return -1;
        }
        return eKB.getCurrentTabType();
    }
}
