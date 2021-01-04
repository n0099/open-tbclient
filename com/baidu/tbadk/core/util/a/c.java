package com.baidu.tbadk.core.util.a;

import android.util.DisplayMetrics;
/* loaded from: classes.dex */
public class c {
    public static void a(DisplayMetrics displayMetrics, float f, int i) {
        if (displayMetrics != null) {
            displayMetrics.density = f;
            displayMetrics.densityDpi = i;
            displayMetrics.scaledDensity = f;
        }
    }
}
