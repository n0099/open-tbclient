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
import java.lang.reflect.Method;
/* loaded from: classes11.dex */
public class SapiSystemBarTintManager {

    /* renamed from: a  reason: collision with root package name */
    private static final int f2713a = -1728053248;
    private static String b;
    private final SystemBarConfig c;
    private boolean d;
    private boolean e;
    private View f;
    private View g;

    /* loaded from: classes11.dex */
    public static class SystemBarConfig {

        /* renamed from: a  reason: collision with root package name */
        private static final String f2714a = "status_bar_height";
        private static final String b = "navigation_bar_height";
        private static final String c = "navigation_bar_height_landscape";
        private static final String d = "navigation_bar_width";
        private static final String e = "config_showNavigationBar";
        private final int f;
        private final boolean g;
        private final int h;
        private final int i;
        private final boolean j;
        private final float k;

        @TargetApi(14)
        private int a(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !c(context)) {
                return 0;
            }
            return a(resources, this.j ? b : c);
        }

        @TargetApi(14)
        private int b(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !c(context)) {
                return 0;
            }
            return a(resources, d);
        }

        @TargetApi(14)
        private boolean c(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(e, "bool", "android");
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(SapiSystemBarTintManager.b)) {
                    return false;
                }
                if ("0".equals(SapiSystemBarTintManager.b)) {
                    return true;
                }
                return z;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }

        public int getNavigationBarHeight() {
            return this.h;
        }

        public int getNavigationBarWidth() {
            return this.i;
        }

        public int getStatusBarHeight() {
            return this.f;
        }

        public boolean hasNavigtionBar() {
            return this.g;
        }

        public boolean isNavigationAtBottom() {
            return this.k >= 600.0f || this.j;
        }

        private SystemBarConfig(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.j = resources.getConfiguration().orientation == 1;
            this.k = a(activity);
            this.f = a(resources, f2714a);
            this.h = a((Context) activity);
            this.i = b(activity);
            this.g = this.h > 0;
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
            float f = displayMetrics.density;
            return Math.min(displayMetrics.widthPixels / f, displayMetrics.heightPixels / f);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                Object[] objArr = new Object[1];
                objArr[0] = "qemu.hw.mainkeys";
                b = (String) declaredMethod.invoke(null, objArr);
            } catch (Throwable th) {
                b = null;
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
                this.d = obtainStyledAttributes.getBoolean(0, false);
                this.e = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((attributes.flags & 67108864) != 0) {
                    this.d = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.e = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.c = new SystemBarConfig(activity, this.d, this.e);
        if (!this.c.hasNavigtionBar()) {
            this.e = false;
        }
        if (this.d) {
            b(activity, viewGroup);
        }
        if (this.e) {
            a(activity, viewGroup);
        }
    }

    private void b(Context context, ViewGroup viewGroup) {
        this.f = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.c.getStatusBarHeight());
        layoutParams.gravity = 48;
        if (this.e && !this.c.isNavigationAtBottom()) {
            layoutParams.rightMargin = this.c.getNavigationBarWidth();
        }
        this.f.setLayoutParams(layoutParams);
        this.f.setBackgroundColor(-1728053248);
        this.f.setVisibility(8);
        viewGroup.addView(this.f);
    }

    public SystemBarConfig getConfig() {
        return this.c;
    }

    public void setNavigationBarTintColor(int i) {
        if (this.e) {
            this.g.setBackgroundColor(i);
        }
    }

    public void setNavigationBarTintEnabled(boolean z) {
        if (this.e) {
            this.g.setVisibility(z ? 0 : 8);
        }
    }

    public void setStatusBarTintColor(int i) {
        if (this.d) {
            this.f.setBackgroundColor(i);
        }
    }

    public void setStatusBarTintEnabled(boolean z) {
        if (this.d) {
            this.f.setVisibility(z ? 0 : 8);
        }
    }

    private void a(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.g = new View(context);
        if (this.c.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.c.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.c.getNavigationBarWidth(), -1);
            layoutParams.gravity = 5;
        }
        this.g.setLayoutParams(layoutParams);
        this.g.setBackgroundColor(-1728053248);
        this.g.setVisibility(8);
        viewGroup.addView(this.g);
    }
}
