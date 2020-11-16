package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a eJA = null;

    public static void r(Context context, int i) {
        if (eJA != null) {
            eJA.r(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (eJA != null) {
            eJA.c(context, i, z);
        }
    }

    public static void dY(Context context) {
        if (eJA != null) {
            eJA.dY(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (eJA != null) {
            eJA.d(context, i, z);
        }
    }

    public static Class<?> bpk() {
        if (eJA == null) {
            return null;
        }
        return eJA.bpk();
    }

    public static String bpl() {
        if (eJA == null) {
            return null;
        }
        return eJA.bpl();
    }

    public static void a(a aVar) {
        eJA = aVar;
    }

    public static int getCurrentTabType() {
        if (eJA == null) {
            return -1;
        }
        return eJA.getCurrentTabType();
    }
}
