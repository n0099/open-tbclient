package com.baidu.searchbox.widget;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.graphics.BitmapCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.widget.graphics.Palette;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes13.dex */
public class ImmersionHelper {
    private static final int DEFAULT_FLAG = 5120;
    public static final int HIDE_NAV_FLAG = 5120;
    public static final int INVALID_COLOR = 1;
    private static final int MEIZU = 2;
    private static final int NORMAL_PHONE = 0;
    public static final String SP_KEY_IMMERSION_SWITCH = "sp_key_immersion_switch";
    public static final int STATUS_BAR_ALPHA_BELOW_M = 45;
    private static final String TAG = "ImmersionHelper";
    private static final String VIEW_TAG = "IMMERSION_VIEW";
    private static final int XIAOMI = 1;
    private static int sRomType;
    private Activity mActivity;
    private ImmersionConfig mDayImmersionConfig;
    private ImmersionConfig mNightImmersionConfig;
    private ViewGroup mRootView;
    private int mStatusBarViewBg;
    private static final boolean DEBUG = ImmersionRuntime.GLOBAL_DEBUG;
    public static final int DEFAULT_POP_DIALOG_COLOR = Color.parseColor("#80000000");
    public static final boolean SUPPORT_IMMERSION = isSupportImmersion();

    static {
        sRomType = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            sRomType = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            sRomType = 2;
        }
    }

    public ImmersionHelper(@NonNull Activity activity) {
        this(activity, (ViewGroup) activity.findViewById(16908290));
    }

    public ImmersionHelper(@NonNull Activity activity, @NonNull ViewGroup viewGroup) {
        this.mStatusBarViewBg = 1;
        this.mActivity = activity;
        this.mRootView = viewGroup;
    }

    public void setImmersion() {
        setImmersion(1);
    }

    public void setImmersion(int i) {
        setImmersion(i, false);
    }

    public void setImmersion(int i, boolean z) {
        ImmersionConfig createConfig;
        if (SUPPORT_IMMERSION) {
            if (i == 1) {
                if (this.mStatusBarViewBg != 1) {
                    reset();
                }
                this.mStatusBarViewBg = i;
                createConfig = getConfig();
            } else {
                this.mStatusBarViewBg = i;
                createConfig = createConfig(i, getStatusBarColor(i), z);
                if (NightModeHelper.getNightModeSwitcherState()) {
                    this.mNightImmersionConfig = createConfig;
                } else {
                    this.mDayImmersionConfig = createConfig;
                }
            }
            setImmersion(createConfig);
        }
    }

    private void setImmersion(@NonNull ImmersionConfig immersionConfig) {
        if (sRomType == 2) {
            setMEIZUStatusBar(immersionConfig);
            return;
        }
        setWindowFlag();
        updateUI(immersionConfig);
    }

    public void reset() {
        this.mDayImmersionConfig = null;
        this.mNightImmersionConfig = null;
        this.mStatusBarViewBg = 1;
    }

    public void resetWithCurImmersion() {
        setImmersion(getConfig());
    }

    public void disable() {
        View childAt = this.mRootView.getChildAt(0);
        if (childAt != null && VIEW_TAG.equals(childAt.getTag())) {
            this.mRootView.removeViewAt(0);
            View childAt2 = this.mRootView.getChildAt(0);
            if (childAt2 != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
                layoutParams.topMargin = 0;
                childAt2.setLayoutParams(layoutParams);
            }
        }
        if (sRomType != 2) {
            Window window = this.mActivity.getWindow();
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(Integer.MIN_VALUE);
            }
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(-5121);
        }
    }

    private void updateUI(ImmersionConfig immersionConfig) {
        int i;
        int i2;
        Window window = this.mActivity.getWindow();
        if (immersionConfig.mIsShowNavBar) {
        }
        if (immersionConfig.mUseLightStatusBar) {
            i = 13312;
        } else {
            i = 5120;
        }
        if (!immersionConfig.mIsShowStatusBar) {
            i2 = i & (-257);
        } else {
            i2 = i | 256;
        }
        int i3 = immersionConfig.mCustomStatusBarViewBg;
        if (i3 == 1) {
            i3 = getDefaultStatusBarViewBg();
        }
        window.getDecorView().setSystemUiVisibility(i2);
        if (Build.VERSION.SDK_INT >= 21) {
            window.setStatusBarColor(immersionConfig.mStatusBarColor);
        }
        View statusBarView = getStatusBarView(immersionConfig);
        if (statusBarView != null) {
            statusBarView.setBackgroundColor(i3);
        }
    }

    private View getStatusBarView(ImmersionConfig immersionConfig) {
        View childAt;
        if (this.mRootView == null || (childAt = this.mRootView.getChildAt(0)) == null) {
            return null;
        }
        if (VIEW_TAG.equals(childAt.getTag())) {
            if (immersionConfig.mIsShowStatusBar) {
                return childAt;
            }
            this.mRootView.removeViewAt(0);
            return null;
        } else if (immersionConfig.mIsShowStatusBar) {
            int statusBarHeight = DeviceUtil.ScreenInfo.getStatusBarHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            childAt.setLayoutParams(layoutParams);
            View view = new View(this.mActivity);
            view.setTag(VIEW_TAG);
            view.setId(com.baidu.searchbox.widget.immersion.R.id.immersion_custom_statusbar_view);
            this.mRootView.addView(view, 0, new ViewGroup.LayoutParams(-1, statusBarHeight));
            return view;
        } else {
            return null;
        }
    }

    @NonNull
    public ImmersionConfig getConfig() {
        if (NightModeHelper.getNightModeSwitcherState()) {
            if (this.mNightImmersionConfig == null) {
                createDefaultNightConfig();
            }
            return this.mNightImmersionConfig;
        }
        if (this.mDayImmersionConfig == null) {
            createDefaultDayConfig();
        }
        return this.mDayImmersionConfig;
    }

    public void setDayConfig(@NonNull ImmersionConfig immersionConfig) {
        this.mDayImmersionConfig = immersionConfig;
    }

    public void setNightConfig(@NonNull ImmersionConfig immersionConfig) {
        this.mNightImmersionConfig = immersionConfig;
    }

    private void createDefaultDayConfig() {
        int defaultStatusBarViewBg = getDefaultStatusBarViewBg();
        this.mDayImmersionConfig = createConfig(defaultStatusBarViewBg, getStatusBarColor(defaultStatusBarViewBg), true);
    }

    private void createDefaultNightConfig() {
        int defaultStatusBarViewBg = getDefaultStatusBarViewBg();
        this.mNightImmersionConfig = createConfig(defaultStatusBarViewBg, getStatusBarColor(defaultStatusBarViewBg), false);
    }

    private ImmersionConfig createConfig(int i, int i2, boolean z) {
        ImmersionConfig.Builder builder = new ImmersionConfig.Builder();
        builder.useLightStatusBar(z).showStatusBar(true).showNavBar(false).setStatusBarColor(i2).setCustomStatusBarViewBg(i);
        return builder.build();
    }

    private boolean shouldUseLightStatusBar(int i) {
        return Build.VERSION.SDK_INT >= 23 && i == getDefaultStatusBarViewBg() && !NightModeHelper.getNightModeSwitcherState();
    }

    private int getDefaultStatusBarViewBg() {
        return Build.VERSION.SDK_INT >= 21 ? this.mActivity.getResources().getColor(com.baidu.searchbox.widget.immersion.R.color.statusbar_immersion_bg) : this.mActivity.getResources().getColor(com.baidu.searchbox.widget.immersion.R.color.statusbar_immersion_bg_below_lollipop);
    }

    private int getStatusBarColor(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return 0;
        }
        return calculateStatusColor(i, 45);
    }

    private void setWindowFlag() {
        Window window = this.mActivity.getWindow();
        if (Build.VERSION.SDK_INT >= 21) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            switch (sRomType) {
                case 1:
                    setMIUISetStatusBarLightMode(window, getConfig().mUseLightStatusBar);
                    return;
                default:
                    return;
            }
        } else if (Build.VERSION.SDK_INT >= 19) {
            window.addFlags(67108864);
        }
    }

    public static int calculateStatusColor(int i, int i2) {
        if (i2 != 0) {
            float f = 1.0f - (i2 / 255.0f);
            return (((int) ((((i >> 16) & 255) * f) + 0.5d)) << 16) | ViewCompat.MEASURED_STATE_MASK | (((int) ((((i >> 8) & 255) * f) + 0.5d)) << 8) | ((int) ((f * (i & 255)) + 0.5d));
        }
        return i;
    }

    private static boolean isSupportImmersion() {
        boolean z = Build.VERSION.SDK_INT >= 21;
        if (DEBUG) {
            return z & PreferenceUtils.getBoolean(SP_KEY_IMMERSION_SWITCH, z);
        }
        return z;
    }

    public static int generatePanelColor(Drawable drawable) {
        if (DEBUG) {
            Log.d(TAG, "start generatePanelColor()");
        }
        Drawable newDrawable = drawable.getConstantState().newDrawable();
        int intrinsicWidth = newDrawable.getIntrinsicWidth();
        int intrinsicHeight = newDrawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, 2, newDrawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        if (DEBUG) {
            Log.d(TAG, "new bit map size: " + BitmapCompat.getAllocationByteCount(createBitmap) + "bytes");
        }
        Canvas canvas = new Canvas(createBitmap);
        newDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        newDrawable.draw(canvas);
        Palette.Swatch swatch = null;
        for (Palette.Swatch swatch2 : Palette.from(createBitmap).clearFilters().clearRegion().clearTargets().generateHeader().getSwatches()) {
            if ((swatch != null && swatch.getPopulation() >= swatch2.getPopulation()) || swatch2.getRgb() == 1) {
                swatch2 = swatch;
            }
            swatch = swatch2;
        }
        int rgb = swatch != null ? swatch.getRgb() : -1;
        if (DEBUG) {
            Log.d(TAG, "end generatePanelColor() color: " + rgb);
        }
        return rgb;
    }

    public static int getStatusBarHideVisibility() {
        return 5380;
    }

    /* loaded from: classes13.dex */
    public static class ImmersionConfig {
        private int mCustomStatusBarViewBg;
        private boolean mIsShowNavBar;
        private boolean mIsShowStatusBar;
        private int mStatusBarColor;
        private boolean mUseLightStatusBar;

        /* loaded from: classes13.dex */
        public static class Builder {
            private int customStatBarViewBg;
            private int statusBarColor;
            private boolean isShowNavBar = true;
            private boolean useLightStatBar = true;
            private boolean isShowStatBar = true;

            public Builder setStatusBarColor(int i) {
                this.statusBarColor = i;
                return this;
            }

            public Builder setCustomStatusBarViewBg(int i) {
                this.customStatBarViewBg = i;
                return this;
            }

            public Builder showNavBar(boolean z) {
                this.isShowNavBar = z;
                return this;
            }

            public Builder showStatusBar(boolean z) {
                this.isShowStatBar = z;
                return this;
            }

            public Builder useLightStatusBar(boolean z) {
                this.useLightStatBar = z;
                return this;
            }

            public ImmersionConfig build() {
                ImmersionConfig immersionConfig = new ImmersionConfig();
                immersionConfig.mCustomStatusBarViewBg = this.customStatBarViewBg;
                immersionConfig.mIsShowNavBar = this.isShowNavBar;
                immersionConfig.mIsShowStatusBar = this.isShowStatBar;
                immersionConfig.mUseLightStatusBar = this.useLightStatBar;
                immersionConfig.mStatusBarColor = this.statusBarColor;
                return immersionConfig;
            }
        }
    }

    private boolean setMIUISetStatusBarLightMode(Window window, boolean z) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                if (z) {
                    method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i));
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private void setMEIZUStatusBar(ImmersionConfig immersionConfig) {
        int i;
        try {
            Window window = this.mActivity.getWindow();
            window.addFlags(67108864);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i2 = declaredField.getInt(null);
            int i3 = declaredField2.getInt(attributes);
            if (immersionConfig.mUseLightStatusBar) {
                i = i2 | i3;
            } else {
                i = (i2 ^ (-1)) & i3;
            }
            declaredField2.setInt(attributes, i);
            window.setAttributes(attributes);
            int i4 = immersionConfig.mCustomStatusBarViewBg;
            if (i4 == 1) {
                i4 = getDefaultStatusBarViewBg();
            }
            View statusBarView = getStatusBarView(immersionConfig);
            if (statusBarView != null) {
                statusBarView.setBackgroundColor(i4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkSpecialRoms() {
        RomUtils.getProp("ro.miui.ui.version.name");
    }

    public static void setDialogImmersion(Dialog dialog) {
        if (Build.VERSION.SDK_INT >= 21) {
            int color = dialog.getContext().getResources().getColor(com.baidu.searchbox.widget.immersion.R.color.dialog_immersion_status_bar_color);
            Window window = dialog.getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(color);
        }
    }

    public static boolean isImmersionEnabled(View view) {
        return (!SUPPORT_IMMERSION || view == null || view.findViewById(com.baidu.searchbox.widget.immersion.R.id.immersion_custom_statusbar_view) == null) ? false : true;
    }
}
