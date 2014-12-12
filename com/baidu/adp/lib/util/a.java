package com.baidu.adp.lib.util;

import android.content.Context;
import android.text.ClipboardManager;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class a {
    public static int I(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int J(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
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
