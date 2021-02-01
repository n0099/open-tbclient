package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a eYp = null;
    public static int eYq = 0;
    public static int eYr = 0;
    public static int eYs = 0;
    public static int eYt = 1;

    public static void B(Context context, int i) {
        if (eYp != null) {
            eYp.B(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (eYp != null) {
            eYp.c(context, i, z);
        }
    }

    public static void eT(Context context) {
        if (eYp != null) {
            eYp.eT(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (eYp != null) {
            eYp.d(context, i, z);
        }
    }

    public static Class<?> brG() {
        if (eYp == null) {
            return null;
        }
        return eYp.brG();
    }

    public static String brH() {
        if (eYp == null) {
            return null;
        }
        return eYp.brH();
    }

    public static void a(a aVar) {
        eYp = aVar;
    }

    public static int getCurrentTabType() {
        if (eYp == null) {
            return -1;
        }
        return eYp.getCurrentTabType();
    }
}
