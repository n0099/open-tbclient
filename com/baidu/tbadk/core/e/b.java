package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a azq = null;

    public static void k(Context context, int i) {
        if (azq != null) {
            azq.k(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (azq != null) {
            azq.c(context, i, z);
        }
    }

    public static void by(Context context) {
        if (azq != null) {
            azq.by(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (azq != null) {
            azq.d(context, i, z);
        }
    }

    public static Class<?> CE() {
        if (azq == null) {
            return null;
        }
        return azq.CE();
    }

    public static String CF() {
        if (azq == null) {
            return null;
        }
        return azq.CF();
    }

    public static void a(a aVar) {
        azq = aVar;
    }

    public static int getCurrentTabType() {
        if (azq == null) {
            return -1;
        }
        return azq.getCurrentTabType();
    }
}
