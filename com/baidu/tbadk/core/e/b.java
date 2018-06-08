package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a anb = null;

    public static void g(Context context, int i) {
        if (anb != null) {
            anb.g(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (anb != null) {
            anb.b(context, i, z);
        }
    }

    public static void aI(Context context) {
        if (anb != null) {
            anb.aI(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (anb != null) {
            anb.c(context, i, z);
        }
    }

    public static Class<?> xN() {
        if (anb == null) {
            return null;
        }
        return anb.xN();
    }

    public static String xO() {
        if (anb == null) {
            return null;
        }
        return anb.xO();
    }

    public static void a(a aVar) {
        anb = aVar;
    }

    public static int getCurrentTabType() {
        if (anb == null) {
            return -1;
        }
        return anb.getCurrentTabType();
    }
}
