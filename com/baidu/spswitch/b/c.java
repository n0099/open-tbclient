package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes4.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int cDX = 0;
    private static int cDY = 0;
    private static int cDZ = 0;
    private static int cEa = 0;
    private static int cEb = 0;

    public static int bW(Context context) {
        if (cDX == 0) {
            cDX = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return cDX;
    }

    public static int bX(Context context) {
        if (cDY == 0) {
            cDY = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return cDY;
    }
}
