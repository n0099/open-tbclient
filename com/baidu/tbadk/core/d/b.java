package com.baidu.tbadk.core.d;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a Ye = null;

    public static void f(Context context, int i) {
        if (Ye != null) {
            Ye.f(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (Ye != null) {
            Ye.b(context, i, z);
        }
    }

    public static void V(Context context) {
        if (Ye != null) {
            Ye.V(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (Ye != null) {
            Ye.c(context, i, z);
        }
    }

    public static Class<?> ua() {
        if (Ye == null) {
            return null;
        }
        return Ye.ua();
    }

    public static String ub() {
        if (Ye == null) {
            return null;
        }
        return Ye.ub();
    }

    public static void a(a aVar) {
        Ye = aVar;
    }

    public static int getCurrentTabType() {
        if (Ye == null) {
            return -1;
        }
        return Ye.getCurrentTabType();
    }
}
