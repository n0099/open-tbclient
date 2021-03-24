package com.baidu.apollon.statusbar;

import android.app.Activity;
import android.os.Build;
import android.view.View;
/* loaded from: classes2.dex */
public class ImmersiveStatusBarManager {
    public static void setMiuiFlymeBarDark(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT < 27) {
            if (ImmersiveOSUtils.isMIUI6Plus()) {
                StatusBarUtils.setMIUIStatusBarDarkFont(activity.getWindow(), z);
            } else if (ImmersiveOSUtils.isFlymeOS4Plus()) {
                FlymeStatusBarFontUtils.setStatusBarDarkIcon(activity, z);
            }
        }
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        activity.getWindow().getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
    }

    public static void setTopBar(Activity activity, View view, boolean z) {
        if (ImmersiveOSUtils.isSupportStatusBarDarkFont() && !ImmersiveOSUtils.isSpecialOS()) {
            view.setBackgroundColor(StatusBarUtils.blendARGB(0, -16777216, 0.0f));
            setMiuiFlymeBarDark(activity, z);
            return;
        }
        view.setBackgroundColor(StatusBarUtils.blendARGB(0, -16777216, StatusBarUtils.sBarAlpha));
    }
}
