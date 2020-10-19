package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes19.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int cfx = 0;
    private static int cfy = 0;
    private static int cfz = 0;
    private static int cfA = 0;
    private static int cfB = 0;

    public static int bh(Context context) {
        if (cfx == 0) {
            cfx = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return cfx;
    }

    public static int bi(Context context) {
        if (cfy == 0) {
            cfy = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return cfy;
    }
}
