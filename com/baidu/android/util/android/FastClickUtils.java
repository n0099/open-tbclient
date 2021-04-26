package com.baidu.android.util.android;
/* loaded from: classes.dex */
public class FastClickUtils {
    public static final int CLICK_GAP_TIME = 1300;
    public static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - lastClickTime;
        lastClickTime = currentTimeMillis;
        return j > 0 && j < 1300;
    }
}
