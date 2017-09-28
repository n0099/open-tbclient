package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a adr = null;

    public static void i(Context context, int i) {
        if (adr != null) {
            adr.i(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (adr != null) {
            adr.c(context, i, z);
        }
    }

    public static void aF(Context context) {
        if (adr != null) {
            adr.aF(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (adr != null) {
            adr.d(context, i, z);
        }
    }

    public static Class<?> tV() {
        if (adr == null) {
            return null;
        }
        return adr.tV();
    }

    public static String tW() {
        if (adr == null) {
            return null;
        }
        return adr.tW();
    }

    public static void a(a aVar) {
        adr = aVar;
    }

    public static int getCurrentTabType() {
        if (adr == null) {
            return -1;
        }
        return adr.getCurrentTabType();
    }
}
