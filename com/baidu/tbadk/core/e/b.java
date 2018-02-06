package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a aTO = null;

    public static void v(Context context, int i) {
        if (aTO != null) {
            aTO.v(context, i);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (aTO != null) {
            aTO.d(context, i, z);
        }
    }

    public static void aO(Context context) {
        if (aTO != null) {
            aTO.aO(context);
        }
    }

    public static void e(Context context, int i, boolean z) {
        if (aTO != null) {
            aTO.e(context, i, z);
        }
    }

    public static Class<?> BH() {
        if (aTO == null) {
            return null;
        }
        return aTO.BH();
    }

    public static String BI() {
        if (aTO == null) {
            return null;
        }
        return aTO.BI();
    }

    public static void a(a aVar) {
        aTO = aVar;
    }

    public static int getCurrentTabType() {
        if (aTO == null) {
            return -1;
        }
        return aTO.getCurrentTabType();
    }
}
