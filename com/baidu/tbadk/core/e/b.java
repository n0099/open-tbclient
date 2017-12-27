package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a aSh = null;

    public static void u(Context context, int i) {
        if (aSh != null) {
            aSh.u(context, i);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (aSh != null) {
            aSh.d(context, i, z);
        }
    }

    public static void aP(Context context) {
        if (aSh != null) {
            aSh.aP(context);
        }
    }

    public static void e(Context context, int i, boolean z) {
        if (aSh != null) {
            aSh.e(context, i, z);
        }
    }

    public static Class<?> Bv() {
        if (aSh == null) {
            return null;
        }
        return aSh.Bv();
    }

    public static String Bw() {
        if (aSh == null) {
            return null;
        }
        return aSh.Bw();
    }

    public static void a(a aVar) {
        aSh = aVar;
    }

    public static int getCurrentTabType() {
        if (aSh == null) {
            return -1;
        }
        return aSh.getCurrentTabType();
    }
}
