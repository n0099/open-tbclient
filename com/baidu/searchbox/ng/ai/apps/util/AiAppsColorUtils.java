package com.baidu.searchbox.ng.ai.apps.util;

import android.support.annotation.ColorInt;
/* loaded from: classes2.dex */
public class AiAppsColorUtils {
    private static final int COLOR_THRESHOLD = 220;

    public static boolean isLightColor(@ColorInt int i) {
        return ((int) (((((double) ((65280 & i) >> 8)) * 0.587d) + (0.299d * ((double) ((16711680 & i) >> 16)))) + (((double) (i & 255)) * 0.114d))) >= 220;
    }
}
