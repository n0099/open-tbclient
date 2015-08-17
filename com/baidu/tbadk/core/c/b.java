package com.baidu.tbadk.core.c;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a XI = null;

    public static void e(Context context, int i) {
        if (XI != null) {
            XI.e(context, i);
        }
    }

    public static void aa(Context context) {
        if (XI != null) {
            XI.aa(context);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (XI != null) {
            XI.a(context, i, z);
        }
    }

    public static Class<?> tl() {
        if (XI == null) {
            return null;
        }
        return XI.tl();
    }

    public static String tm() {
        if (XI == null) {
            return null;
        }
        return XI.tm();
    }

    public static void a(a aVar) {
        XI = aVar;
    }

    public static int getCurrentTabType() {
        if (XI == null) {
            return -1;
        }
        return XI.getCurrentTabType();
    }
}
