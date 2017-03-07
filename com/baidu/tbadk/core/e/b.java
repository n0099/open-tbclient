package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a acy = null;

    public static void i(Context context, int i) {
        if (acy != null) {
            acy.i(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (acy != null) {
            acy.b(context, i, z);
        }
    }

    public static void at(Context context) {
        if (acy != null) {
            acy.at(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (acy != null) {
            acy.c(context, i, z);
        }
    }

    public static Class<?> ug() {
        if (acy == null) {
            return null;
        }
        return acy.ug();
    }

    public static String uh() {
        if (acy == null) {
            return null;
        }
        return acy.uh();
    }

    public static void a(a aVar) {
        acy = aVar;
    }

    public static int getCurrentTabType() {
        if (acy == null) {
            return -1;
        }
        return acy.getCurrentTabType();
    }
}
