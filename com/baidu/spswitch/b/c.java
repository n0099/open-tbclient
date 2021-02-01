package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int cBH = 0;
    private static int cBI = 0;
    private static int cBJ = 0;
    private static int cBK = 0;
    private static int cBL = 0;

    public static int bU(Context context) {
        if (cBH == 0) {
            cBH = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return cBH;
    }

    public static int bV(Context context) {
        if (cBI == 0) {
            cBI = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return cBI;
    }
}
