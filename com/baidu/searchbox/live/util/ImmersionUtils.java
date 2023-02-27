package com.baidu.searchbox.live.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.baidu.live.arch.utils.RomUtils;
import com.baidu.live.arch.utils.StatusBarUtils;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class ImmersionUtils {
    public static final int STANDARD_STATUSBAR_HEIGHT = 50;
    public static boolean canUseImmersion = false;
    public static boolean isMeiZuCanUseImmersive = true;
    public static boolean isMeiZuCanUseImmersiveHaveSet;
    public static DisplayMetrics sDisplayMetrics;

    public static boolean canUseImmersion() {
        return canUseImmersion;
    }

    public static Context getApplication() {
        AppInfoService appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        if (appInfoService != null) {
            return appInfoService.getApplication();
        }
        return null;
    }

    public static void changeStatusBarIconAndTextColor(boolean z, Activity activity) {
        int i;
        if (activity != null && activity.getWindow() != null) {
            if (Build.VERSION.SDK_INT < 23) {
                StatusBarUtils.from(activity).setTransparentStatusbar(true).setLightStatusBar(!z).process();
                return;
            }
            View decorView = activity.getWindow().getDecorView();
            if (decorView != null) {
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (z) {
                    i = systemUiVisibility & (-8193);
                } else {
                    if (RomUtils.isMIUIRom()) {
                        Window window = activity.getWindow();
                        window.addFlags(Integer.MIN_VALUE);
                        window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                    }
                    i = systemUiVisibility | 8192;
                }
                decorView.setSystemUiVisibility(i);
            }
        }
    }

    public static void setupNavigationBarStyleImmersiveSticky(Activity activity, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19 && activity != null) {
            if (i >= 23) {
                useNavigationBarStyleImmersiveStickyM(activity, z);
                StatusBarUtils.from(activity).setTransparentStatusbar(true).setLightStatusBar(true).process();
                canUseImmersion = true;
                return;
            } else if (!StatusBarUtils.from(activity).setTransparentStatusbar(true).setLightStatusBar(true).process()) {
                canUseImmersion = false;
                return;
            } else if (Build.VERSION.SDK_INT < 21) {
                useNavigationBarStyleImmersiveStickyKitKat(activity);
                canUseImmersion = true;
                return;
            } else {
                useNavigationBarStyleImmersiveStickyL(activity);
                fixFullScreen4Notch(activity, true);
                canUseImmersion = true;
                return;
            }
        }
        canUseImmersion = false;
    }

    public static int dp2px(float f) {
        return (int) ((f * getApplication().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float getDensity(@Nullable Context context) {
        initDisplayMetrics(getApplication());
        DisplayMetrics displayMetrics = sDisplayMetrics;
        if (displayMetrics != null) {
            return displayMetrics.density;
        }
        return 0.0f;
    }

    public static void initDisplayMetrics(Context context) {
        Context application = getApplication();
        if (sDisplayMetrics == null) {
            if (application != null) {
                context = application;
            }
            if (context == null) {
                return;
            }
            sDisplayMetrics = context.getResources().getDisplayMetrics();
        }
    }

    public static void setupNavBarStyleImmersiveStickyWithLightStatusBar(Activity activity) {
        setupNavigationBarStyleImmersiveSticky(activity, false);
        changeStatusBarIconAndTextColor(true, activity);
    }

    public static void useNavigationBarStyleImmersiveStickyKitKat(Activity activity) {
        if (activity == null) {
            return;
        }
        boolean z = false;
        int i = -1;
        try {
            Field field = WindowManager.LayoutParams.class.getField("FLAG_TRANSLUCENT_STATUS");
            if (field != null) {
                i = field.getInt(null);
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z) {
            activity.getWindow().setFlags(i, i);
        }
    }

    public static void useNavigationBarStyleImmersiveStickyL(Activity activity) {
        useNavigationBarStyleImmersiveStickyL(activity, false, false);
    }

    @SuppressLint({"WrongConstant"})
    public static void fixFullScreen4Notch(Activity activity, boolean z) {
        if (activity != null && Build.VERSION.SDK_INT >= 28) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (z) {
                attributes.layoutInDisplayCutoutMode = 1;
            } else {
                attributes.layoutInDisplayCutoutMode = 0;
            }
            window.setAttributes(attributes);
        }
    }

    public static void useNavigationBarStyleImmersiveStickyM(Activity activity, boolean z) {
        useNavigationBarStyleImmersiveStickyL(activity, z, true);
    }

    public static int getStatusBarHeight() {
        int i;
        Context application = getApplication();
        int i2 = 0;
        if (application == null) {
            return 0;
        }
        try {
            i = application.getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android");
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        if (i > 0) {
            try {
                i2 = application.getResources().getDimensionPixelSize(i);
            } catch (Exception unused) {
            }
        }
        if (i2 == 0) {
            return (int) (getDensity(null) * 25.0f);
        }
        return i2;
    }

    public static void useNavigationBarStyleImmersiveStickyL(Activity activity, boolean z, boolean z2) {
        if (activity == null) {
            return;
        }
        useNavigationBarStyleImmersiveStickyL(activity.getWindow(), z, z2);
    }

    public static void useNavigationBarStyleImmersiveStickyL(Window window, boolean z, boolean z2) {
        if (window == null) {
            return;
        }
        try {
            Field field = WindowManager.LayoutParams.class.getField("FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS");
            Field field2 = WindowManager.LayoutParams.class.getField("FLAG_TRANSLUCENT_STATUS");
            Field field3 = View.class.getField("SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN");
            Field field4 = View.class.getField("SYSTEM_UI_FLAG_LAYOUT_STABLE");
            Method method = window.getClass().getMethod("setStatusBarColor", Integer.TYPE);
            Method method2 = View.class.getMethod("setSystemUiVisibility", Integer.TYPE);
            if (field != null && field2 != null && field3 != null && field4 != null && method != null && method2 != null) {
                int i = field.getInt(null);
                int i2 = field2.getInt(null);
                int i3 = field3.getInt(null);
                int i4 = field4.getInt(null);
                window.clearFlags(i2);
                if (z2) {
                    Field field5 = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR");
                    if (field5 != null) {
                        window.getDecorView().setSystemUiVisibility(field5.getInt(null) | i3);
                    }
                } else {
                    method2.invoke(window.getDecorView(), Integer.valueOf(i3 | i4));
                }
                window.addFlags(i);
                method.invoke(window, 0);
                if (z) {
                    Field field6 = WindowManager.LayoutParams.class.getField("FLAG_FULLSCREEN");
                    Method method3 = window.getClass().getMethod("setFlags", Integer.TYPE, Integer.TYPE);
                    int i5 = field6.getInt(null);
                    method3.invoke(window, Integer.valueOf(i5), Integer.valueOf(i5));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
