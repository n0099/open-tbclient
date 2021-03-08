package com.baidu.sapi2.views;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.j.a.a;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class ViewUtility implements NoProguard {

    /* loaded from: classes3.dex */
    static class a implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f3482a;

        a(float f) {
            this.f3482a = f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (Build.VERSION.SDK_INT >= 11) {
                    view.setAlpha(this.f3482a);
                    return false;
                }
                return false;
            } else if (action != 1) {
                if (action == 3 && Build.VERSION.SDK_INT >= 11) {
                    view.setAlpha(1.0f);
                    return false;
                }
                return false;
            } else if (Build.VERSION.SDK_INT >= 11) {
                view.setAlpha(1.0f);
                return false;
            } else {
                return false;
            }
        }
    }

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
        int i2;
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                boolean z = SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode;
                if (!z) {
                    i2 = i;
                } else if (Build.VERSION.SDK_INT < 23) {
                    i2 = activity.getResources().getColor(a.b.sapi_sdk_dark_mode_title_color);
                } else {
                    i2 = activity.getColor(a.b.sapi_sdk_dark_mode_title_color);
                }
                if (!b(activity, true)) {
                    a(activity, true);
                }
                Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.clearFlags(67108864);
                window.setStatusBarColor(i2);
                if (Build.VERSION.SDK_INT >= 23) {
                    if (!z) {
                        window.getDecorView().setSystemUiVisibility(9216);
                    } else {
                        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & (-8193));
                    }
                }
            } catch (Exception e) {
                Log.e(e);
            }
        }
    }

    public static void setOnClickListener(View view, View.OnClickListener onClickListener) {
        if (view == null || onClickListener == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void setViewClickAlpha(View view, float f) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new a(f));
    }
}
