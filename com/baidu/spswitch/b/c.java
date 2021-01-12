package com.baidu.spswitch.b;

import android.content.Context;
import com.baidu.spswitch.b;
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = b.isDebug();
    private static int czl = 0;
    private static int czm = 0;
    private static int czn = 0;
    private static int czo = 0;
    private static int czp = 0;

    public static int bV(Context context) {
        if (czl == 0) {
            czl = context.getResources().getDimensionPixelSize(b.a.min_softinput_height);
        }
        return czl;
    }

    public static int bW(Context context) {
        if (czm == 0) {
            czm = context.getResources().getDimensionPixelSize(b.a.max_softinput_height);
        }
        return czm;
    }
}
