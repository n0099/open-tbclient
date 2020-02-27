package com.baidu.spswitch.b;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
/* loaded from: classes13.dex */
public class f {
    private static boolean bat = false;
    private static int bau = 0;
    private static final boolean DEBUG = b.isDebug();

    public static synchronized int getStatusBarHeight(Context context) {
        int i;
        synchronized (f.class) {
            if (!bat) {
                int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", PraiseDataPassUtil.KEY_FROM_OS);
                if (identifier > 0) {
                    bau = context.getResources().getDimensionPixelSize(identifier);
                    bat = true;
                }
                if (DEBUG) {
                    Log.d("StatusBarUtil", "status bar util: " + bau);
                }
            }
            i = bau;
        }
        return i;
    }

    public static float g(Context context, float f) {
        return (context.getResources().getDisplayMetrics().densityDpi / 160.0f) * f;
    }
}
