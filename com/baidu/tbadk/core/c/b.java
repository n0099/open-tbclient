package com.baidu.tbadk.core.c;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a SO = null;

    public static void e(Context context, int i) {
        if (SO != null) {
            SO.e(context, i);
        }
    }

    public static void Y(Context context) {
        if (SO != null) {
            SO.Y(context);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (SO != null) {
            SO.a(context, i, z);
        }
    }

    public static Class<?> se() {
        if (SO == null) {
            return null;
        }
        return SO.se();
    }

    public static String sf() {
        if (SO == null) {
            return null;
        }
        return SO.sf();
    }

    public static void a(a aVar) {
        if (aVar != null) {
            SO = aVar;
        }
    }

    public static int getCurrentTabType() {
        if (SO == null) {
            return -1;
        }
        return SO.getCurrentTabType();
    }
}
