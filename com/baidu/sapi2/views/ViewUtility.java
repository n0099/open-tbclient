package com.baidu.sapi2.views;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.d.a.a;
import com.baidu.sapi2.base.debug.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class ViewUtility {
    public static void dismissDialog(Activity activity, Dialog dialog) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not be null");
        }
        if (dialog != null && !activity.isFinishing() && dialog.isShowing()) {
            try {
                dialog.dismiss();
            } catch (Exception e) {
                Log.e(e);
            }
        }
    }

    public static void setViewClickAlpha(View view, final float f) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.sapi2.views.ViewUtility.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        if (Build.VERSION.SDK_INT >= 11) {
                            view2.setAlpha(f);
                            return false;
                        }
                        return false;
                    case 1:
                        if (Build.VERSION.SDK_INT >= 11) {
                            view2.setAlpha(1.0f);
                            return false;
                        }
                        return false;
                    case 2:
                    default:
                        return false;
                    case 3:
                        if (Build.VERSION.SDK_INT >= 11) {
                            view2.setAlpha(1.0f);
                            return false;
                        }
                        return false;
                }
            }
        });
    }

    public static void enableStatusBarTint(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            if (i == -1) {
                try {
                    if (Build.VERSION.SDK_INT < 23) {
                        i = activity.getResources().getColor(a.b.sapi_sdk_gray_status_bar);
                    }
                } catch (Exception e) {
                    Log.e(e);
                    return;
                }
            }
            if (!setMIUIStatusBarLightMode(activity, true)) {
                setFlymeStatusBarLightMode(activity, true);
            }
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags |= 67108864;
            window.setAttributes(attributes);
            SystemBarTintManager systemBarTintManager = new SystemBarTintManager(activity);
            systemBarTintManager.setStatusBarTintEnabled(true);
            systemBarTintManager.setStatusBarTintColor(i);
        }
    }

    private static boolean setMIUIStatusBarLightMode(Activity activity, boolean z) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(8192);
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Window window2 = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window2, objArr);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean setFlymeStatusBarLightMode(Activity activity, boolean z) {
        int i;
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i2 = declaredField.getInt(null);
            int i3 = declaredField2.getInt(attributes);
            if (z) {
                i = i2 | i3;
            } else {
                i = (i2 ^ (-1)) & i3;
            }
            declaredField2.setInt(attributes, i);
            activity.getWindow().setAttributes(attributes);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
