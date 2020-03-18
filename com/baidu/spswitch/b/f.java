package com.baidu.spswitch.b;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
/* loaded from: classes13.dex */
public class f {
    private static boolean baI = false;
    private static int baJ = 0;
    private static final boolean DEBUG = b.isDebug();

    public static synchronized int getStatusBarHeight(Context context) {
        int i;
        synchronized (f.class) {
            if (!baI) {
                int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", PraiseDataPassUtil.KEY_FROM_OS);
                if (identifier > 0) {
                    baJ = context.getResources().getDimensionPixelSize(identifier);
                    baI = true;
                }
                if (DEBUG) {
                    Log.d("StatusBarUtil", "status bar util: " + baJ);
                }
            }
            i = baJ;
        }
        return i;
    }

    public static float g(Context context, float f) {
        return (context.getResources().getDisplayMetrics().densityDpi / 160.0f) * f;
    }
}
