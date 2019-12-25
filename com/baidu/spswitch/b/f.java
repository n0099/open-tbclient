package com.baidu.spswitch.b;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
/* loaded from: classes11.dex */
public class f {
    private static boolean aVp = false;
    private static int aVq = 0;
    private static final boolean DEBUG = b.isDebug();

    public static synchronized int getStatusBarHeight(Context context) {
        int i;
        synchronized (f.class) {
            if (!aVp) {
                int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", PraiseDataPassUtil.KEY_FROM_OS);
                if (identifier > 0) {
                    aVq = context.getResources().getDimensionPixelSize(identifier);
                    aVp = true;
                }
                if (DEBUG) {
                    Log.d("StatusBarUtil", "status bar util: " + aVq);
                }
            }
            i = aVq;
        }
        return i;
    }

    public static float g(Context context, float f) {
        return (context.getResources().getDisplayMetrics().densityDpi / 160.0f) * f;
    }
}
