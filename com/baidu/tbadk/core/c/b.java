package com.baidu.tbadk.core.c;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a Sd = null;

    public static void e(Context context, int i) {
        if (Sd != null) {
            Sd.e(context, i);
        }
    }

    public static void Y(Context context) {
        if (Sd != null) {
            Sd.Y(context);
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (Sd != null) {
            Sd.a(context, i, z);
        }
    }

    public static Class<?> ru() {
        if (Sd == null) {
            return null;
        }
        return Sd.ru();
    }

    public static String rv() {
        if (Sd == null) {
            return null;
        }
        return Sd.rv();
    }

    public static void a(a aVar) {
        if (aVar != null) {
            Sd = aVar;
        }
    }

    public static int getCurrentTabType() {
        if (Sd == null) {
            return -1;
        }
        return Sd.getCurrentTabType();
    }
}
