package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes13.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int bGz = 0;
    private static int bGA = 0;
    private static int bGB = 0;
    private static int bGC = 0;
    private static int bGD = 0;

    public static int aV(Context context) {
        if (bGz == 0) {
            bGz = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return bGz;
    }

    public static int aW(Context context) {
        if (bGA == 0) {
            bGA = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return bGA;
    }
}
