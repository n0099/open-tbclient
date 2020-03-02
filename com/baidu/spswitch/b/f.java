package com.baidu.spswitch.b;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
/* loaded from: classes13.dex */
public class f {
    private static boolean bau = false;
    private static int bav = 0;
    private static final boolean DEBUG = b.isDebug();

    public static synchronized int getStatusBarHeight(Context context) {
        int i;
        synchronized (f.class) {
            if (!bau) {
                int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", PraiseDataPassUtil.KEY_FROM_OS);
                if (identifier > 0) {
                    bav = context.getResources().getDimensionPixelSize(identifier);
                    bau = true;
                }
                if (DEBUG) {
                    Log.d("StatusBarUtil", "status bar util: " + bav);
                }
            }
            i = bav;
        }
        return i;
    }

    public static float g(Context context, float f) {
        return (context.getResources().getDisplayMetrics().densityDpi / 160.0f) * f;
    }
}
