package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int bRf = 0;
    private static int bRg = 0;
    private static int bRh = 0;
    private static int bRi = 0;
    private static int bRj = 0;

    public static int bc(Context context) {
        if (bRf == 0) {
            bRf = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return bRf;
    }

    public static int bd(Context context) {
        if (bRg == 0) {
            bRg = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return bRg;
    }
}
