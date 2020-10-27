package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes19.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int cnW = 0;
    private static int cnX = 0;
    private static int cnY = 0;
    private static int cnZ = 0;
    private static int coa = 0;

    public static int bh(Context context) {
        if (cnW == 0) {
            cnW = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return cnW;
    }

    public static int bi(Context context) {
        if (cnX == 0) {
            cnX = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return cnX;
    }
}
