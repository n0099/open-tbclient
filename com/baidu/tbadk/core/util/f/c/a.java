package com.baidu.tbadk.core.util.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.tbadkCore.c;
/* loaded from: classes.dex */
public class a {
    public static int getColor(@ColorRes int i) {
        return am.getColor(i);
    }

    public static int h(@ColorRes int i, float f) {
        return c.n(am.getColor(i), f);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return am.getDrawable(i);
    }

    public static int cy(String str) {
        if (str == null || str.length() == 0) {
            return Integer.MAX_VALUE;
        }
        try {
            if (!str.startsWith("#")) {
                str = "#" + str;
            }
            return Color.parseColor(str);
        } catch (Exception e) {
            return Integer.MAX_VALUE;
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
