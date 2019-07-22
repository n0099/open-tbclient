package com.baidu.tbadk.core.f;

import android.content.Context;
/* loaded from: classes.dex */
public class b {
    private static a bPN = null;

    public static void o(Context context, int i) {
        if (bPN != null) {
            bPN.o(context, i);
        }
    }

    public static void b(Context context, int i, boolean z) {
        if (bPN != null) {
            bPN.b(context, i, z);
        }
    }

    public static void cs(Context context) {
        if (bPN != null) {
            bPN.cs(context);
        }
    }

    public static void c(Context context, int i, boolean z) {
        if (bPN != null) {
            bPN.c(context, i, z);
        }
    }

    public static Class<?> ahF() {
        if (bPN == null) {
            return null;
        }
        return bPN.ahF();
    }

    public static String ahG() {
        if (bPN == null) {
            return null;
        }
        return bPN.ahG();
    }

    public static void a(a aVar) {
        bPN = aVar;
    }

    public static int getCurrentTabType() {
        if (bPN == null) {
            return -1;
        }
        return bPN.getCurrentTabType();
    }
}
