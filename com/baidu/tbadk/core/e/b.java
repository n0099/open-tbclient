package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes2.dex */
public class b {
    private static a ehM = null;

    public static void r(Context context, int i) {
        if (ehM != null) {
            ehM.r(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (ehM != null) {
            ehM.c(context, i, z);
        }
    }

    public static void dT(Context context) {
        if (ehM != null) {
            ehM.dT(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (ehM != null) {
            ehM.d(context, i, z);
        }
    }

    public static Class<?> bib() {
        if (ehM == null) {
            return null;
        }
        return ehM.bib();
    }

    public static String bic() {
        if (ehM == null) {
            return null;
        }
        return ehM.bic();
    }

    public static void a(a aVar) {
        ehM = aVar;
    }

    public static int getCurrentTabType() {
        if (ehM == null) {
            return -1;
        }
        return ehM.getCurrentTabType();
    }
}
