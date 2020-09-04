package com.baidu.tbadk.core.e;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a ehQ = null;

    public static void r(Context context, int i) {
        if (ehQ != null) {
            ehQ.r(context, i);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (ehQ != null) {
            ehQ.c(context, i, z);
        }
    }

    public static void dT(Context context) {
        if (ehQ != null) {
            ehQ.dT(context);
        }
    }

    public static void d(Context context, int i, boolean z) {
        if (ehQ != null) {
            ehQ.d(context, i, z);
        }
    }

    public static Class<?> bib() {
        if (ehQ == null) {
            return null;
        }
        return ehQ.bib();
    }

    public static String bic() {
        if (ehQ == null) {
            return null;
        }
        return ehQ.bic();
    }

    public static void a(a aVar) {
        ehQ = aVar;
    }

    public static int getCurrentTabType() {
        if (ehQ == null) {
            return -1;
        }
        return ehQ.getCurrentTabType();
    }
}
