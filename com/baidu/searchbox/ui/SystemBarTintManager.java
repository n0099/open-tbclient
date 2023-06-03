package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.privateapi.PrivateApiUtils;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes4.dex */
public abstract class SystemBarTintManager {
    public static final int FLAG_TRANSLUCENT_NAVIGATION = 134217728;
    public static final int FLAG_TRANSLUCENT_STATUS = 67108864;
    public static final int windowTranslucentNavigation = 16843760;
    public static final int windowTranslucentStatus = 16843759;

    public abstract void setStatusBarTintColor(int i);

    public abstract void setStatusBarTintEnabled(boolean z);

    /* loaded from: classes4.dex */
    public static class SystemBarTintManagerKitKat extends SystemBarTintManager {
        public static final int DEFAULT_TINT_COLOR = -1728053248;
        public static String sNavBarOverride;
        public final SystemBarConfig mConfig;
        public boolean mNavBarAvailable;
        public boolean mNavBarTintEnabled;
        public View mNavBarTintView;
        public boolean mStatusBarAvailable;
        public boolean mStatusBarTintEnabled;
        public View mStatusBarTintView;

        /* loaded from: classes4.dex */
        public static class SystemBarConfig {
            public static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
            public static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
            public static final String NAV_BAR_WIDTH_RES_NAME = "navigation_bar_width";
            public static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
            public static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
            public final int mActionBarHeight;
            public final boolean mHasNavigationBar;
            public final boolean mInPortrait;
            public final int mNavigationBarHeight;
            public final int mNavigationBarWidth;
            public final float mSmallestWidthDp;
            public final int mStatusBarHeight;
            public final boolean mTranslucentNavBar;
            public final boolean mTranslucentStatusBar;

            public SystemBarConfig(Activity activity, boolean z, boolean z2) {
                boolean z3;
                Resources resources = activity.getResources();
                if (resources.getConfiguration().orientation == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.mInPortrait = z3;
                this.mSmallestWidthDp = getSmallestWidthDp(activity);
                this.mStatusBarHeight = getInternalDimensionSize(resources, "status_bar_height");
                this.mActionBarHeight = getActionBarHeight(activity);
                this.mNavigationBarHeight = getNavigationBarHeight(activity);
                this.mNavigationBarWidth = getNavigationBarWidth(activity);
                this.mHasNavigationBar = this.mNavigationBarHeight > 0;
                this.mTranslucentStatusBar = z;
                this.mTranslucentNavBar = z2;
            }

            @SuppressLint({"ObsoleteSdkInt"})
            @TargetApi(14)
            private int getActionBarHeight(Context context) {
                if (Build.VERSION.SDK_INT >= 14) {
                    TypedValue typedValue = new TypedValue();
                    context.getTheme().resolveAttribute(16843499, typedValue, true);
                    return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
                }
                return 0;
            }

            @SuppressLint({"ObsoleteSdkInt"})
            @TargetApi(14)
            private int getNavigationBarHeight(Context context) {
                String str;
                Resources resources = context.getResources();
                if (Build.VERSION.SDK_INT >= 14 && hasNavBar(context)) {
                    if (this.mInPortrait) {
                        str = "navigation_bar_height";
                    } else {
                        str = "navigation_bar_height_landscape";
                    }
                    return getInternalDimensionSize(resources, str);
                }
                return 0;
            }

            @SuppressLint({"ObsoleteSdkInt"})
            @TargetApi(14)
            private int getNavigationBarWidth(Context context) {
                Resources resources = context.getResources();
                if (Build.VERSION.SDK_INT >= 14 && hasNavBar(context)) {
                    return getInternalDimensionSize(resources, "navigation_bar_width");
                }
                return 0;
            }

            @SuppressLint({"NewApi", "ObsoleteSdkInt"})
            private float getSmallestWidthDp(Activity activity) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (Build.VERSION.SDK_INT >= 16) {
                    activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                } else {
                    activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                }
                float f = displayMetrics.density;
                return Math.min(displayMetrics.widthPixels / f, displayMetrics.heightPixels / f);
            }

            public int getPixelInsetTop(boolean z) {
                int i;
                int i2 = 0;
                if (this.mTranslucentStatusBar) {
                    i = this.mStatusBarHeight;
                } else {
                    i = 0;
                }
                if (z) {
                    i2 = this.mActionBarHeight;
                }
                return i + i2;
            }

            private int getInternalDimensionSize(Resources resources, String str) {
                int identifier = resources.getIdentifier(str, EMABTest.TYPE_DIMEN, "android");
                if (identifier > 0) {
                    return resources.getDimensionPixelSize(identifier);
                }
                return 0;
            }

