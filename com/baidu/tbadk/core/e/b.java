package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a azr = null;

    public static void k(Context context, int i) {
        if (azr != null) {
            azr.k(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (azr != null) {
            azr.c(context, i, z);
        }
    }

    public static void by(Context context) {
        if (azr != null) {
            azr.by(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (azr != null) {
            azr.d(context, i, z);
        }
    }

    public static Class<?> CE() {
        if (azr == null) {
            return null;
        }
        return azr.CE();
    }

    public static String CF() {
        if (azr == null) {
            return null;
        }
        return azr.CF();
    }

    public static void a(a aVar) {
        azr = aVar;
    }

    public static int getCurrentTabType() {
        if (azr == null) {
            return -1;
        }
        return azr.getCurrentTabType();
    }
}
