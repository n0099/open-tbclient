package com.baidu.pass.biometrics.base.utils;

import android.content.res.Resources;
/* loaded from: classes2.dex */
public class DensityUtil {

    /* renamed from: a  reason: collision with root package name */
    public float f9118a = Resources.getSystem().getDisplayMetrics().density;

    public static int dp2px(float f2) {
        return (int) ((f2 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static float px2dp(float f2) {
        return f2 / Resources.getSystem().getDisplayMetrics().density;
    }

    public int dip2px(float f2) {
        return (int) ((f2 * this.f9118a) + 0.5f);
    }

    public float px2dip(float f2) {
        return f2 / this.f9118a;
    }
}
