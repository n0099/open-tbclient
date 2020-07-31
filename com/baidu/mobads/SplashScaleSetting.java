package com.baidu.mobads;
/* loaded from: classes20.dex */
public class SplashScaleSetting {
    private static int a = 0;
    public final int TYPE_CENTER_CROP = 0;
    public final int TYPE_FIT_XY = 1;

    public static void setSplashScaleState(int i) {
        a = i;
    }

    public static int getSplashScaleState() {
        return a;
    }
}
