package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a ayO = null;

    public static void k(Context context, int i) {
        if (ayO != null) {
            ayO.k(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (ayO != null) {
            ayO.c(context, i, z);
        }
    }

    public static void by(Context context) {
        if (ayO != null) {
            ayO.by(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (ayO != null) {
            ayO.d(context, i, z);
        }
    }

    public static Class<?> Cr() {
        if (ayO == null) {
            return null;
        }
        return ayO.Cr();
    }

    public static String Cs() {
        if (ayO == null) {
            return null;
        }
        return ayO.Cs();
    }

    public static void a(a aVar) {
        ayO = aVar;
    }

    public static int getCurrentTabType() {
        if (ayO == null) {
            return -1;
        }
        return ayO.getCurrentTabType();
    }
}
