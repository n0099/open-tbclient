package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a Xk = null;

    public static void g(Context context, int i) {
        if (Xk != null) {
            Xk.g(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (Xk != null) {
            Xk.b(context, i, z);
        }
    }

    public static void V(Context context) {
        if (Xk != null) {
            Xk.V(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (Xk != null) {
            Xk.c(context, i, z);
        }
    }

    public static Class<?> tJ() {
        if (Xk == null) {
            return null;
        }
        return Xk.tJ();
    }

    public static String tK() {
        if (Xk == null) {
            return null;
        }
        return Xk.tK();
    }

    public static void a(a aVar) {
        Xk = aVar;
    }

    public static int getCurrentTabType() {
        if (Xk == null) {
            return -1;
        }
        return Xk.getCurrentTabType();
    }
}
