package com.baidu.tbadk.core.c;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a ZB = null;

    public static void d(Context context, int i) {
        if (ZB != null) {
            ZB.d(context, i);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (ZB != null) {
            ZB.a(context, i, z);
        }
    }

    public static void aa(Context context) {
        if (ZB != null) {
            ZB.aa(context);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (ZB != null) {
            ZB.b(context, i, z);
        }
    }

    public static Class<?> uH() {
        if (ZB == null) {
            return null;
        }
        return ZB.uH();
    }

    public static String uI() {
        if (ZB == null) {
            return null;
        }
        return ZB.uI();
    }

    public static void a(a aVar) {
        ZB = aVar;
    }

    public static int getCurrentTabType() {
        if (ZB == null) {
            return -1;
        }
        return ZB.getCurrentTabType();
    }
}
