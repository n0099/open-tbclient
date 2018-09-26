package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a apJ = null;

    public static void j(Context context, int i) {
        if (apJ != null) {
            apJ.j(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (apJ != null) {
            apJ.c(context, i, z);
        }
    }

    public static void bo(Context context) {
        if (apJ != null) {
            apJ.bo(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (apJ != null) {
            apJ.d(context, i, z);
        }
    }

    public static Class<?> yY() {
        if (apJ == null) {
            return null;
        }
        return apJ.yY();
    }

    public static String yZ() {
        if (apJ == null) {
            return null;
        }
        return apJ.yZ();
    }

    public static void a(a aVar) {
        apJ = aVar;
    }

    public static int getCurrentTabType() {
        if (apJ == null) {
            return -1;
        }
        return apJ.getCurrentTabType();
    }
}
