package com.baidu.tbadk.core.d;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a XR = null;

    public static void f(Context context, int i) {
        if (XR != null) {
            XR.f(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (XR != null) {
            XR.b(context, i, z);
        }
    }

    public static void V(Context context) {
        if (XR != null) {
            XR.V(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (XR != null) {
            XR.c(context, i, z);
        }
    }

    public static Class<?> tL() {
        if (XR == null) {
            return null;
        }
        return XR.tL();
    }

    public static String tM() {
        if (XR == null) {
            return null;
        }
        return XR.tM();
    }

    public static void a(a aVar) {
        XR = aVar;
    }

    public static int getCurrentTabType() {
        if (XR == null) {
            return -1;
        }
        return XR.getCurrentTabType();
    }
}
