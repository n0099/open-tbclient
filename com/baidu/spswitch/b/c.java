package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int bLJ = 0;
    private static int bLK = 0;
    private static int bLL = 0;
    private static int bLM = 0;
    private static int bLN = 0;

    public static int aX(Context context) {
        if (bLJ == 0) {
            bLJ = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return bLJ;
    }

    public static int aY(Context context) {
        if (bLK == 0) {
            bLK = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return bLK;
    }
}
