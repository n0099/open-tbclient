package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a adU = null;

    public static void i(Context context, int i) {
        if (adU != null) {
            adU.i(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (adU != null) {
            adU.c(context, i, z);
        }
    }

    public static void aF(Context context) {
        if (adU != null) {
            adU.aF(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (adU != null) {
            adU.d(context, i, z);
        }
    }

    public static Class<?> us() {
        if (adU == null) {
            return null;
        }
        return adU.us();
    }

    public static String ut() {
        if (adU == null) {
            return null;
        }
        return adU.ut();
    }

    public static void a(a aVar) {
        adU = aVar;
    }

    public static int getCurrentTabType() {
        if (adU == null) {
            return -1;
        }
        return adU.getCurrentTabType();
    }
}
