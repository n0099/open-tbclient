package com.baidu.searchbox.ng.ai.apps.util;

import android.os.Build;
/* loaded from: classes2.dex */
public final class AiAppAPIUtils {
    public static final int KITKAT = 19;
    public static final int LOLLIPOP = 21;
    public static final int MARSHMALLOW = 23;
    public static final int Nougat = 24;
    public static final int NougatPlus = 25;

    private AiAppAPIUtils() {
    }

    public static boolean hasFroyo() {
        return Build.VERSION.SDK_INT >= 8;
    }

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

    public static boolean hasHoneycombMR1() {
        return Build.VERSION.SDK_INT >= 12;
    }

    public static boolean hasICS() {
        return Build.VERSION.SDK_INT >= 14;
    }

    public static boolean hasICSMR1() {
        return Build.VERSION.SDK_INT >= 15;
    }

    public static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean hasJellyBeanMR1() {
        return Build.VERSION.SDK_INT >= 17;
    }

    public static boolean hasJellyBeanMR2() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static boolean isKitKat() {
        return Build.VERSION.SDK_INT == 19;
    }

    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static final boolean isLollipop() {
        return Build.VERSION.SDK_INT == 21;
    }

    public static boolean hasMarshMallow() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean hasNougat() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean hasNougatMR1() {
        return Build.VERSION.SDK_INT >= 25;
    }

    public static boolean hasOreo() {
        return Build.VERSION.SDK_INT >= 26;
    }
}
