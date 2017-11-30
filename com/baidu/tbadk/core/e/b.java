package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a adY = null;

    public static void h(Context context, int i) {
        if (adY != null) {
            adY.h(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (adY != null) {
            adY.c(context, i, z);
        }
    }

    public static void aG(Context context) {
        if (adY != null) {
            adY.aG(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (adY != null) {
            adY.d(context, i, z);
        }
    }

    public static Class<?> tY() {
        if (adY == null) {
            return null;
        }
        return adY.tY();
    }

    public static String tZ() {
        if (adY == null) {
            return null;
        }
        return adY.tZ();
    }

    public static void a(a aVar) {
        adY = aVar;
    }

    public static int getCurrentTabType() {
        if (adY == null) {
            return -1;
        }
        return adY.getCurrentTabType();
    }
}
