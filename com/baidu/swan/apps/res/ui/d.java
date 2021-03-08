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
    private static String dzg;
    private final a dzh;
    private boolean dzi;
    private boolean dzj;
    private boolean dzk;
    private View dzl;
    private View dzm;

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                dzg = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable th) {
                dzg = null;
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
                this.dzi = obtainStyledAttributes.getBoolean(0, false);
                this.dzj = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.dzi = true;
                }
                if ((attributes.flags & 134217728) != 0) {
                    this.dzj = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.dzh = new a(activity, this.dzi, this.dzj);
        if (!this.dzh.hasNavigtionBar()) {
            this.dzj = false;
        }
        if (this.dzi) {
            d(activity, viewGroup);
        }
        if (this.dzj) {
            e(activity, viewGroup);
        }
    }

    public void setStatusBarTintEnabled(boolean z) {
        this.dzk = z;
        if (this.dzi) {
            this.dzl.setVisibility(z ? 0 : 8);
        }
    }

    private void d(Context context, ViewGroup viewGroup) {
        this.dzl = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.dzh.getStatusBarHeight());
        layoutParams.gravity = 48;
        if (this.dzj && !this.dzh.isNavigationAtBottom()) {
            layoutParams.rightMargin = this.dzh.getNavigationBarWidth();
        }
        this.dzl.setLayoutParams(layoutParams);
        this.dzl.setBackgroundColor(-1728053248);
        this.dzl.setVisibility(8);
        viewGroup.addView(this.dzl);
    }

    private void e(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        this.dzm = new View(context);
        if (this.dzh.isNavigationAtBottom()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.dzh.getNavigationBarHeight());
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.dzh.getNavigationBarWidth(), -1);
            layoutParams.gravity = 5;
        }
        this.dzm.setLayoutParams(layoutParams);
        this.dzm.setBackgroundColor(-1728053248);
        this.dzm.setVisibility(8);
        viewGroup.addView(this.dzm);
    }

    /* loaded from: classes8.dex */
    public static class a {
        private final int adt;
        private final boolean dzn;
        private final boolean dzo;
        private final boolean dzp;
        private final int dzq;
        private final boolean dzr;
        private final float dzs;
        private final int mActionBarHeight;
        private final int mStatusBarHeight;

        private a(Activity activity, boolean z, boolean z2) {
            Resources resources = activity.getResources();
            this.dzr = resources.getConfiguration().orientation == 1;
            this.dzs = D(activity);
            this.mStatusBarHeight = b(resources, "status_bar_height");
            this.mActionBarHeight = de(activity);
            this.adt = getNavigationBarHeight(activity);
            this.dzq = df(activity);
            this.dzp = this.adt > 0;
            this.dzn = z;
            this.dzo = z2;
        }

        @TargetApi(14)
        private int de(Context context) {
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
            if (this.dzr) {
                str = "navigation_bar_height";
            } else {
                str = "navigation_bar_height_landscape";
            }
            return b(resources, str);
        }

        public int getNavigationBarHeight() {
            return this.adt;
        }

        @TargetApi(14)
        private int df(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !hasNavBar(context)) {
                return 0;
            }
            return b(resources, "navigation_bar_width");
        }

        public int getNavigationBarWidth() {
            return this.dzq;
        }

        @TargetApi(14)
        private boolean hasNavBar(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", HttpConstants.OS_TYPE_VALUE);
            if (identifier != 0) {
                boolean z = resources.getBoolean(identifier);
                if ("1".equals(d.dzg)) {
                    return false;
                }
                if ("0".equals(d.dzg)) {
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
            return this.dzs >= 600.0f || this.dzr;
        }

        public int getStatusBarHeight() {
            return this.mStatusBarHeight;
        }

        public boolean hasNavigtionBar() {
            return this.dzp;
        }
    }
}
