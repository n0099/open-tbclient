package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a adV = null;

    public static void h(Context context, int i) {
        if (adV != null) {
            adV.h(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (adV != null) {
            adV.c(context, i, z);
        }
    }

    public static void aD(Context context) {
        if (adV != null) {
            adV.aD(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (adV != null) {
            adV.d(context, i, z);
        }
    }

    public static Class<?> tV() {
        if (adV == null) {
            return null;
        }
        return adV.tV();
    }

    public static String tW() {
        if (adV == null) {
            return null;
        }
        return adV.tW();
    }

    public static void a(a aVar) {
        adV = aVar;
    }

    public static int getCurrentTabType() {
        if (adV == null) {
            return -1;
        }
        return adV.getCurrentTabType();
    }
}
