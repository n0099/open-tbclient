package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a bON = null;

    public static void o(Context context, int i) {
        if (bON != null) {
            bON.o(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (bON != null) {
            bON.b(context, i, z);
        }
    }

    public static void cr(Context context) {
        if (bON != null) {
            bON.cr(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (bON != null) {
            bON.c(context, i, z);
        }
    }

    public static Class<?> agD() {
        if (bON == null) {
            return null;
        }
        return bON.agD();
    }

    public static String agE() {
        if (bON == null) {
            return null;
        }
        return bON.agE();
    }

    public static void a(a aVar) {
        bON = aVar;
    }

    public static int getCurrentTabType() {
        if (bON == null) {
            return -1;
        }
        return bON.getCurrentTabType();
    }
}
