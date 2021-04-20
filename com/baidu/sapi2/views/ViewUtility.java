package com.baidu.sapi2.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.Log;
import com.google.protobuf.CodedInputStream;
import d.b.x.a.b;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class ViewUtility implements NoProguard {

    /* loaded from: classes2.dex */
    public static class a implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f11168a;

        public a(float f2) {
            this.f11168a = f2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action == 1 || action == 3) && Build.VERSION.SDK_INT >= 11) {
                    view.setAlpha(1.0f);
                    return false;
                }
                return false;
            } else if (Build.VERSION.SDK_INT >= 11) {
                view.setAlpha(this.f11168a);
                return false;
            } else {
                return false;
            }
        }
    }

    public static boolean a(Activity activity, boolean z) {
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
            activity.getWindow().setAttributes(attributes);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Activity activity, boolean z) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
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
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void dismissDialog(Activity activity, Dialog dialog) {
        if (activity != null) {
            if (dialog == null || activity.isFinishing() || !dialog.isShowing()) {
                return;
            }
            try {
                dialog.dismiss();
                return;
            } catch (Exception e2) {
                Log.e(e2);
                return;
            }
        }
        throw new IllegalArgumentException("Activity must not be null");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002f A[Catch: Exception -> 0x007c, TryCatch #0 {Exception -> 0x007c, blocks: (B:5:0x0007, B:15:0x002b, B:17:0x002f, B:18:0x003a, B:19:0x0040, B:21:0x0046, B:22:0x0049, B:25:0x0060, B:26:0x006a), top: B:31:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a A[Catch: Exception -> 0x007c, TryCatch #0 {Exception -> 0x007c, blocks: (B:5:0x0007, B:15:0x002b, B:17:0x002f, B:18:0x003a, B:19:0x0040, B:21:0x0046, B:22:0x0049, B:25:0x0060, B:26:0x006a), top: B:31:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046 A[Catch: Exception -> 0x007c, TryCatch #0 {Exception -> 0x007c, blocks: (B:5:0x0007, B:15:0x002b, B:17:0x002f, B:18:0x003a, B:19:0x0040, B:21:0x0046, B:22:0x0049, B:25:0x0060, B:26:0x006a), top: B:31:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void enableStatusBarTint(Activity activity, int i) {
        boolean z;
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        try {
            boolean z2 = SapiAccountManager.getInstance().getConfignation().isNightMode;
            boolean z3 = SapiAccountManager.getInstance().getConfignation().isDarkMode;
            if (!z2 && !z3) {
                z = false;
                if (z && -1 == i) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        i = activity.getResources().getColor(b.sapi_sdk_dark_mode_title_color);
                    } else {
                        i = activity.getColor(b.sapi_sdk_dark_mode_title_color);
                    }
                }
                if (!b(activity, true)) {
                    a(activity, true);
                }
                Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                window.setStatusBarColor(i);
                if (Build.VERSION.SDK_INT < 23) {
                    if (!z) {
                        window.getDecorView().setSystemUiVisibility(9216);
                        return;
                    }
                    window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() & (-8193));
                    return;
                }
                return;
            }
            z = true;
            if (z) {
                if (Build.VERSION.SDK_INT >= 23) {
                }
            }
            if (!b(activity, true)) {
            }
            Window window2 = activity.getWindow();
            window2.addFlags(Integer.MIN_VALUE);
            window2.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            window2.setStatusBarColor(i);
            if (Build.VERSION.SDK_INT < 23) {
            }
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void newLoginStatusBarTint(Activity activity) {
        activity.getWindow();
        if (!b(activity, true)) {
            a(activity, true);
        }
        setTranslucentStatus(activity);
        setRootViewFitsSystemWindows(activity, false);
    }

    public static void setOnClickListener(View view, View.OnClickListener onClickListener) {
        if (view == null || onClickListener == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void setOrientationToUndefined(Activity activity) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
            declaredField.setAccessible(false);
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public static void setRootViewFitsSystemWindows(Activity activity, boolean z) {
        ViewGroup viewGroup;
        if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup viewGroup2 = (ViewGroup) activity.findViewById(16908290);
            if (viewGroup2.getChildCount() <= 0 || (viewGroup = (ViewGroup) viewGroup2.getChildAt(0)) == null) {
                return;
            }
            viewGroup.setFitsSystemWindows(z);
        }
    }

    public static void setTranslucentStatus(Activity activity) {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21) {
            if (i2 >= 19) {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= CodedInputStream.DEFAULT_SIZE_LIMIT;
                window.setAttributes(attributes);
                return;
            }
            return;
        }
        Window window2 = activity.getWindow();
        View decorView = window2.getDecorView();
        if (Build.VERSION.SDK_INT >= 23) {
            if (!(SapiAccountManager.getInstance().getConfignation().isNightMode || SapiAccountManager.getInstance().getConfignation().isDarkMode)) {
                i = 9472;
                decorView.setSystemUiVisibility(i);
                window2.addFlags(Integer.MIN_VALUE);
                window2.setStatusBarColor(0);
            }
        }
        i = 1280;
        decorView.setSystemUiVisibility(i);
        window2.addFlags(Integer.MIN_VALUE);
        window2.setStatusBarColor(0);
    }

    public static void setViewClickAlpha(View view, float f2) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new a(f2));
    }
}
