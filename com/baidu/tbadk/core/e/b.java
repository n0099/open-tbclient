package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a faK = null;
    public static int faL = 0;

    public static void B(Context context, int i) {
        if (faK != null) {
            faK.B(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (faK != null) {
            faK.c(context, i, z);
        }
    }

    public static void eW(Context context) {
        if (faK != null) {
            faK.eW(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (faK != null) {
            faK.d(context, i, z);
        }
    }

    public static Class<?> bvh() {
        if (faK == null) {
            return null;
        }
        return faK.bvh();
    }

    public static String bvi() {
        if (faK == null) {
            return null;
        }
        return faK.bvi();
    }

    public static void a(a aVar) {
        faK = aVar;
    }

    public static int getCurrentTabType() {
        if (faK == null) {
            return -1;
        }
        return faK.getCurrentTabType();
    }
}
