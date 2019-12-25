package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a cTd = null;

    public static void v(Context context, int i) {
        if (cTd != null) {
            cTd.v(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (cTd != null) {
            cTd.b(context, i, z);
        }
    }

    public static void dI(Context context) {
        if (cTd != null) {
            cTd.dI(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (cTd != null) {
            cTd.c(context, i, z);
        }
    }

    public static Class<?> aCP() {
        if (cTd == null) {
            return null;
        }
        return cTd.aCP();
    }

    public static String aCQ() {
        if (cTd == null) {
            return null;
        }
        return cTd.aCQ();
    }

    public static void a(a aVar) {
        cTd = aVar;
    }

    public static int getCurrentTabType() {
        if (cTd == null) {
            return -1;
        }
        return cTd.getCurrentTabType();
    }
}
