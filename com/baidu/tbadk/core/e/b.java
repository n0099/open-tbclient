package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a bHk = null;

    public static void o(Context context, int i) {
        if (bHk != null) {
            bHk.o(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (bHk != null) {
            bHk.c(context, i, z);
        }
    }

    public static void cM(Context context) {
        if (bHk != null) {
            bHk.cM(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (bHk != null) {
            bHk.d(context, i, z);
        }
    }

    public static Class<?> abO() {
        if (bHk == null) {
            return null;
        }
        return bHk.abO();
    }

    public static String abP() {
        if (bHk == null) {
            return null;
        }
        return bHk.abP();
    }

    public static void a(a aVar) {
        bHk = aVar;
    }

    public static int getCurrentTabType() {
        if (bHk == null) {
            return -1;
        }
        return bHk.getCurrentTabType();
    }
}
