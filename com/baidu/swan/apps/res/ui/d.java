package com.baidu.swan.apps.res.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.ar.constants.HttpConstants;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class d {
    private static String dvy;
    private boolean dvA;
    private boolean dvB;
    private boolean dvC;
    private View dvD;
    private View dvE;
    private final a dvz;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                dvy = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable th) {
                dvy = null;
            }
        }
    }

    @TargetApi(19)
    public d(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
            try {
                this.dvA = obtainStyledAttributes.getBoolean(0, false);
                this.dvB = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.dvA = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.dvB = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.dvz = new a(activity, this.dvA, this.dvB);
        if (!this.dvz.hasNavigtionBar()) {
            this.dvB = false;
        }
        if (this.dvA) {
            d(activity, viewGroup);
        }
        if (this.dvB) {
            e(activity, viewGroup);
        }
    }

    public void setStatusBarTintEnabled(boolean z) {
        this.dvC = z;
        if (this.dvA) {
            this.dvD.setVisibility(z ? 0 : 8);
        }
    }

    private void d(Context context, ViewGroup viewGroup) {
        this.dvD = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.dvz.getStatusBarHeight());
        layoutParams.gravity = 48;
        if (this.dvB && !this.dvz.isNavigationAtBottom()) {
            layoutParams.rightMargin = this.dvz.getNavigationBarWidth();
        }
        this.dvD.setLayoutParams(layoutParams);
        this.dvD.setBackgroundColor(-1728053248);
        this.dvD.setVisibility(8);
        viewGroup.addView(this.dvD);
    }

    private void e(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.dvE = new View(context);
        if (this.dvz.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.dvz.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.dvz.getNavigationBarWidth(), -1);
            layoutParams.gravity = 5;
        }
        this.dvE.setLayoutParams(layoutParams);
        this.dvE.setBackgroundColor(-1728053248);
        this.dvE.setVisibility(8);
        viewGroup.addView(this.dvE);
    }

    /* loaded from: classes8.dex */
    public static class a {
        private final int acb;
        private final boolean dvF;
        private final boolean dvG;
        private final boolean dvH;
        private final int dvI;
        private final boolean dvJ;
        private final float dvK;
        private final int mActionBarHeight;
        private final int mStatusBarHeight;

        private a(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.dvJ = resources.getConfiguration().orientation == 1;
            this.dvK = J(activity);
            this.mStatusBarHeight = b(resources, "status_bar_height");
            this.mActionBarHeight = dg(activity);
            this.acb = getNavigationBarHeight(activity);
            this.dvI = dh(activity);
            this.dvH = this.acb > 0;
            this.dvF = z;
            this.dvG = z2;
        }

        @TargetApi(14)
        private int dg(Context context) {
            if (Build.VERSION.SDK_INT < 14) {
                return 0;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843499, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }

        @TargetApi(14)
        private int getNavigationBarHeight(Context context) {
            String str;
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !hasNavBar(context)) {
                return 0;
            }
            if (this.dvJ) {
                str = "navigation_bar_height";
            } else {
                str = "navigation_bar_height_landscape";
            }
            return b(resources, str);
        }

        public int getNavigationBarHeight() {
            return this.acb;
        }

        @TargetApi(14)
        private int dh(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !hasNavBar(context)) {
                return 0;
            }
            return b(resources, "navigation_bar_width");
        }

        public int getNavigationBarWidth() {
            return this.dvI;
        }

        @TargetApi(14)
        private boolean hasNavBar(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", HttpConstants.OS_TYPE_VALUE);
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(d.dvy)) {
                    return false;
                }
                if ("0".equals(d.dvy)) {
                    return true;
                }
                return z;
            }
            return ViewConfiguration.get(context).hasPermanentMenuKey() ? false : true;
        }

        private int b(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", HttpConstants.OS_TYPE_VALUE);
            if (identifier <= 0) {
                return 0;
            }
            return resources.getDimensionPixelSize(identifier);
        }

        @SuppressLint({"NewApi"})
        private float J(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 16) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            return Math.min(displayMetrics.widthPixels / displayMetrics.density, displayMetrics.heightPixels / displayMetrics.density);
        }

        public boolean isNavigationAtBottom() {
            return this.dvK >= 600.0f || this.dvJ;
        }

        public int getStatusBarHeight() {
            return this.mStatusBarHeight;
        }

        public boolean hasNavigtionBar() {
            return this.dvH;
        }
    }
}
