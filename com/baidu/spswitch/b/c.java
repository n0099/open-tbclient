package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int bRj = 0;
    private static int bRk = 0;
    private static int bRl = 0;
    private static int bRm = 0;
    private static int bRn = 0;

    public static int bc(Context context) {
        if (bRj == 0) {
            bRj = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return bRj;
    }

    public static int bd(Context context) {
        if (bRk == 0) {
            bRk = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return bRk;
    }
}
