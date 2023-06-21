package com.baidu.searchbox.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BitmapCompat;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.widget.graphics.Palette;
import com.baidu.tieba.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class ImmersionHelper {
    @SuppressLint({"InlinedApi"})
    public static final int DEFAULT_FLAG = 5120;
    public static final int HIDE_NAV_FLAG = 5120;
    public static final int INVALID_COLOR = 1;
    public static final int MEIZU = 2;
    public static final int NORMAL_PHONE = 0;
    public static final String SP_KEY_IMMERSION_SWITCH = "sp_key_immersion_switch";
    public static final int STATUS_BAR_ALPHA_BELOW_M = 45;
    public static final String TAG = "ImmersionHelper";
    public static final String VIEW_TAG = "IMMERSION_VIEW";
    public static final int XIAOMI = 1;
    public static int sRomType;
    public Activity mActivity;
    public ImmersionConfig mDayImmersionConfig;
    public ImmersionConfig mNightImmersionConfig;
    public ViewGroup mRootView;
    public int mStatusBarViewBg;
    public static final boolean DEBUG = ImmersionRuntime.GLOBAL_DEBUG;
    public static final int DEFAULT_POP_DIALOG_COLOR = Color.parseColor("#80000000");
    public static final boolean SUPPORT_IMMERSION = isSupportImmersion();

    public static int calculateStatusColor(int i, int i2) {
        if (i2 == 0) {
            return i;
        }
        float f = 1.0f - (i2 / 255.0f);
        return ((int) (((i & 255) * f) + 0.5d)) | (((int) ((((i >> 16) & 255) * f) + 0.5d)) << 16) | (-16777216) | (((int) ((((i >> 8) & 255) * f) + 0.5d)) << 8);
    }

    @RequiresApi(api = 19)
    public static int getStatusBarHideVisibility() {
        return 5380;
    }

    /* loaded from: classes4.dex */
    public static class ImmersionConfig {
        public int mCustomStatusBarViewBg;
        public boolean mIsShowNavBar;
        public boolean mIsShowStatusBar;
        public int mStatusBarColor;
        public boolean mUseLightStatusBar;

        /* loaded from: classes4.dex */
        public static class Builder {
            public int customStatBarViewBg;
            public int statusBarColor;
            public boolean isShowNavBar = true;
            public boolean useLightStatBar = true;
            public boolean isShowStatBar = true;

            public ImmersionConfig build() {
                ImmersionConfig immersionConfig = new ImmersionConfig();
                immersionConfig.mCustomStatusBarViewBg = this.customStatBarViewBg;
                immersionConfig.mIsShowNavBar = this.isShowNavBar;
                immersionConfig.mIsShowStatusBar = this.isShowStatBar;
                immersionConfig.mUseLightStatusBar = this.useLightStatBar;
                immersionConfig.mStatusBarColor = this.statusBarColor;
                return immersionConfig;
            }

            public Builder setCustomStatusBarViewBg(int i) {
                this.customStatBarViewBg = i;
                return this;
            }

            public Builder setStatusBarColor(int i) {
                this.statusBarColor = i;
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
        }

        public void setIsShowStatusBar(boolean z) {
            this.mIsShowStatusBar = z;
        }

        public void setUseLightStatusBar(boolean z) {
            this.mUseLightStatusBar = z;
        }
    }

    static {
        sRomType = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            sRomType = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            sRomType = 2;
        }
    }

    private void checkSpecialRoms() {
        RomUtils.getProp("ro.miui.ui.version.name");
    }

    private void createDefaultDayConfig() {
        int defaultStatusBarViewBg = getDefaultStatusBarViewBg();
        this.mDayImmersionConfig = createConfig(defaultStatusBarViewBg, getStatusBarColor(defaultStatusBarViewBg), true);
    }

    private void createDefaultNightConfig() {
        int defaultStatusBarViewBg = getDefaultStatusBarViewBg();
        this.mNightImmersionConfig = createConfig(defaultStatusBarViewBg, getStatusBarColor(defaultStatusBarViewBg), false);
    }

    private int getDefaultStatusBarViewBg() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.mActivity.getResources().getColor(R.color.obfuscated_res_0x7f060a8c);
        }
        return this.mActivity.getResources().getColor(R.color.obfuscated_res_0x7f060a8d);
    }

    public static boolean isSupportImmersion() {
        boolean z;
        if (Build.VERSION.SDK_INT >= 21) {
            z = true;
        } else {
            z = false;
        }
        if (DEBUG) {
            return z & PreferenceUtils.getBoolean(SP_KEY_IMMERSION_SWITCH, z);
        }
        return z;
    }

    private void setWindowFlag() {
        Window window = this.mActivity.getWindow();
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            if (sRomType == 1) {
                setMIUISetStatusBarLightMode(window, getConfig().mUseLightStatusBar);
            }
        } else if (i >= 19) {
            window.addFlags(67108864);
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

    public void reset() {
        this.mDayImmersionConfig = null;
        this.mNightImmersionConfig = null;
        this.mStatusBarViewBg = 1;
    }

    public void resetWithCurImmersion() {
        setImmersion(getConfig());
    }

    public void setImmersion() {
        setImmersion(1);
    }

    public ImmersionHelper(@NonNull Activity activity) {
        this(activity, (ViewGroup) activity.findViewById(16908290));
    }

    private int getStatusBarColor(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return 0;
        }
        return calculateStatusColor(i, 45);
    }

    public static boolean isImmersionEnabled(View view2) {
        if (!SUPPORT_IMMERSION || view2 == null || view2.findViewById(R.id.obfuscated_res_0x7f0910e2) == null) {
            return false;
        }
        return true;
    }

    public static void setDialogImmersion(Dialog dialog) {
        if (Build.VERSION.SDK_INT >= 21) {
            int color = dialog.getContext().getResources().getColor(R.color.obfuscated_res_0x7f060717);
            Window window = dialog.getWindow();
            window.getDecorView().setSystemUiVisibility(1280);
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(color);
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

    private boolean shouldUseLightStatusBar(int i) {
        boolean nightModeSwitcherState = NightModeHelper.getNightModeSwitcherState();
        if (Build.VERSION.SDK_INT >= 23 && i == getDefaultStatusBarViewBg() && !nightModeSwitcherState) {
            return true;
        }
        return false;
    }

    public void setDayConfig(@NonNull ImmersionConfig immersionConfig) {
        this.mDayImmersionConfig = immersionConfig;
    }

    public void setNightConfig(@NonNull ImmersionConfig immersionConfig) {
        this.mNightImmersionConfig = immersionConfig;
    }

    public ImmersionHelper(@NonNull Activity activity, @NonNull ViewGroup viewGroup) {
        this.mStatusBarViewBg = 1;
        this.mActivity = activity;
        this.mRootView = viewGroup;
    }

    public void setImmersion(int i, boolean z) {
        ImmersionConfig createConfig;
        if (!SUPPORT_IMMERSION) {
            return;
        }
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

    private ImmersionConfig createConfig(int i, int i2, boolean z) {
        ImmersionConfig.Builder builder = new ImmersionConfig.Builder();
        builder.useLightStatusBar(z).showStatusBar(true).showNavBar(false).setStatusBarColor(i2).setCustomStatusBarViewBg(i);
        return builder.build();
    }

    public static int generatePanelColor(Drawable drawable) {
        Bitmap.Config config;
        if (DEBUG) {
            Log.d(TAG, "start generatePanelColor()");
        }
        Drawable newDrawable = drawable.getConstantState().newDrawable();
        int intrinsicWidth = newDrawable.getIntrinsicWidth();
        int intrinsicHeight = newDrawable.getIntrinsicHeight();
        int i = -1;
        if (newDrawable.getOpacity() != -1) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, 2, config);
        if (DEBUG) {
            Log.d(TAG, "new bit map size: " + BitmapCompat.getAllocationByteCount(createBitmap) + "bytes");
        }
        Canvas canvas = new Canvas(createBitmap);
        newDrawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        newDrawable.draw(canvas);
        Palette.Swatch swatch = null;
        for (Palette.Swatch swatch2 : Palette.from(createBitmap).clearFilters().clearRegion().clearTargets().generateHeader().getSwatches()) {
            if (swatch == null || swatch.getPopulation() < swatch2.getPopulation()) {
                if (swatch2.getRgb() != 1) {
                    swatch = swatch2;
                }
            }
        }
        if (swatch != null) {
            i = swatch.getRgb();
        }
        if (DEBUG) {
            Log.d(TAG, "end generatePanelColor() color: " + i);
        }
        return i;
    }

    private View getStatusBarView(ImmersionConfig immersionConfig) {
        View childAt;
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup == null || (childAt = viewGroup.getChildAt(0)) == null) {
            return null;
        }
        if (VIEW_TAG.equals(childAt.getTag())) {
            if (!immersionConfig.mIsShowStatusBar) {
                this.mRootView.removeViewAt(0);
                View childAt2 = this.mRootView.getChildAt(0);
                if (childAt2 != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
                    layoutParams.topMargin = 0;
                    childAt2.setLayoutParams(layoutParams);
                }
                return null;
            }
            return childAt;
        } else if (!immersionConfig.mIsShowStatusBar) {
            return null;
        } else {
            int statusBarHeight = DeviceUtil.ScreenInfo.getStatusBarHeight();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams2.topMargin = statusBarHeight;
            childAt.setLayoutParams(layoutParams2);
            View view2 = new View(this.mActivity);
            view2.setTag(VIEW_TAG);
            view2.setId(R.id.obfuscated_res_0x7f0910e2);
            this.mRootView.addView(view2, 0, new ViewGroup.LayoutParams(-1, statusBarHeight));
            return view2;
        }
    }

    @SuppressLint({"InlinedApi"})
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
                i = (~i2) & i3;
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

    @SuppressLint({"InlinedApi"})
    private void updateUI(ImmersionConfig immersionConfig) {
        int i;
        int i2;
        Window window = this.mActivity.getWindow();
        boolean unused = immersionConfig.mIsShowNavBar;
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
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
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

    public void setImmersion(int i) {
        setImmersion(i, false);
    }
}
