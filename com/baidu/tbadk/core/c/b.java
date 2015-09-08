package com.baidu.tbadk.core.c;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a XR = null;

    public static void e(Context context, int i) {
        if (XR != null) {
            XR.e(context, i);
        }
    }

    public static void aa(Context context) {
        if (XR != null) {
            XR.aa(context);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (XR != null) {
            XR.a(context, i, z);
        }
    }

    public static Class<?> tq() {
        if (XR == null) {
            return null;
        }
        return XR.tq();
    }

    public static String tr() {
        if (XR == null) {
            return null;
        }
        return XR.tr();
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
