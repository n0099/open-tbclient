package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes19.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int ctU = 0;
    private static int ctV = 0;
    private static int ctW = 0;
    private static int ctX = 0;
    private static int ctY = 0;

    public static int bh(Context context) {
        if (ctU == 0) {
            ctU = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return ctU;
    }

    public static int bi(Context context) {
        if (ctV == 0) {
            ctV = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return ctV;
    }
}
