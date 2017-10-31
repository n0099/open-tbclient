package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a adD = null;

    public static void h(Context context, int i) {
        if (adD != null) {
            adD.h(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (adD != null) {
            adD.c(context, i, z);
        }
    }

    public static void aE(Context context) {
        if (adD != null) {
            adD.aE(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (adD != null) {
            adD.d(context, i, z);
        }
    }

    public static Class<?> tV() {
        if (adD == null) {
            return null;
        }
        return adD.tV();
    }

    public static String tW() {
        if (adD == null) {
            return null;
        }
        return adD.tW();
    }

    public static void a(a aVar) {
        adD = aVar;
    }

    public static int getCurrentTabType() {
        if (adD == null) {
            return -1;
        }
        return adD.getCurrentTabType();
    }
}
