package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a bHm = null;

    public static void o(Context context, int i) {
        if (bHm != null) {
            bHm.o(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (bHm != null) {
            bHm.c(context, i, z);
        }
    }

    public static void cM(Context context) {
        if (bHm != null) {
            bHm.cM(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (bHm != null) {
            bHm.d(context, i, z);
        }
    }

    public static Class<?> abL() {
        if (bHm == null) {
            return null;
        }
        return bHm.abL();
    }

    public static String abM() {
        if (bHm == null) {
            return null;
        }
        return bHm.abM();
    }

    public static void a(a aVar) {
        bHm = aVar;
    }

    public static int getCurrentTabType() {
        if (bHm == null) {
            return -1;
        }
        return bHm.getCurrentTabType();
    }
}
