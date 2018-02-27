package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a aTD = null;

    public static void v(Context context, int i) {
        if (aTD != null) {
            aTD.v(context, i);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (aTD != null) {
            aTD.d(context, i, z);
        }
    }

    public static void aO(Context context) {
        if (aTD != null) {
            aTD.aO(context);
        }
    }

    public static void e(Context context, int i, boolean z) {
        if (aTD != null) {
            aTD.e(context, i, z);
        }
    }

    public static Class<?> BH() {
        if (aTD == null) {
            return null;
        }
        return aTD.BH();
    }

    public static String BI() {
        if (aTD == null) {
            return null;
        }
        return aTD.BI();
    }

    public static void a(a aVar) {
        aTD = aVar;
    }

    public static int getCurrentTabType() {
        if (aTD == null) {
            return -1;
        }
        return aTD.getCurrentTabType();
    }
}
