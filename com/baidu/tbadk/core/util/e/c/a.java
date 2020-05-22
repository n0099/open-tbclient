package com.baidu.tbadk.core.util.e.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.tbadkCore.c;
/* loaded from: classes.dex */
public class a {
    public static int getColor(@ColorRes int i) {
        return am.getColor(i);
    }

    public static int f(@ColorRes int i, float f) {
        return c.l(am.getColor(i), f);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return am.getDrawable(i);
    }

    public static int dT(String str) {
        if (str == null || str.length() == 0) {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        try {
            if (!str.startsWith("#")) {
                str = "#" + str;
            }
            return Color.parseColor(str);
        } catch (Exception e) {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public static int dip2px(float f) {
        return (int) ((getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static Resources getResources() {
        return getContext().getResources();
    }

    public static Context getContext() {
        return TbadkCoreApplication.getInst();
    }
}
