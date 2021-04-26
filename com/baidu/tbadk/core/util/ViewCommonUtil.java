package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import com.compatible.menukey.MenuKeyUtils;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class ViewCommonUtil {
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
        int[] p = l.p(activity);
        if (iArr[0] == 0 || iArr[1] == 0) {
            iArr[0] = p[0];
            iArr[1] = p[1];
        }
        return iArr;
    }

    public static Rect getVisibilityRegion(Activity activity) {
        Rect rect = new Rect();
        View decorView = activity.getWindow().getDecorView();
        int windowVisibility = decorView.getWindowVisibility();
        decorView.getWindowVisibleDisplayFrame(rect);
        if (windowVisibility != 8) {
            rect.top = 0;
        }
        int r = l.r(activity);
        int e2 = MenuKeyUtils.hasSmartBar() ? l.e(activity, 48.0f) : 0;
        int i2 = UtilHelper.canUseStyleImmersiveSticky() ? 0 : r;
        rect.bottom -= e2;
        rect.top += i2;
        return rect;
    }
}
