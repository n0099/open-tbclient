package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a eZO = null;
    public static int eZP = 0;
    public static int eZQ = 0;
    public static int eZR = 0;
    public static int eZS = 1;

    public static void B(Context context, int i) {
        if (eZO != null) {
            eZO.B(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (eZO != null) {
            eZO.c(context, i, z);
        }
    }

    public static void eS(Context context) {
        if (eZO != null) {
            eZO.eS(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (eZO != null) {
            eZO.d(context, i, z);
        }
    }

    public static Class<?> brH() {
        if (eZO == null) {
            return null;
        }
        return eZO.brH();
    }

    public static String brI() {
        if (eZO == null) {
            return null;
        }
        return eZO.brI();
    }

    public static void a(a aVar) {
        eZO = aVar;
    }

    public static int getCurrentTabType() {
        if (eZO == null) {
            return -1;
        }
        return eZO.getCurrentTabType();
    }
}
