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
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.google.protobuf.CodedInputStream;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class SapiSystemBarTintManager {
    public static final int f = -1728053248;
    public static String g;
    public final SystemBarConfig a;
    public boolean b;
    public boolean c;
    public View d;
    public View e;

    /* loaded from: classes2.dex */
    public static class SystemBarConfig {
        public static final String g = "status_bar_height";
        public static final String h = "navigation_bar_height";
        public static final String i = "navigation_bar_height_landscape";
        public static final String j = "navigation_bar_width";
        public static final String k = "config_showNavigationBar";
        public final int a;
        public final boolean b;
        public final int c;
        public final int d;
        public final boolean e;
        public final float f;

        public SystemBarConfig(Activity activity, boolean z, boolean z2) {
            boolean z3;
            Resources resources = activity.getResources();
            if (resources.getConfiguration().orientation == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.e = z3;
            this.f = a(activity);
            this.a = a(resources, g);
            this.c = a((Context) activity);
            this.d = b(activity);
            this.b = this.c > 0;
        }

        @SuppressLint({"NewApi"})
        private float a(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 16) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            float f = displayMetrics.density;
            return Math.min(displayMetrics.widthPixels / f, displayMetrics.heightPixels / f);
        }

        @TargetApi(14)
        private int b(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT >= 14 && c(context)) {
                return a(resources, j);
            }
            return 0;
        }

        @TargetApi(14)
        private int a(Context context) {
            String str;
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT >= 14 && c(context)) {
                if (this.e) {
                    str = h;
                } else {
                    str = i;
                }
                return a(resources, str);
            }
            return 0;
        }

        private int a(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, EMABTest.TYPE_DIMEN, "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        @TargetApi(14)
        private boolean c(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(k, "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(SapiSystemBarTintManager.g)) {
                    return false;
                }
                if ("0".equals(SapiSystemBarTintManager.g)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }

        public int getNavigationBarHeight() {
            return this.c;
        }

        public int getNavigationBarWidth() {
            return this.d;
        }

        public int getStatusBarHeight() {
            return this.a;
        }

        public boolean hasNavigtionBar() {
            return this.b;
        }

        public boolean isNavigationAtBottom() {
            if (this.f < 600.0f && !this.e) {
                return false;
            }
            return true;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                g = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                g = null;
            }
        }
    }

    public SystemBarConfig getConfig() {
        return this.a;
    }

    @TargetApi(19)
    public SapiSystemBarTintManager(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
            try {
                this.b = obtainStyledAttributes.getBoolean(0, false);
                this.c = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((attributes.flags & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0) {
                    this.b = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.c = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        SystemBarConfig systemBarConfig = new SystemBarConfig(activity, this.b, this.c);
        this.a = systemBarConfig;
        if (!systemBarConfig.hasNavigtionBar()) {
            this.c = false;
        }
        if (this.b) {
            b(activity, viewGroup);
        }
        if (this.c) {
            a(activity, viewGroup);
        }
    }

    private void a(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.e = new View(context);
        if (this.a.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.a.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.a.getNavigationBarWidth(), -1);
            layoutParams.gravity = 5;
        }
        this.e.setLayoutParams(layoutParams);
        this.e.setBackgroundColor(-1728053248);
        this.e.setVisibility(8);
        viewGroup.addView(this.e);
    }

    private void b(Context context, ViewGroup viewGroup) {
        this.d = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.a.getStatusBarHeight());
        layoutParams.gravity = 48;
        if (this.c && !this.a.isNavigationAtBottom()) {
            layoutParams.rightMargin = this.a.getNavigationBarWidth();
        }
        this.d.setLayoutParams(layoutParams);
        this.d.setBackgroundColor(-1728053248);
        this.d.setVisibility(8);
        viewGroup.addView(this.d);
    }

    public void setNavigationBarTintColor(int i) {
        if (this.c) {
            this.e.setBackgroundColor(i);
        }
    }

    public void setNavigationBarTintEnabled(boolean z) {
        int i;
        if (this.c) {
            View view2 = this.e;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public void setStatusBarTintColor(int i) {
        if (this.b) {
            this.d.setBackgroundColor(i);
        }
    }

    public void setStatusBarTintEnabled(boolean z) {
        int i;
        if (this.b) {
            View view2 = this.d;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }
}