            @TargetApi(14)
            private boolean hasNavBar(Context context) {
                Resources resources = context.getResources();
                int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
                if (identifier != 0) {
                    boolean z = resources.getBoolean(identifier);
                    if ("1".equals(SystemBarTintManagerKitKat.sNavBarOverride)) {
                        return false;
                    }
                    if ("0".equals(SystemBarTintManagerKitKat.sNavBarOverride)) {
                        return true;
                    }
                    return z;
                }
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }

            public int getActionBarHeight() {
                return this.mActionBarHeight;
            }

            public int getNavigationBarHeight() {
                return this.mNavigationBarHeight;
            }

            public int getNavigationBarWidth() {
                return this.mNavigationBarWidth;
            }

            public int getPixelInsetBottom() {
                if (this.mTranslucentNavBar && isNavigationAtBottom()) {
                    return this.mNavigationBarHeight;
                }
                return 0;
            }

            public int getPixelInsetRight() {
                if (this.mTranslucentNavBar && !isNavigationAtBottom()) {
                    return this.mNavigationBarWidth;
                }
                return 0;
            }

            public int getStatusBarHeight() {
                return this.mStatusBarHeight;
            }

            public boolean hasNavigtionBar() {
                return this.mHasNavigationBar;
            }

            public boolean isNavigationAtBottom() {
                if (this.mSmallestWidthDp < 600.0f && !this.mInPortrait) {
                    return false;
                }
                return true;
            }
        }

        static {
            if (DeviceUtil.OSInfo.hasKitKat()) {
                try {
                    sNavBarOverride = PrivateApiUtils.getSystemProtertiesMethod("qemu.hw.mainkeys");
                } catch (Exception unused) {
                    sNavBarOverride = null;
                }
            }
        }

        public SystemBarConfig getConfig() {
            return this.mConfig;
        }

        public boolean isNavBarTintEnabled() {
            return this.mNavBarTintEnabled;
        }

        public boolean isStatusBarTintEnabled() {
            return this.mStatusBarTintEnabled;
        }

        @SuppressLint({"ResourceType"})
        @TargetApi(19)
        public SystemBarTintManagerKitKat(Activity activity) {
            Window window = activity.getWindow();
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            if (DeviceUtil.OSInfo.hasKitKat()) {
                TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{SystemBarTintManager.windowTranslucentStatus, SystemBarTintManager.windowTranslucentNavigation});
                try {
                    this.mStatusBarAvailable = obtainStyledAttributes.getBoolean(0, false);
                    this.mNavBarAvailable = obtainStyledAttributes.getBoolean(1, false);
                    obtainStyledAttributes.recycle();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    if ((67108864 & attributes.flags) != 0) {
                        this.mStatusBarAvailable = true;
                    }
                    if ((attributes.flags & SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION) != 0) {
                        this.mNavBarAvailable = true;
                    }
                } catch (Throwable th) {
                    obtainStyledAttributes.recycle();
                    throw th;
                }
            }
            SystemBarConfig systemBarConfig = new SystemBarConfig(activity, this.mStatusBarAvailable, this.mNavBarAvailable);
            this.mConfig = systemBarConfig;
            if (!systemBarConfig.hasNavigtionBar()) {
                this.mNavBarAvailable = false;
            }
            if (this.mStatusBarAvailable) {
                setupStatusBarView(activity, viewGroup);
            }
            if (this.mNavBarAvailable) {
                setupNavBarView(activity, viewGroup);
            }
        }

