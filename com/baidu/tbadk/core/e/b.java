package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a avn = null;

    public static void k(Context context, int i) {
        if (avn != null) {
            avn.k(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (avn != null) {
            avn.c(context, i, z);
        }
    }

    public static void bv(Context context) {
        if (avn != null) {
            avn.bv(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (avn != null) {
            avn.d(context, i, z);
        }
    }

    public static Class<?> Bn() {
        if (avn == null) {
            return null;
        }
        return avn.Bn();
    }

    public static String Bo() {
        if (avn == null) {
            return null;
        }
        return avn.Bo();
    }

    public static void a(a aVar) {
        avn = aVar;
    }

    public static int getCurrentTabType() {
        if (avn == null) {
            return -1;
        }
        return avn.getCurrentTabType();
    }
}
