package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes13.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int byR = 0;
    private static int byS = 0;
    private static int byT = 0;
    private static int byU = 0;
    private static int byV = 0;

    public static int aX(Context context) {
        if (byR == 0) {
            byR = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return byR;
    }

    public static int aY(Context context) {
        if (byS == 0) {
            byS = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return byS;
    }
}
