package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes6.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int csi = 0;
    private static int csj = 0;
    private static int csk = 0;
    private static int csl = 0;
    private static int csm = 0;

    public static int bh(Context context) {
        if (csi == 0) {
            csi = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return csi;
    }

    public static int bi(Context context) {
        if (csj == 0) {
            csj = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return csj;
    }
}
