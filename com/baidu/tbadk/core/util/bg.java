package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import com.compatible.menukey.MenuKeyUtils;
/* loaded from: classes.dex */
public class bg {
    public static Rect s(Activity activity) {
        Rect rect = new Rect();
        View decorView = activity.getWindow().getDecorView();
        int windowVisibility = decorView.getWindowVisibility();
        decorView.getWindowVisibleDisplayFrame(rect);
        if (windowVisibility != 8) {
            rect.top = 0;
        }
        int n = com.baidu.adp.lib.util.k.n(activity);
        int dip2px = MenuKeyUtils.hasSmartBar() ? com.baidu.adp.lib.util.k.dip2px(activity, 48.0f) : 0;
        int i = UtilHelper.canUseStyleImmersiveSticky() ? 0 : n;
        rect.bottom -= dip2px;
        rect.top += i;
        return rect;
    }
}
