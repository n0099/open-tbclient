package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes6.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int cze = 0;
    private static int czf = 0;
    private static int czg = 0;
    private static int czh = 0;
    private static int czi = 0;

    public static int bN(Context context) {
        if (cze == 0) {
            cze = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return cze;
    }

    public static int bO(Context context) {
        if (czf == 0) {
            czf = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return czf;
    }
}
