package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a acS = null;

    public static void i(Context context, int i) {
        if (acS != null) {
            acS.i(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (acS != null) {
            acS.b(context, i, z);
        }
    }

    public static void ay(Context context) {
        if (acS != null) {
            acS.ay(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (acS != null) {
            acS.c(context, i, z);
        }
    }

    public static Class<?> uf() {
        if (acS == null) {
            return null;
        }
        return acS.uf();
    }

    public static String ug() {
        if (acS == null) {
            return null;
        }
        return acS.ug();
    }

    public static void a(a aVar) {
        acS = aVar;
    }

    public static int getCurrentTabType() {
        if (acS == null) {
            return -1;
        }
        return acS.getCurrentTabType();
    }
}
