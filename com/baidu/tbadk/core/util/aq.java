package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class aq {
    private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    private static Method mSetStatusBarColorIcon;
    private static Method mSetStatusBarDarkIcon;
    private static Field mStatusBarColorFiled;

    static {
        SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = 0;
        try {
            mSetStatusBarColorIcon = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException e) {
        }
        try {
            mSetStatusBarDarkIcon = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException e2) {
        }
        try {
            mStatusBarColorFiled = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e3) {
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (IllegalAccessException e4) {
        } catch (NoSuchFieldException e5) {
        }
    }

    private static boolean changeMeizuFlag(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        int i;
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField2.setAccessible(true);
            int i3 = declaredField2.getInt(layoutParams);
            if (z) {
                i = i2 | i3;
            } else {
                i = (i2 ^ (-1)) & i3;
            }
            if (i3 != i) {
                declaredField2.setInt(layoutParams, i);
                return true;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private static void setStatusBarDarkIcon(View view, boolean z) {
        int i;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z) {
            i = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility;
        } else {
            i = (SYSTEM_UI_FLAG_LIGHT_STATUS_BAR ^ (-1)) & systemUiVisibility;
        }
        if (i != systemUiVisibility) {
            view.setSystemUiVisibility(i);
        }
    }

    private static void setStatusBarColor(Window window, int i) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (mStatusBarColorFiled != null) {
            try {
                if (mStatusBarColorFiled.getInt(attributes) != i) {
                    mStatusBarColorFiled.set(attributes, Integer.valueOf(i));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setStatusBarDarkIcon(Window window, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            changeMeizuFlag(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z);
            return;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            setStatusBarDarkIcon(decorView, z);
            setStatusBarColor(window, 0);
        }
    }
}
