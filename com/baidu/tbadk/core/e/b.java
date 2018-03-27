package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a aTF = null;

    public static void v(Context context, int i) {
        if (aTF != null) {
            aTF.v(context, i);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (aTF != null) {
            aTF.d(context, i, z);
        }
    }

    public static void aO(Context context) {
        if (aTF != null) {
            aTF.aO(context);
        }
    }

    public static void e(Context context, int i, boolean z) {
        if (aTF != null) {
            aTF.e(context, i, z);
        }
    }

    public static Class<?> BI() {
        if (aTF == null) {
            return null;
        }
        return aTF.BI();
    }

    public static String BJ() {
        if (aTF == null) {
            return null;
        }
        return aTF.BJ();
    }

    public static void a(a aVar) {
        aTF = aVar;
    }

    public static int getCurrentTabType() {
        if (aTF == null) {
            return -1;
        }
        return aTF.getCurrentTabType();
    }
}
