package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a bHn = null;

    public static void o(Context context, int i) {
        if (bHn != null) {
            bHn.o(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (bHn != null) {
            bHn.c(context, i, z);
        }
    }

    public static void cM(Context context) {
        if (bHn != null) {
            bHn.cM(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (bHn != null) {
            bHn.d(context, i, z);
        }
    }

    public static Class<?> abL() {
        if (bHn == null) {
            return null;
        }
        return bHn.abL();
    }

    public static String abM() {
        if (bHn == null) {
            return null;
        }
        return bHn.abM();
    }

    public static void a(a aVar) {
        bHn = aVar;
    }

    public static int getCurrentTabType() {
        if (bHn == null) {
            return -1;
        }
        return bHn.getCurrentTabType();
    }
}
