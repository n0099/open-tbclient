package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a adS = null;

    public static void h(Context context, int i) {
        if (adS != null) {
            adS.h(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (adS != null) {
            adS.c(context, i, z);
        }
    }

    public static void aD(Context context) {
        if (adS != null) {
            adS.aD(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (adS != null) {
            adS.d(context, i, z);
        }
    }

    public static Class<?> tV() {
        if (adS == null) {
            return null;
        }
        return adS.tV();
    }

    public static String tW() {
        if (adS == null) {
            return null;
        }
        return adS.tW();
    }

    public static void a(a aVar) {
        adS = aVar;
    }

    public static int getCurrentTabType() {
        if (adS == null) {
            return -1;
        }
        return adS.getCurrentTabType();
    }
}
