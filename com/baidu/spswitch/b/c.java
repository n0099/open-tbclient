package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes13.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int byW = 0;
    private static int byX = 0;
    private static int byY = 0;
    private static int byZ = 0;
    private static int bza = 0;

    public static int aL(Context context) {
        if (byW == 0) {
            byW = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return byW;
    }

    public static int aM(Context context) {
        if (byX == 0) {
            byX = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return byX;
    }
}
