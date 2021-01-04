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
/* loaded from: classes9.dex */
public class d {
    private static String dAk;
    private final a dAl;
    private boolean dAm;
    private boolean dAn;
    private boolean dAo;
    private View dAp;
    private View dAq;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                dAk = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable th) {
                dAk = null;
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
                this.dAm = obtainStyledAttributes.getBoolean(0, false);
                this.dAn = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.dAm = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.dAn = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.dAl = new a(activity, this.dAm, this.dAn);
        if (!this.dAl.hasNavigtionBar()) {
            this.dAn = false;
        }
        if (this.dAm) {
            d(activity, viewGroup);
        }
        if (this.dAn) {
            e(activity, viewGroup);
        }
    }

    public void setStatusBarTintEnabled(boolean z) {
        this.dAo = z;
        if (this.dAm) {
            this.dAp.setVisibility(z ? 0 : 8);
        }
    }

    private void d(Context context, ViewGroup viewGroup) {
        this.dAp = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.dAl.getStatusBarHeight());
        layoutParams.gravity = 48;
        if (this.dAn && !this.dAl.isNavigationAtBottom()) {
            layoutParams.rightMargin = this.dAl.getNavigationBarWidth();
        }
        this.dAp.setLayoutParams(layoutParams);
        this.dAp.setBackgroundColor(-1728053248);
        this.dAp.setVisibility(8);
        viewGroup.addView(this.dAp);
    }

    private void e(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.dAq = new View(context);
        if (this.dAl.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.dAl.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.dAl.getNavigationBarWidth(), -1);
            layoutParams.gravity = 5;
        }
        this.dAq.setLayoutParams(layoutParams);
        this.dAq.setBackgroundColor(-1728053248);
        this.dAq.setVisibility(8);
        viewGroup.addView(this.dAq);
    }

    /* loaded from: classes9.dex */
    public static class a {
        private final int acd;
        private final boolean dAr;
        private final boolean dAs;
        private final boolean dAt;
        private final int dAu;
        private final boolean dAv;
        private final float dAw;
        private final int mActionBarHeight;
        private final int mStatusBarHeight;

        private a(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.dAv = resources.getConfiguration().orientation == 1;
            this.dAw = J(activity);
            this.mStatusBarHeight = b(resources, "status_bar_height");
            this.mActionBarHeight = dh(activity);
            this.acd = getNavigationBarHeight(activity);
            this.dAu = di(activity);
            this.dAt = this.acd > 0;
            this.dAr = z;
            this.dAs = z2;
        }

        @TargetApi(14)
        private int dh(Context context) {
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
            if (this.dAv) {
                str = "navigation_bar_height";
            } else {
                str = "navigation_bar_height_landscape";
            }
            return b(resources, str);
        }

        public int getNavigationBarHeight() {
            return this.acd;
        }

        @TargetApi(14)
        private int di(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !hasNavBar(context)) {
                return 0;
            }
            return b(resources, "navigation_bar_width");
        }

        public int getNavigationBarWidth() {
            return this.dAu;
        }

        @TargetApi(14)
        private boolean hasNavBar(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", HttpConstants.OS_TYPE_VALUE);
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(d.dAk)) {
                    return false;
                }
                if ("0".equals(d.dAk)) {
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
            return this.dAw >= 600.0f || this.dAv;
        }

        public int getStatusBarHeight() {
            return this.mStatusBarHeight;
        }

        public boolean hasNavigtionBar() {
            return this.dAt;
        }
    }
}
