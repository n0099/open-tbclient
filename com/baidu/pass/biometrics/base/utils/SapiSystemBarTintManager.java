package com.baidu.pass.biometrics.base.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class SapiSystemBarTintManager {

    /* renamed from: f  reason: collision with root package name */
    public static final int f8988f = -1728053248;

    /* renamed from: g  reason: collision with root package name */
    public static String f8989g;

    /* renamed from: a  reason: collision with root package name */
    public final SystemBarConfig f8990a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f8991b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8992c;

    /* renamed from: d  reason: collision with root package name */
    public View f8993d;

    /* renamed from: e  reason: collision with root package name */
    public View f8994e;

    /* loaded from: classes2.dex */
    public static class SystemBarConfig {

        /* renamed from: g  reason: collision with root package name */
        public static final String f8995g = "status_bar_height";

        /* renamed from: h  reason: collision with root package name */
        public static final String f8996h = "navigation_bar_height";

        /* renamed from: i  reason: collision with root package name */
        public static final String f8997i = "navigation_bar_height_landscape";
        public static final String j = "navigation_bar_width";
        public static final String k = "config_showNavigationBar";

        /* renamed from: a  reason: collision with root package name */
        public final int f8998a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f8999b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9000c;

        /* renamed from: d  reason: collision with root package name */
        public final int f9001d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f9002e;

        /* renamed from: f  reason: collision with root package name */
        public final float f9003f;

        @TargetApi(14)
        private int a(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !c(context)) {
                return 0;
            }
            return a(resources, this.f9002e ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }

        @TargetApi(14)
        private int b(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !c(context)) {
                return 0;
            }
            return a(resources, "navigation_bar_width");
        }

        @TargetApi(14)
        private boolean c(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(SapiSystemBarTintManager.f8989g)) {
                    return false;
                }
                if ("0".equals(SapiSystemBarTintManager.f8989g)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }

        public int getNavigationBarHeight() {
            return this.f9000c;
        }

        public int getNavigationBarWidth() {
            return this.f9001d;
        }

        public int getStatusBarHeight() {
            return this.f8998a;
        }

        public boolean hasNavigtionBar() {
            return this.f8999b;
        }

        public boolean isNavigationAtBottom() {
            return this.f9003f >= 600.0f || this.f9002e;
        }

        public SystemBarConfig(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.f9002e = resources.getConfiguration().orientation == 1;
            this.f9003f = a(activity);
            this.f8998a = a(resources, "status_bar_height");
            this.f9000c = a((Context) activity);
            this.f9001d = b(activity);
            this.f8999b = this.f9000c > 0;
        }

        private int a(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        @SuppressLint({"NewApi"})
        private float a(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 16) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            float f2 = displayMetrics.density;
            return Math.min(displayMetrics.widthPixels / f2, displayMetrics.heightPixels / f2);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                f8989g = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                f8989g = null;
            }
        }
    }

    @TargetApi(19)
    public SapiSystemBarTintManager(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
            try {
                this.f8991b = obtainStyledAttributes.getBoolean(0, false);
                this.f8992c = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((attributes.flags & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0) {
                    this.f8991b = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.f8992c = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        SystemBarConfig systemBarConfig = new SystemBarConfig(activity, this.f8991b, this.f8992c);
        this.f8990a = systemBarConfig;
        if (!systemBarConfig.hasNavigtionBar()) {
            this.f8992c = false;
        }
        if (this.f8991b) {
            b(activity, viewGroup);
        }
        if (this.f8992c) {
            a(activity, viewGroup);
        }
    }

    private void b(Context context, ViewGroup viewGroup) {
        this.f8993d = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f8990a.getStatusBarHeight());
        layoutParams.gravity = 48;
        if (this.f8992c && !this.f8990a.isNavigationAtBottom()) {
            layoutParams.rightMargin = this.f8990a.getNavigationBarWidth();
        }
        this.f8993d.setLayoutParams(layoutParams);
        this.f8993d.setBackgroundColor(-1728053248);
        this.f8993d.setVisibility(8);
        viewGroup.addView(this.f8993d);
    }

    public SystemBarConfig getConfig() {
        return this.f8990a;
    }

    public void setNavigationBarTintColor(int i2) {
        if (this.f8992c) {
            this.f8994e.setBackgroundColor(i2);
        }
    }

    public void setNavigationBarTintEnabled(boolean z) {
        if (this.f8992c) {
            this.f8994e.setVisibility(z ? 0 : 8);
        }
    }

    public void setStatusBarTintColor(int i2) {
        if (this.f8991b) {
            this.f8993d.setBackgroundColor(i2);
        }
    }

    public void setStatusBarTintEnabled(boolean z) {
        if (this.f8991b) {
            this.f8993d.setVisibility(z ? 0 : 8);
        }
    }

    private void a(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.f8994e = new View(context);
        if (this.f8990a.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f8990a.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f8990a.getNavigationBarWidth(), -1);
            layoutParams.gravity = 5;
        }
        this.f8994e.setLayoutParams(layoutParams);
        this.f8994e.setBackgroundColor(-1728053248);
        this.f8994e.setVisibility(8);
        viewGroup.addView(this.f8994e);
    }
}
