package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes24.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int bTj = 0;
    private static int bTk = 0;
    private static int bTl = 0;
    private static int bTm = 0;
    private static int bTn = 0;

    public static int bb(Context context) {
        if (bTj == 0) {
            bTj = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return bTj;
    }

    public static int bc(Context context) {
        if (bTk == 0) {
            bTk = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return bTk;
    }
}
