package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a eVZ = null;
    public static int eWa = 0;
    public static int eWb = 0;
    public static int eWc = 0;
    public static int eWd = 1;

    public static void B(Context context, int i) {
        if (eVZ != null) {
            eVZ.B(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (eVZ != null) {
            eVZ.c(context, i, z);
        }
    }

    public static void eU(Context context) {
        if (eVZ != null) {
            eVZ.eU(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (eVZ != null) {
            eVZ.d(context, i, z);
        }
    }

    public static Class<?> brn() {
        if (eVZ == null) {
            return null;
        }
        return eVZ.brn();
    }

    public static String bro() {
        if (eVZ == null) {
            return null;
        }
        return eVZ.bro();
    }

    public static void a(a aVar) {
        eVZ = aVar;
    }

    public static int getCurrentTabType() {
        if (eVZ == null) {
            return -1;
        }
        return eVZ.getCurrentTabType();
    }
}
