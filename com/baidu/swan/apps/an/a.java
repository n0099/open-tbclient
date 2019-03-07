package com.baidu.swan.apps.an;

import android.os.Build;
/* loaded from: classes2.dex */
public final class a {
    public static boolean hasGingerbread() {
        return Build.VERSION.SDK_INT >= 9;
    }

    public static boolean LK() {
        return Build.VERSION.SDK_INT == 10;
    }

    public static boolean LL() {
        return Build.VERSION.SDK_INT == 9;
    }

    public static boolean hasHoneycomb() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean LM() {
        return Build.VERSION.SDK_INT >= 22;
    }

    public static boolean LN() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean hasNougat() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean LO() {
        return Build.VERSION.SDK_INT >= 26;
    }
}
