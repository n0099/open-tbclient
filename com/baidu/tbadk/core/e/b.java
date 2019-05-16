package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a bOM = null;

    public static void o(Context context, int i) {
        if (bOM != null) {
            bOM.o(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (bOM != null) {
            bOM.b(context, i, z);
        }
    }

    public static void cr(Context context) {
        if (bOM != null) {
            bOM.cr(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (bOM != null) {
            bOM.c(context, i, z);
        }
    }

    public static Class<?> agD() {
        if (bOM == null) {
            return null;
        }
        return bOM.agD();
    }

    public static String agE() {
        if (bOM == null) {
            return null;
        }
        return bOM.agE();
    }

    public static void a(a aVar) {
        bOM = aVar;
    }

    public static int getCurrentTabType() {
        if (bOM == null) {
            return -1;
        }
        return bOM.getCurrentTabType();
    }
}
