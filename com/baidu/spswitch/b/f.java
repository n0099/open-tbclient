package com.baidu.spswitch.b;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
/* loaded from: classes13.dex */
public class f {
    private static boolean bav = false;
    private static int baw = 0;
    private static final boolean DEBUG = b.isDebug();

    public static synchronized int getStatusBarHeight(Context context) {
        int i;
        synchronized (f.class) {
            if (!bav) {
                int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", PraiseDataPassUtil.KEY_FROM_OS);
                if (identifier > 0) {
                    baw = context.getResources().getDimensionPixelSize(identifier);
                    bav = true;
                }
                if (DEBUG) {
                    Log.d("StatusBarUtil", "status bar util: " + baw);
                }
            }
            i = baw;
        }
        return i;
    }

    public static float g(Context context, float f) {
        return (context.getResources().getDisplayMetrics().densityDpi / 160.0f) * f;
    }
}
