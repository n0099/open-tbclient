package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes13.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int bLn = 0;
    private static int bLo = 0;
    private static int bLp = 0;
    private static int bLq = 0;
    private static int bLr = 0;

    public static int aW(Context context) {
        if (bLn == 0) {
            bLn = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return bLn;
    }

    public static int aX(Context context) {
        if (bLo == 0) {
            bLo = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return bLo;
    }
}
