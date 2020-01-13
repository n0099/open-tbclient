package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a cTn = null;

    public static void v(Context context, int i) {
        if (cTn != null) {
            cTn.v(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (cTn != null) {
            cTn.b(context, i, z);
        }
    }

    public static void dI(Context context) {
        if (cTn != null) {
            cTn.dI(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (cTn != null) {
            cTn.c(context, i, z);
        }
    }

    public static Class<?> aDi() {
        if (cTn == null) {
            return null;
        }
        return cTn.aDi();
    }

    public static String aDj() {
        if (cTn == null) {
            return null;
        }
        return cTn.aDj();
    }

    public static void a(a aVar) {
        cTn = aVar;
    }

    public static int getCurrentTabType() {
        if (cTn == null) {
            return -1;
        }
        return cTn.getCurrentTabType();
    }
}
