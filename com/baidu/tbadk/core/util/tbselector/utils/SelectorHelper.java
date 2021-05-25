package com.baidu.tbadk.core.util.tbselector.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import d.a.n0.e3.c;
/* loaded from: classes3.dex */
public class SelectorHelper {
    public static int dip2px(float f2) {
        return (int) ((f2 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getColor(@ColorRes int i2) {
        return SkinManager.getColor(i2);
    }

    public static Drawable getColorDrawable(@ColorRes int i2) {
        return new ColorDrawable(getColor(i2));
    }

    public static Context getContext() {
        return TbadkCoreApplication.getInst();
    }

    public static int getDimens(@DimenRes int i2) {
        return getResources().getDimensionPixelSize(i2);
    }

    public static Drawable getDrawable(@DrawableRes int i2) {
        return SkinManager.getDrawable(i2);
    }

    public static Resources getResources() {
        return getContext().getResources();
    }

    public static boolean isColorInvalid(int i2) {
        return i2 == Integer.MAX_VALUE;
    }

    public static int parseColor(String str) {
        if (str != null) {
            if (str.length() != 0) {
                try {
                    if (!str.startsWith("#")) {
                        str = "#" + str;
                    }
                } catch (Exception unused) {
                    return Integer.MAX_VALUE;
                }
            }
            return Color.parseColor(str);
        }
        return Integer.MAX_VALUE;
    }

    public static int getColor(@ColorRes int i2, float f2) {
        return c.a(SkinManager.getColor(i2), f2);
    }

    public static Drawable getColorDrawable(@ColorRes int i2, float f2) {
        return new ColorDrawable(getColor(i2, f2));
    }

    public static Drawable getColorDrawable(String str) {
        return new ColorDrawable(parseColor(str));
    }
}
