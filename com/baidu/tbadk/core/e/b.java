package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a aSj = null;

    public static void u(Context context, int i) {
        if (aSj != null) {
            aSj.u(context, i);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (aSj != null) {
            aSj.d(context, i, z);
        }
    }

    public static void aP(Context context) {
        if (aSj != null) {
            aSj.aP(context);
        }
    }

    public static void e(Context context, int i, boolean z) {
        if (aSj != null) {
            aSj.e(context, i, z);
        }
    }

    public static Class<?> Bo() {
        if (aSj == null) {
            return null;
        }
        return aSj.Bo();
    }

    public static String Bp() {
        if (aSj == null) {
            return null;
        }
        return aSj.Bp();
    }

    public static void a(a aVar) {
        aSj = aVar;
    }

    public static int getCurrentTabType() {
        if (aSj == null) {
            return -1;
        }
        return aSj.getCurrentTabType();
    }
}
