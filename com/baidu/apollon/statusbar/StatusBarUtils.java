package com.baidu.apollon.statusbar;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class StatusBarUtils {
    public static final int STATUS_BAR_DEFAULT_HEIGHT = 25;
    public static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
    public static int mStatusBarHeight = 0;
    public static float sBarAlpha = 0.3f;

    public static int blendARGB(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i2) * f3) + (Color.alpha(i3) * f2)), (int) ((Color.red(i2) * f3) + (Color.red(i3) * f2)), (int) ((Color.green(i2) * f3) + (Color.green(i3) * f2)), (int) ((Color.blue(i2) * f3) + (Color.blue(i3) * f2)));
    }

    public static int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getInternalDimensionSize(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        return dimensionPixelSize > 0 ? dimensionPixelSize : dip2px(context, 25.0f);
    }

    public static int getStatusBarHeight(Context context) {
        if (mStatusBarHeight == 0) {
            mStatusBarHeight = getInternalDimensionSize(context);
        }
        return mStatusBarHeight;
    }

    public static void setMIUIStatusBarDarkFont(Window window, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                if (z) {
                    method.invoke(window, Integer.valueOf(i2), Integer.valueOf(i2));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i2));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void setTitleBar(final Context context, final View view) {
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int i2 = layoutParams.height;
            if (i2 != -2 && i2 != -1) {
                layoutParams.height = i2 + getStatusBarHeight(context);
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + getStatusBarHeight(context), view.getPaddingRight(), view.getPaddingBottom());
                view.setLayoutParams(layoutParams);
                return;
            }
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.apollon.statusbar.StatusBarUtils.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT >= 19) {
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        layoutParams.height = view.getHeight() + StatusBarUtils.getStatusBarHeight(context);
                        View view2 = view;
                        view2.setPadding(view2.getPaddingLeft(), view.getPaddingTop() + StatusBarUtils.getStatusBarHeight(context), view.getPaddingRight(), view.getPaddingBottom());
                        view.setLayoutParams(layoutParams);
                    }
                }
            });
        }
    }
}
