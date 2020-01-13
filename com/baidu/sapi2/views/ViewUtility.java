package com.baidu.sapi2.views;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.i.a.a;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class ViewUtility implements com.baidu.sapi2.c {
    private static boolean a(Activity activity, boolean z) {
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i | i2 : (i ^ (-1)) & i2);
            activity.getWindow().setAttributes(attributes);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean b(Activity activity, boolean z) {
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

    public static void dismissDialog(Activity activity, Dialog dialog) {
        if (activity != null) {
            if (dialog != null && !activity.isFinishing() && dialog.isShowing()) {
                try {
                    dialog.dismiss();
                    return;
                } catch (Exception e) {
                    Log.e(e);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("Activity must not be null");
    }

    public static void enableStatusBarTint(Activity activity, int i) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                boolean z2 = SapiAccountManager.getInstance().getConfignation().isNightMode;
                boolean z3 = SapiAccountManager.getInstance().getConfignation().isDarkMode;
                if (!z2 && !z3) {
                    z = false;
                }
                if (z) {
                    if (Build.VERSION.SDK_INT < 23) {
                        i = activity.getResources().getColor(a.b.sapi_sdk_dark_mode_title_color);
                    } else {
                        i = activity.getColor(a.b.sapi_sdk_dark_mode_title_color);
                    }
                }
                if (!b(activity, true)) {
                    a(activity, true);
                }
                Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.clearFlags(67108864);
                window.setStatusBarColor(i);
                if (Build.VERSION.SDK_INT >= 23) {
                    if (!z) {
                        window.getDecorView().setSystemUiVisibility(9216);
                        return;
                    }
                    window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & (-8193));
                }
            } catch (Exception e) {
                Log.e(e);
            }
        }
    }

    public static void setViewClickAlpha(View view, float f) {
        view.setOnTouchListener(new s(f));
    }
}