        @SuppressLint({"RtlHardcoded"})
        private void setupNavBarView(Context context, ViewGroup viewGroup) {
            FrameLayout.LayoutParams layoutParams;
            this.mNavBarTintView = new View(context);
            if (this.mConfig.isNavigationAtBottom()) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.mConfig.getNavigationBarHeight());
                layoutParams.gravity = 80;
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.mConfig.getNavigationBarWidth(), -1);
                layoutParams.gravity = 5;
            }
            this.mNavBarTintView.setLayoutParams(layoutParams);
            this.mNavBarTintView.setBackgroundColor(-1728053248);
            this.mNavBarTintView.setVisibility(8);
            viewGroup.addView(this.mNavBarTintView);
        }

        private void setupStatusBarView(Context context, ViewGroup viewGroup) {
            this.mStatusBarTintView = new View(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.mConfig.getStatusBarHeight());
            layoutParams.gravity = 48;
            if (this.mNavBarAvailable && !this.mConfig.isNavigationAtBottom()) {
                layoutParams.rightMargin = this.mConfig.getNavigationBarWidth();
            }
            this.mStatusBarTintView.setLayoutParams(layoutParams);
            this.mStatusBarTintView.setBackgroundColor(-1728053248);
            this.mStatusBarTintView.setVisibility(8);
            viewGroup.addView(this.mStatusBarTintView);
        }

        @SuppressLint({"ObsoleteSdkInt"})
        @TargetApi(11)
        public void setNavigationBarAlpha(float f) {
            if (this.mNavBarAvailable && Build.VERSION.SDK_INT >= 11) {
                this.mNavBarTintView.setAlpha(f);
            }
        }

        public void setNavigationBarTintColor(int i) {
            if (this.mNavBarAvailable) {
                this.mNavBarTintView.setBackgroundColor(i);
            }
        }

        public void setNavigationBarTintDrawable(Drawable drawable) {
            if (this.mNavBarAvailable) {
                this.mNavBarTintView.setBackgroundDrawable(drawable);
            }
        }

        public void setNavigationBarTintEnabled(boolean z) {
            int i;
            this.mNavBarTintEnabled = z;
            if (this.mNavBarAvailable) {
                View view2 = this.mNavBarTintView;
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                view2.setVisibility(i);
            }
        }

        public void setNavigationBarTintResource(int i) {
            if (this.mNavBarAvailable) {
                this.mNavBarTintView.setBackgroundResource(i);
            }
        }

        @SuppressLint({"ObsoleteSdkInt"})
        @TargetApi(11)
        public void setStatusBarAlpha(float f) {
            if (this.mStatusBarAvailable && Build.VERSION.SDK_INT >= 11) {
                this.mStatusBarTintView.setAlpha(f);
            }
        }

        @Override // com.baidu.searchbox.ui.SystemBarTintManager
        public void setStatusBarTintColor(int i) {
            if (this.mStatusBarAvailable) {
                this.mStatusBarTintView.setBackgroundColor(i);
            }
        }

        public void setStatusBarTintDrawable(Drawable drawable) {
            if (this.mStatusBarAvailable) {
                this.mStatusBarTintView.setBackgroundDrawable(drawable);
            }
        }

        @Override // com.baidu.searchbox.ui.SystemBarTintManager
        public void setStatusBarTintEnabled(boolean z) {
            int i;
            this.mStatusBarTintEnabled = z;
            if (this.mStatusBarAvailable) {
                View view2 = this.mStatusBarTintView;
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                view2.setVisibility(i);
            }
        }

        public void setStatusBarTintResource(int i) {
            if (this.mStatusBarAvailable) {
                this.mStatusBarTintView.setBackgroundResource(i);
            }
        }

        public void setTintAlpha(float f) {
            setStatusBarAlpha(f);
            setNavigationBarAlpha(f);
        }

        public void setTintColor(int i) {
            setStatusBarTintColor(i);
            setNavigationBarTintColor(i);
        }

        public void setTintDrawable(Drawable drawable) {
            setStatusBarTintDrawable(drawable);
            setNavigationBarTintDrawable(drawable);
        }

        public void setTintResource(int i) {
            setStatusBarTintResource(i);
            setNavigationBarTintResource(i);
        }
    }

    /* loaded from: classes4.dex */
    public static class SystemBarTintManagerLollipop extends SystemBarTintManager {
        public Activity mActivity;
        public boolean mStatusBarTintEnabled;

        public SystemBarTintManagerLollipop(Activity activity) {
            this.mActivity = activity;
        }

        @Override // com.baidu.searchbox.ui.SystemBarTintManager
        public void setStatusBarTintEnabled(boolean z) {
            this.mStatusBarTintEnabled = z;
        }

        @Override // com.baidu.searchbox.ui.SystemBarTintManager
        public void setStatusBarTintColor(int i) {
            if (!this.mStatusBarTintEnabled) {
                return;
            }
            Activity activity = this.mActivity;
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            try {
                Window.class.getDeclaredMethod("setStatusBarColor", Integer.TYPE).invoke(activity.getWindow(), Integer.valueOf(i));
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
        }
    }

    public static SystemBarTintManager newInstance(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new SystemBarTintManagerLollipop(activity);
        }
        setTranslucentStatus(activity, true);
        SystemBarTintManagerKitKat systemBarTintManagerKitKat = new SystemBarTintManagerKitKat(activity);
        systemBarTintManagerKitKat.setStatusBarTintEnabled(true);
        return systemBarTintManagerKitKat;
    }

    public static void setTranslucentStatus(Activity activity, boolean z) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.flags |= 67108864;
        } else {
            attributes.flags &= -67108865;
        }
        window.setAttributes(attributes);
    }
}
