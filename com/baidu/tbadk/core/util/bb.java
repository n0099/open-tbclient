package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes.dex */
public class bb {
    public static Rect getVisibilityRegion(Activity activity) {
        Rect rect = new Rect();
        View decorView = activity.getWindow().getDecorView();
        int windowVisibility = decorView.getWindowVisibility();
        decorView.getWindowVisibleDisplayFrame(rect);
        if (windowVisibility != 8) {
            rect.top = 0;
        }
        int statusBarHeight = com.baidu.adp.lib.util.l.getStatusBarHeight(activity);
        int dip2px = MenuKeyUtils.hasSmartBar() ? com.baidu.adp.lib.util.l.dip2px(activity, 48.0f) : 0;
        int i = UtilHelper.canUseStyleImmersiveSticky() ? 0 : statusBarHeight;
        rect.bottom -= dip2px;
        rect.top += i;
        return rect;
    }

    public static int[] getScreenFullSize(Activity activity) {
        View findViewById;
        int[] iArr = {activity.getWindow().getDecorView().getWidth(), activity.getWindow().getDecorView().getHeight()};
        if (Build.VERSION.SDK_INT > 21 && (findViewById = activity.getWindow().getDecorView().findViewById(16908336)) != null && findViewById.getVisibility() == 0) {
            if (iArr[0] > iArr[1]) {
                iArr[0] = iArr[0] - findViewById.getWidth();
            } else {
                iArr[1] = iArr[1] - findViewById.getHeight();
            }
        }
        int[] screenDimensions = com.baidu.adp.lib.util.l.getScreenDimensions(activity);
        if (iArr[0] == 0 || iArr[1] == 0) {
            iArr[0] = screenDimensions[0];
            iArr[1] = screenDimensions[1];
        }
        return iArr;
    }
}
