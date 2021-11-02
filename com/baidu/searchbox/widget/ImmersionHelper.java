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
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.BitmapCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.widget.graphics.Palette;
import com.baidu.searchbox.widget.immersion.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class ImmersionHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    @SuppressLint({"InlinedApi"})
    public static final int DEFAULT_FLAG = 5120;
    public static final int DEFAULT_POP_DIALOG_COLOR;
    public static final int HIDE_NAV_FLAG = 5120;
    public static final int INVALID_COLOR = 1;
    public static final int MEIZU = 2;
    public static final int NORMAL_PHONE = 0;
    public static final String SP_KEY_IMMERSION_SWITCH = "sp_key_immersion_switch";
    public static final int STATUS_BAR_ALPHA_BELOW_M = 45;
    public static final boolean SUPPORT_IMMERSION;
    public static final String TAG = "ImmersionHelper";
    public static final String VIEW_TAG = "IMMERSION_VIEW";
    public static final int XIAOMI = 1;
    public static int sRomType;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mActivity;
    public ImmersionConfig mDayImmersionConfig;
    public ImmersionConfig mNightImmersionConfig;
    public ViewGroup mRootView;
    public int mStatusBarViewBg;

    /* loaded from: classes7.dex */
    public static class ImmersionConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mCustomStatusBarViewBg;
        public boolean mIsShowNavBar;
        public boolean mIsShowStatusBar;
        public int mStatusBarColor;
        public boolean mUseLightStatusBar;

        /* loaded from: classes7.dex */
        public static class Builder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int customStatBarViewBg;
            public boolean isShowNavBar;
            public boolean isShowStatBar;
            public int statusBarColor;
            public boolean useLightStatBar;

            public Builder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.isShowNavBar = true;
                this.useLightStatBar = true;
                this.isShowStatBar = true;
            }

            public ImmersionConfig build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    ImmersionConfig immersionConfig = new ImmersionConfig();
                    immersionConfig.mCustomStatusBarViewBg = this.customStatBarViewBg;
                    immersionConfig.mIsShowNavBar = this.isShowNavBar;
                    immersionConfig.mIsShowStatusBar = this.isShowStatBar;
                    immersionConfig.mUseLightStatusBar = this.useLightStatBar;
                    immersionConfig.mStatusBarColor = this.statusBarColor;
                    return immersionConfig;
                }
                return (ImmersionConfig) invokeV.objValue;
            }

            public Builder setCustomStatusBarViewBg(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.customStatBarViewBg = i2;
                    return this;
                }
                return (Builder) invokeI.objValue;
            }

            public Builder setStatusBarColor(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                    this.statusBarColor = i2;
                    return this;
                }
                return (Builder) invokeI.objValue;
            }

            public Builder showNavBar(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
                    this.isShowNavBar = z;
                    return this;
                }
                return (Builder) invokeZ.objValue;
            }

            public Builder showStatusBar(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                    this.isShowStatBar = z;
                    return this;
                }
                return (Builder) invokeZ.objValue;
            }

            public Builder useLightStatusBar(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
                    this.useLightStatBar = z;
                    return this;
                }
                return (Builder) invokeZ.objValue;
            }
        }

        public ImmersionConfig() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void setIsShowStatusBar(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.mIsShowStatusBar = z;
            }
        }

        public void setUseLightStatusBar(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.mUseLightStatusBar = z;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(205984307, "Lcom/baidu/searchbox/widget/ImmersionHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(205984307, "Lcom/baidu/searchbox/widget/ImmersionHelper;");
                return;
            }
        }
        DEBUG = ImmersionRuntime.GLOBAL_DEBUG;
        DEFAULT_POP_DIALOG_COLOR = Color.parseColor("#80000000");
        SUPPORT_IMMERSION = isSupportImmersion();
        sRomType = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            sRomType = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            sRomType = 2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImmersionHelper(@NonNull Activity activity) {
        this(activity, (ViewGroup) activity.findViewById(16908290));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static int calculateStatusColor(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            if (i3 == 0) {
                return i2;
            }
            float f2 = 1.0f - (i3 / 255.0f);
            return ((int) (((i2 & 255) * f2) + 0.5d)) | (((int) ((((i2 >> 16) & 255) * f2) + 0.5d)) << 16) | (-16777216) | (((int) ((((i2 >> 8) & 255) * f2) + 0.5d)) << 8);
        }
        return invokeII.intValue;
    }

    private void checkSpecialRoms() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            RomUtils.getProp("ro.miui.ui.version.name");
        }
    }

    private ImmersionConfig createConfig(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            ImmersionConfig.Builder builder = new ImmersionConfig.Builder();
            builder.useLightStatusBar(z).showStatusBar(true).showNavBar(false).setStatusBarColor(i3).setCustomStatusBarViewBg(i2);
            return builder.build();
        }
        return (ImmersionConfig) invokeCommon.objValue;
    }

    private void createDefaultDayConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            int defaultStatusBarViewBg = getDefaultStatusBarViewBg();
            this.mDayImmersionConfig = createConfig(defaultStatusBarViewBg, getStatusBarColor(defaultStatusBarViewBg), true);
        }
    }

    private void createDefaultNightConfig() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            int defaultStatusBarViewBg = getDefaultStatusBarViewBg();
            this.mNightImmersionConfig = createConfig(defaultStatusBarViewBg, getStatusBarColor(defaultStatusBarViewBg), false);
        }
    }

    public static int generatePanelColor(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, drawable)) == null) {
            boolean z = DEBUG;
            Drawable newDrawable = drawable.getConstantState().newDrawable();
            int intrinsicWidth = newDrawable.getIntrinsicWidth();
            int intrinsicHeight = newDrawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, 2, newDrawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            if (DEBUG) {
                String str = "new bit map size: " + BitmapCompat.getAllocationByteCount(createBitmap) + "bytes";
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
            int rgb = swatch != null ? swatch.getRgb() : -1;
            if (DEBUG) {
                String str2 = "end generatePanelColor() color: " + rgb;
            }
            return rgb;
        }
        return invokeL.intValue;
    }

    private int getDefaultStatusBarViewBg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return this.mActivity.getResources().getColor(R.color.statusbar_immersion_bg);
            }
            return this.mActivity.getResources().getColor(R.color.statusbar_immersion_bg_below_lollipop);
        }
        return invokeV.intValue;
    }

    private int getStatusBarColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, this, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return 0;
            }
            return calculateStatusColor(i2, 45);
        }
        return invokeI.intValue;
    }

    @RequiresApi(api = 19)
    public static int getStatusBarHideVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return 5380;
        }
        return invokeV.intValue;
    }

    private View getStatusBarView(ImmersionConfig immersionConfig) {
        InterceptResult invokeL;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, immersionConfig)) == null) {
            ViewGroup viewGroup = this.mRootView;
            if (viewGroup == null || (childAt = viewGroup.getChildAt(0)) == null) {
                return null;
            }
            if (VIEW_TAG.equals(childAt.getTag())) {
                if (immersionConfig.mIsShowStatusBar) {
                    return childAt;
                }
                this.mRootView.removeViewAt(0);
                View childAt2 = this.mRootView.getChildAt(0);
                if (childAt2 != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
                    layoutParams.topMargin = 0;
                    childAt2.setLayoutParams(layoutParams);
                }
                return null;
            } else if (immersionConfig.mIsShowStatusBar) {
                int statusBarHeight = DeviceUtil.ScreenInfo.getStatusBarHeight();
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams2.topMargin = statusBarHeight;
                childAt.setLayoutParams(layoutParams2);
                View view = new View(this.mActivity);
                view.setTag(VIEW_TAG);
                view.setId(R.id.immersion_custom_statusbar_view);
                this.mRootView.addView(view, 0, new ViewGroup.LayoutParams(-1, statusBarHeight));
                return view;
            } else {
                return null;
            }
        }
        return (View) invokeL.objValue;
    }

    public static boolean isImmersionEnabled(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, view)) == null) ? (!SUPPORT_IMMERSION || view == null || view.findViewById(R.id.immersion_custom_statusbar_view) == null) ? false : true : invokeL.booleanValue;
    }

    public static boolean isSupportImmersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            boolean z = Build.VERSION.SDK_INT >= 21;
            return DEBUG ? z & PreferenceUtils.getBoolean(SP_KEY_IMMERSION_SWITCH, z) : z;
        }
        return invokeV.booleanValue;
    }

    public static void setDialogImmersion(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, dialog) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        int color = dialog.getContext().getResources().getColor(R.color.dialog_immersion_status_bar_color);
        Window window = dialog.getWindow();
        window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(color);
    }

    @SuppressLint({"InlinedApi"})
    private void setMEIZUStatusBar(ImmersionConfig immersionConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, immersionConfig) == null) {
            try {
                Window window = this.mActivity.getWindow();
                window.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i2 = declaredField.getInt(null);
                int i3 = declaredField2.getInt(attributes);
                declaredField2.setInt(attributes, immersionConfig.mUseLightStatusBar ? i2 | i3 : (~i2) & i3);
                window.setAttributes(attributes);
                int i4 = immersionConfig.mCustomStatusBarViewBg;
                if (i4 == 1) {
                    i4 = getDefaultStatusBarViewBg();
                }
                View statusBarView = getStatusBarView(immersionConfig);
                if (statusBarView != null) {
                    statusBarView.setBackgroundColor(i4);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private boolean setMIUISetStatusBarLightMode(Window window, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65554, this, window, z)) == null) {
            if (window != null) {
                Class<?> cls = window.getClass();
                try {
                    Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                    int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                    Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                    if (z) {
                        method.invoke(window, Integer.valueOf(i2), Integer.valueOf(i2));
                    } else {
                        method.invoke(window, 0, Integer.valueOf(i2));
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    private void setWindowFlag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            Window window = this.mActivity.getWindow();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 21) {
                if (i2 >= 19) {
                    window.addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                    return;
                }
                return;
            }
            window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            window.addFlags(Integer.MIN_VALUE);
            if (sRomType != 1) {
                return;
            }
            setMIUISetStatusBarLightMode(window, getConfig().mUseLightStatusBar);
        }
    }

    private boolean shouldUseLightStatusBar(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, this, i2)) == null) {
            return Build.VERSION.SDK_INT >= 23 && i2 == getDefaultStatusBarViewBg() && !NightModeHelper.getNightModeSwitcherState();
        }
        return invokeI.booleanValue;
    }

    @SuppressLint({"InlinedApi"})
    private void updateUI(ImmersionConfig immersionConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, this, immersionConfig) == null) {
            Window window = this.mActivity.getWindow();
            boolean unused = immersionConfig.mIsShowNavBar;
            int i2 = immersionConfig.mUseLightStatusBar ? 13312 : 5120;
            int i3 = !immersionConfig.mIsShowStatusBar ? i2 & (-257) : i2 | 256;
            int i4 = immersionConfig.mCustomStatusBarViewBg;
            if (i4 == 1) {
                i4 = getDefaultStatusBarViewBg();
            }
            window.getDecorView().setSystemUiVisibility(i3);
            if (Build.VERSION.SDK_INT >= 21) {
                window.setStatusBarColor(immersionConfig.mStatusBarColor);
            }
            View statusBarView = getStatusBarView(immersionConfig);
            if (statusBarView != null) {
                statusBarView.setBackgroundColor(i4);
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    public void disable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
                window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                window.getDecorView().setSystemUiVisibility(-5121);
            }
        }
    }

    @NonNull
    public ImmersionConfig getConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        return (ImmersionConfig) invokeV.objValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mDayImmersionConfig = null;
            this.mNightImmersionConfig = null;
            this.mStatusBarViewBg = 1;
        }
    }

    public void resetWithCurImmersion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setImmersion(getConfig());
        }
    }

    public void setDayConfig(@NonNull ImmersionConfig immersionConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, immersionConfig) == null) {
            this.mDayImmersionConfig = immersionConfig;
        }
    }

    public void setImmersion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setImmersion(1);
        }
    }

    public void setNightConfig(@NonNull ImmersionConfig immersionConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, immersionConfig) == null) {
            this.mNightImmersionConfig = immersionConfig;
        }
    }

    public ImmersionHelper(@NonNull Activity activity, @NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, viewGroup};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mStatusBarViewBg = 1;
        this.mActivity = activity;
        this.mRootView = viewGroup;
    }

    public void setImmersion(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            setImmersion(i2, false);
        }
    }

    public void setImmersion(int i2, boolean z) {
        ImmersionConfig createConfig;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && SUPPORT_IMMERSION) {
            if (i2 == 1) {
                if (this.mStatusBarViewBg != 1) {
                    reset();
                }
                this.mStatusBarViewBg = i2;
                createConfig = getConfig();
            } else {
                this.mStatusBarViewBg = i2;
                createConfig = createConfig(i2, getStatusBarColor(i2), z);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, immersionConfig) == null) {
            if (sRomType == 2) {
                setMEIZUStatusBar(immersionConfig);
                return;
            }
            setWindowFlag();
            updateUI(immersionConfig);
        }
    }
}
