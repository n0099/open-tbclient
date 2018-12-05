package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a ayN = null;

    public static void k(Context context, int i) {
        if (ayN != null) {
            ayN.k(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (ayN != null) {
            ayN.c(context, i, z);
        }
    }

    public static void by(Context context) {
        if (ayN != null) {
            ayN.by(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (ayN != null) {
            ayN.d(context, i, z);
        }
    }

    public static Class<?> Cr() {
        if (ayN == null) {
            return null;
        }
        return ayN.Cr();
    }

    public static String Cs() {
        if (ayN == null) {
            return null;
        }
        return ayN.Cs();
    }

    public static void a(a aVar) {
        ayN = aVar;
    }

    public static int getCurrentTabType() {
        if (ayN == null) {
            return -1;
        }
        return ayN.getCurrentTabType();
    }
}
