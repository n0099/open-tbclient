package com.baidu.tbadk.core.d;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a YC = null;

    public static void f(Context context, int i) {
        if (YC != null) {
            YC.f(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (YC != null) {
            YC.b(context, i, z);
        }
    }

    public static void V(Context context) {
        if (YC != null) {
            YC.V(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (YC != null) {
            YC.c(context, i, z);
        }
    }

    public static Class<?> ue() {
        if (YC == null) {
            return null;
        }
        return YC.ue();
    }

    public static String uf() {
        if (YC == null) {
            return null;
        }
        return YC.uf();
    }

    public static void a(a aVar) {
        YC = aVar;
    }

    public static int getCurrentTabType() {
        if (YC == null) {
            return -1;
        }
        return YC.getCurrentTabType();
    }
}
