package com.baidu.live.arch.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class StatusBarUtils {
    public View actionBarView;
    public boolean lightStatusBar;
    public boolean transparentStatusBar;
    public Window window;

    /* loaded from: classes3.dex */
    public static final class Builder {
        public View actionBarView;
        public boolean lightStatusBar = false;
        public boolean transparentStatusbar = false;
        public Window window;

        public boolean process() {
            return new StatusBarUtils(this.window, this.lightStatusBar, this.transparentStatusbar, this.actionBarView).process();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setWindow(Activity activity) {
            this.window = activity.getWindow();
            return this;
        }

        public Builder setActionbarView(View view2) {
            this.actionBarView = view2;
            return this;
        }

        public Builder setLightStatusBar(boolean z) {
            this.lightStatusBar = z;
            return this;
        }

        public Builder setTransparentStatusbar(boolean z) {
            this.transparentStatusbar = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setWindow(Dialog dialog) {
            this.window = dialog.getWindow();
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setWindow(Window window) {
            this.window = window;
            return this;
        }
    }

    public StatusBarUtils(Window window, boolean z, boolean z2, View view2) {
        this.lightStatusBar = z;
        this.transparentStatusBar = z2;
        this.window = window;
        this.actionBarView = view2;
    }

    public static Builder from(Activity activity) {
        return new Builder().setWindow(activity);
    }

    public void processActionBar(final View view2) {
        if (view2 != null && this.transparentStatusBar && !isLessKitkat()) {
            view2.post(new Runnable() { // from class: com.baidu.live.arch.utils.StatusBarUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    View view3 = view2;
                    view3.setPadding(view3.getPaddingLeft(), view2.getPaddingTop() + StatusBarUtils.getStatusBarOffsetPx(view2.getContext()), view2.getPaddingRight(), view2.getPaddingBottom());
                    view2.getLayoutParams().height += StatusBarUtils.getStatusBarOffsetPx(view2.getContext());
                }
            });
        }
    }

    public static Builder from(Dialog dialog) {
        return new Builder().setWindow(dialog);
    }

    public static Builder from(Window window) {
        return new Builder().setWindow(window);
    }

    public static int getStatusBarOffsetPx(Context context) {
        AppInfoService appInfoService;
        if (isLessKitkat() || (appInfoService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE())) == null || appInfoService.getApplication() == null) {
            return 0;
        }
        Application application = appInfoService.getApplication();
        try {
            int identifier = application.getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android");
            if (identifier <= 0) {
                return 0;
            }
            return application.getResources().getDimensionPixelSize(identifier);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private boolean processFlyMe(boolean z) {
        WindowManager.LayoutParams attributes = this.window.getAttributes();
        try {
            Class<?> cls = Class.forName("android.view.WindowManager$LayoutParams");
            int i = cls.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON").getInt(attributes);
            Field declaredField = cls.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(attributes);
            if (z) {
                declaredField.set(attributes, Integer.valueOf(i2 | i));
            } else {
                declaredField.set(attributes, Integer.valueOf((~i) & i2));
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean processMIUI(boolean z) {
        int i;
        Class<?> cls = this.window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Window window = this.window;
            Object[] objArr = new Object[2];
            if (z) {
                i = i2;
            } else {
                i = 0;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(i2);
            method.invoke(window, objArr);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isKitkat() {
        if (Build.VERSION.SDK_INT == 19) {
            return true;
        }
        return false;
    }

    public static boolean isLessKitkat() {
        if (Build.VERSION.SDK_INT < 19) {
            return true;
        }
        return false;
    }

    public static boolean isMoreLollipop() {
        if (Build.VERSION.SDK_INT >= 21) {
            return true;
        }
        return false;
    }

    @TargetApi(21)
    private boolean processLollipopAbove() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        int systemUiVisibility = this.window.getDecorView().getSystemUiVisibility();
        if (this.lightStatusBar) {
            systemUiVisibility |= -2147475456;
        }
        if (this.transparentStatusBar) {
            systemUiVisibility |= 1280;
        }
        this.window.getDecorView().setSystemUiVisibility(systemUiVisibility);
        this.window.setStatusBarColor(0);
        return true;
    }

    public boolean process() {
        int i = Build.VERSION.SDK_INT;
        if (!processPrivateAPI() && !processLollipopAbove()) {
            return false;
        }
        if (i == 19) {
            processKitkat();
        }
        processActionBar(this.actionBarView);
        return true;
    }

    @TargetApi(19)
    public void processKitkat() {
        WindowManager.LayoutParams attributes = this.window.getAttributes();
        if (this.transparentStatusBar) {
            attributes.flags |= CodedInputStream.DEFAULT_SIZE_LIMIT;
        } else {
            attributes.flags &= -67108865;
        }
        this.window.setAttributes(attributes);
    }

    public boolean processPrivateAPI() {
        if (!processFlyMe(this.lightStatusBar) && !processMIUI(this.lightStatusBar)) {
            return false;
        }
        return true;
    }

    public static void setStatusBarVisible(Activity activity, boolean z) {
        if (z) {
            activity.getWindow().clearFlags(1024);
        } else {
            activity.getWindow().addFlags(1024);
        }
    }
}
