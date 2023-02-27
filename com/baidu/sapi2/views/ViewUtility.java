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
import android.widget.Button;
import android.widget.TextView;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.Log;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.R;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class ViewUtility implements NoProguard {

    /* loaded from: classes2.dex */
    public class a implements View.OnTouchListener {
        public final /* synthetic */ float a;

        public a(float f) {
            this.a = f;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if ((action == 1 || action == 3) && Build.VERSION.SDK_INT >= 11) {
                    view2.setAlpha(1.0f);
                    return false;
                }
                return false;
            } else if (Build.VERSION.SDK_INT >= 11) {
                view2.setAlpha(this.a);
                return false;
            } else {
                return false;
            }
        }
    }

    public static boolean a(Activity activity, boolean z) {
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
                i = i3 | i2;
            } else {
                i = (~i2) & i3;
            }
            declaredField2.setInt(attributes, i);
            activity.getWindow().setAttributes(attributes);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Activity activity, boolean z) {
        int i;
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        window.getDecorView().setSystemUiVisibility(8192);
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Window window2 = activity.getWindow();
            Object[] objArr = new Object[2];
            if (z) {
                i = i2;
            } else {
                i = 0;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(i2);
            method.invoke(window2, objArr);
            return true;
        } catch (Throwable unused) {
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

    public static void enlargedOtherView(View view2, int i) {
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.width = (int) ((layoutParams.width * i) / 100.0f);
            layoutParams.height = (int) ((layoutParams.height * i) / 100.0f);
            view2.setLayoutParams(layoutParams);
        }
    }

    public static void enlargedTextView(TextView textView, int i) {
        if (textView != null) {
            textView.setTextSize(0, (textView.getTextSize() * i) / 100.0f);
        }
    }

    public static void enlargedViews(View view2, int i) {
        if (view2 == null) {
            return;
        }
        if (view2 instanceof Button) {
            enlargedTextView((TextView) view2, i);
        } else if (view2 instanceof TextView) {
            enlargedTextView((TextView) view2, i);
        } else {
            enlargedOtherView(view2, i);
        }
    }

    public static void setOnClickListener(View view2, View.OnClickListener onClickListener) {
        if (view2 != null && onClickListener != null) {
            view2.setOnClickListener(onClickListener);
        }
    }

    public static void setRootViewFitsSystemWindows(Activity activity, boolean z) {
        ViewGroup viewGroup;
        if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup viewGroup2 = (ViewGroup) activity.findViewById(16908290);
            if (viewGroup2.getChildCount() > 0 && (viewGroup = (ViewGroup) viewGroup2.getChildAt(0)) != null) {
                viewGroup.setFitsSystemWindows(z);
            }
        }
    }

    public static void setViewClickAlpha(View view2, float f) {
        if (view2 == null) {
            return;
        }
        view2.setOnTouchListener(new a(f));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[Catch: Exception -> 0x007b, TryCatch #0 {Exception -> 0x007b, blocks: (B:5:0x0007, B:15:0x002b, B:17:0x0032, B:18:0x003b, B:19:0x003f, B:21:0x0045, B:22:0x0048, B:25:0x005f, B:26:0x0069), top: B:31:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b A[Catch: Exception -> 0x007b, TryCatch #0 {Exception -> 0x007b, blocks: (B:5:0x0007, B:15:0x002b, B:17:0x0032, B:18:0x003b, B:19:0x003f, B:21:0x0045, B:22:0x0048, B:25:0x005f, B:26:0x0069), top: B:31:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0045 A[Catch: Exception -> 0x007b, TryCatch #0 {Exception -> 0x007b, blocks: (B:5:0x0007, B:15:0x002b, B:17:0x0032, B:18:0x003b, B:19:0x003f, B:21:0x0045, B:22:0x0048, B:25:0x005f, B:26:0x0069), top: B:31:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
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
                        i = activity.getResources().getColor(R.color.sapi_sdk_dark_mode_title_color);
                    } else {
                        i = activity.getColor(R.color.sapi_sdk_dark_mode_title_color);
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
        } catch (Exception e) {
            Log.e(e);
        }
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void newLoginStatusBarTint(Activity activity) {
        if (!b(activity, true)) {
            a(activity, true);
        }
        setTranslucentStatus(activity);
        setRootViewFitsSystemWindows(activity, false);
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

    public static void setTranslucentStatus(Activity activity) {
        int i;
        boolean z;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            Window window = activity.getWindow();
            View decorView = window.getDecorView();
            if (Build.VERSION.SDK_INT >= 23) {
                boolean z2 = SapiAccountManager.getInstance().getConfignation().isNightMode;
                boolean z3 = SapiAccountManager.getInstance().getConfignation().isDarkMode;
                if (!z2 && !z3) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    i = 9472;
                    decorView.setSystemUiVisibility(i);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(0);
                }
            }
            i = 1280;
            decorView.setSystemUiVisibility(i);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } else if (i2 >= 19) {
            Window window2 = activity.getWindow();
            WindowManager.LayoutParams attributes = window2.getAttributes();
            attributes.flags |= CodedInputStream.DEFAULT_SIZE_LIMIT;
            window2.setAttributes(attributes);
        }
    }
}
