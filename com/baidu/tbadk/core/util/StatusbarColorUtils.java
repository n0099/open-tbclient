package com.baidu.tbadk.core.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class StatusbarColorUtils {
    public static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    public static Method mSetStatusBarColorIcon;
    public static Method mSetStatusBarDarkIcon;
    public static Field mStatusBarColorFiled;

    static {
        try {
            mSetStatusBarColorIcon = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException unused) {
        }
        try {
            mSetStatusBarDarkIcon = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
        }
        try {
            mStatusBarColorFiled = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException unused3) {
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException unused4) {
        }
    }

    public static boolean changeMeizuFlag(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField2.setAccessible(true);
            int i2 = declaredField2.getInt(layoutParams);
            int i3 = z ? i | i2 : (i ^ (-1)) & i2;
            if (i2 != i3) {
                declaredField2.setInt(layoutParams, i3);
                return true;
            }
            return false;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return false;
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean isBlackColor(int i, int i2) {
        return toGrey(i) < i2;
    }

    public static void setStatusBarColor(Window window, int i) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = mStatusBarColorFiled;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i) {
                    mStatusBarColorFiled.set(attributes, Integer.valueOf(i));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, int i) {
        Method method = mSetStatusBarColorIcon;
        if (method != null) {
            try {
                method.invoke(activity, Integer.valueOf(i));
                return;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return;
            }
        }
        boolean isBlackColor = isBlackColor(i, 50);
        if (mStatusBarColorFiled != null) {
            setStatusBarDarkIcon(activity, isBlackColor, isBlackColor);
            setStatusBarDarkIcon(activity.getWindow(), i);
            return;
        }
        setStatusBarDarkIcon(activity, isBlackColor);
    }

    public static int toGrey(int i) {
        return (((((i & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16) * 38) + (((65280 & i) >> 8) * 75)) + ((i & 255) * 15)) >> 7;
    }

    public static void setStatusBarDarkIcon(Window window, int i) {
        try {
            setStatusBarColor(window, i);
            if (Build.VERSION.SDK_INT > 22) {
                setStatusBarDarkIcon(window.getDecorView(), true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, boolean z) {
        setStatusBarDarkIcon(activity, z, true);
    }

    public static void setStatusBarDarkIcon(View view, boolean z) {
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

    public static void setStatusBarDarkIcon(Activity activity, boolean z, boolean z2) {
        Method method = mSetStatusBarDarkIcon;
        if (method == null) {
            if (z2) {
                setStatusBarDarkIcon(activity.getWindow(), z);
                return;
            }
            return;
        }
        try {
            method.invoke(activity, Boolean.valueOf(z));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }
}
