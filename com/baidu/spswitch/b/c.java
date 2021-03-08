package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int cDh = 0;
    private static int cDi = 0;
    private static int cDj = 0;
    private static int cDk = 0;
    private static int cDl = 0;

    public static int bT(Context context) {
        if (cDh == 0) {
            cDh = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return cDh;
    }

    public static int bU(Context context) {
        if (cDi == 0) {
            cDi = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return cDi;
    }
}
