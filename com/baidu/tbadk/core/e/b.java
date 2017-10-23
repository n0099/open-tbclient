package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a adf = null;

    public static void h(Context context, int i) {
        if (adf != null) {
            adf.h(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (adf != null) {
            adf.c(context, i, z);
        }
    }

    public static void aE(Context context) {
        if (adf != null) {
            adf.aE(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (adf != null) {
            adf.d(context, i, z);
        }
    }

    public static Class<?> tO() {
        if (adf == null) {
            return null;
        }
        return adf.tO();
    }

    public static String tP() {
        if (adf == null) {
            return null;
        }
        return adf.tP();
    }

    public static void a(a aVar) {
        adf = aVar;
    }

    public static int getCurrentTabType() {
        if (adf == null) {
            return -1;
        }
        return adf.getCurrentTabType();
    }
}
