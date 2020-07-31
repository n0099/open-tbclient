package com.baidu.live.adp.lib.util;

import android.content.Context;
import android.text.ClipboardManager;
import com.baidu.live.adp.base.BdBaseApplication;
/* loaded from: classes4.dex */
public class AndroidUtils {
    public static int getStatusBarHeight(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getNavigationBarHeight(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getNavigationBarLandscapeHeight(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("navigation_bar_height_landscape", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void copyToClipboard(String str) {
        if (str == null) {
            str = "";
        }
        try {
            ((ClipboardManager) BdBaseApplication.getInst().getApp().getSystemService("clipboard")).setText(str);
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
