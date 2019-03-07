package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a bHj = null;

    public static void o(Context context, int i) {
        if (bHj != null) {
            bHj.o(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (bHj != null) {
            bHj.c(context, i, z);
        }
    }

    public static void cM(Context context) {
        if (bHj != null) {
            bHj.cM(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (bHj != null) {
            bHj.d(context, i, z);
        }
    }

    public static Class<?> abO() {
        if (bHj == null) {
            return null;
        }
        return bHj.abO();
    }

    public static String abP() {
        if (bHj == null) {
            return null;
        }
        return bHj.abP();
    }

    public static void a(a aVar) {
        bHj = aVar;
    }

    public static int getCurrentTabType() {
        if (bHj == null) {
            return -1;
        }
        return bHj.getCurrentTabType();
    }
}
