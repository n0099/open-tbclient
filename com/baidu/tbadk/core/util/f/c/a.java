package com.baidu.tbadk.core.util.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.tbadkCore.c;
/* loaded from: classes.dex */
public class a {
    public static int getColor(@ColorRes int i) {
        return ao.getColor(i);
    }

    public static int f(@ColorRes int i, float f) {
        return c.m(ao.getColor(i), f);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return ao.getDrawable(i);
    }

    public static int sF(String str) {
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
