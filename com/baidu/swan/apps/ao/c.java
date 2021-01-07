package com.baidu.swan.apps.ao;

import android.os.Build;
/* loaded from: classes9.dex */
public final class c {
    public static boolean hasGingerbread() {
        return Build.VERSION.SDK_INT >= 9;
    }

    public static boolean isGingerbreadmr1() {
        return Build.VERSION.SDK_INT == 10;
    }

    public static boolean isGingerbread() {
        return Build.VERSION.SDK_INT == 9;
    }

    public static boolean hasHoneycomb() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public static boolean hasJellyBeanMR2() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean hasLollipopMR1() {
        return Build.VERSION.SDK_INT >= 22;
    }

    public static boolean hasMarshMallow() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean hasNougat() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean hasOreo() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean aQW() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
