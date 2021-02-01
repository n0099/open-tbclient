package com.baidu.tbadk.core.util.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.tbadkCore.c;
/* loaded from: classes.dex */
public class a {
    public static int getColor(@ColorRes int i) {
        return ap.getColor(i);
    }

    public static int f(@ColorRes int i, float f) {
        return c.l(ap.getColor(i), f);
    }

    public static Drawable getDrawable(@DrawableRes int i) {
        return ap.getDrawable(i);
    }

    public static int rM(String str) {
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
