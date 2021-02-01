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
    private static String dxF;
    private final a dxG;
    private boolean dxH;
    private boolean dxI;
    private boolean dxJ;
    private View dxK;
    private View dxL;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                dxF = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable th) {
                dxF = null;
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
                this.dxH = obtainStyledAttributes.getBoolean(0, false);
                this.dxI = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.dxH = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.dxI = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.dxG = new a(activity, this.dxH, this.dxI);
        if (!this.dxG.hasNavigtionBar()) {
            this.dxI = false;
        }
        if (this.dxH) {
            d(activity, viewGroup);
        }
        if (this.dxI) {
            e(activity, viewGroup);
        }
    }

    public void setStatusBarTintEnabled(boolean z) {
        this.dxJ = z;
        if (this.dxH) {
            this.dxK.setVisibility(z ? 0 : 8);
        }
    }

    private void d(Context context, ViewGroup viewGroup) {
        this.dxK = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.dxG.getStatusBarHeight());
        layoutParams.gravity = 48;
        if (this.dxI && !this.dxG.isNavigationAtBottom()) {
            layoutParams.rightMargin = this.dxG.getNavigationBarWidth();
        }
        this.dxK.setLayoutParams(layoutParams);
        this.dxK.setBackgroundColor(-1728053248);
        this.dxK.setVisibility(8);
        viewGroup.addView(this.dxK);
    }

    private void e(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.dxL = new View(context);
        if (this.dxG.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.dxG.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.dxG.getNavigationBarWidth(), -1);
            layoutParams.gravity = 5;
        }
        this.dxL.setLayoutParams(layoutParams);
        this.dxL.setBackgroundColor(-1728053248);
        this.dxL.setVisibility(8);
        viewGroup.addView(this.dxL);
    }

    /* loaded from: classes9.dex */
    public static class a {
        private final int abW;
        private final boolean dxM;
        private final boolean dxN;
        private final boolean dxO;
        private final int dxP;
        private final boolean dxQ;
        private final float dxR;
        private final int mActionBarHeight;
        private final int mStatusBarHeight;

        private a(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.dxQ = resources.getConfiguration().orientation == 1;
            this.dxR = D(activity);
            this.mStatusBarHeight = b(resources, "status_bar_height");
            this.mActionBarHeight = df(activity);
            this.abW = getNavigationBarHeight(activity);
            this.dxP = dg(activity);
            this.dxO = this.abW > 0;
            this.dxM = z;
            this.dxN = z2;
        }

        @TargetApi(14)
        private int df(Context context) {
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
            if (this.dxQ) {
                str = "navigation_bar_height";
            } else {
                str = "navigation_bar_height_landscape";
            }
            return b(resources, str);
        }

        public int getNavigationBarHeight() {
            return this.abW;
        }

        @TargetApi(14)
        private int dg(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !hasNavBar(context)) {
                return 0;
            }
            return b(resources, "navigation_bar_width");
        }

        public int getNavigationBarWidth() {
            return this.dxP;
        }

        @TargetApi(14)
        private boolean hasNavBar(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", HttpConstants.OS_TYPE_VALUE);
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(d.dxF)) {
                    return false;
                }
                if ("0".equals(d.dxF)) {
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
        private float D(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 16) {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            return Math.min(displayMetrics.widthPixels / displayMetrics.density, displayMetrics.heightPixels / displayMetrics.density);
        }

        public boolean isNavigationAtBottom() {
            return this.dxR >= 600.0f || this.dxQ;
        }

        public int getStatusBarHeight() {
            return this.mStatusBarHeight;
        }

        public boolean hasNavigtionBar() {
            return this.dxO;
        }
    }
}
