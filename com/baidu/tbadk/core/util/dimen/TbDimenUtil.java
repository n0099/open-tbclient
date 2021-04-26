package com.baidu.tbadk.core.util.dimen;

import android.util.DisplayMetrics;
/* loaded from: classes3.dex */
public class TbDimenUtil {
    public static void setDensity(DisplayMetrics displayMetrics, float f2, int i2) {
        if (displayMetrics == null) {
            return;
        }
        displayMetrics.density = f2;
        displayMetrics.densityDpi = i2;
        displayMetrics.scaledDensity = f2;
    }
}
