package com.baidu.adp.lib.util;

import android.content.Context;
import android.text.ClipboardManager;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* loaded from: classes.dex */
public class a {
    public static int x(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", SocialConstants.ANDROID_CLIENT_TYPE)) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int y(Context context) {
        int identifier;
        if (context != null && (identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", SocialConstants.ANDROID_CLIENT_TYPE)) > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void aD(String str) {
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
