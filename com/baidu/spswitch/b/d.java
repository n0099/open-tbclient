package com.baidu.spswitch.b;

import android.content.Context;
/* loaded from: classes19.dex */
public class d {
    private static boolean cob = false;
    private static int coc = 0;
    private static final boolean DEBUG = b.isDebug();

    public static float g(Context context, float f) {
        return (context.getResources().getDisplayMetrics().densityDpi / 160.0f) * f;
    }
}
