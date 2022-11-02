package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class AppCompatDrawableManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final PorterDuff.Mode DEFAULT_MODE;
    public static AppCompatDrawableManager INSTANCE = null;
    public static final String TAG = "AppCompatDrawableManag";
    public transient /* synthetic */ FieldHolder $fh;
    public ResourceManagerInternal mResourceManager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1714392490, "Landroidx/appcompat/widget/AppCompatDrawableManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1714392490, "Landroidx/appcompat/widget/AppCompatDrawableManager;");
                return;
            }
        }
        DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    }

    public AppCompatDrawableManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized AppCompatDrawableManager get() {
        InterceptResult invokeV;
        AppCompatDrawableManager appCompatDrawableManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (AppCompatDrawableManager.class) {
                if (INSTANCE == null) {
                    preload();
                }
                appCompatDrawableManager = INSTANCE;
            }
            return appCompatDrawableManager;
        }
        return (AppCompatDrawableManager) invokeV.objValue;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        InterceptResult invokeIL;
        PorterDuffColorFilter porterDuffColorFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, mode)) == null) {
            synchronized (AppCompatDrawableManager.class) {
                porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(i, mode);
            }
            return porterDuffColorFilter;
        }
        return (PorterDuffColorFilter) invokeIL.objValue;
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i) {
        InterceptResult invokeLI;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, context, i)) == null) {
            synchronized (this) {
                drawable = this.mResourceManager.getDrawable(context, i);
            }
            return drawable;
        }
        return (Drawable) invokeLI.objValue;
    }

    public synchronized ColorStateList getTintList(@NonNull Context context, @DrawableRes int i) {
        InterceptResult invokeLI;
        ColorStateList tintList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i)) == null) {
            synchronized (this) {
                tintList = this.mResourceManager.getTintList(context, i);
            }
            return tintList;
        }
        return (ColorStateList) invokeLI.objValue;
    }

    public static synchronized void preload() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            synchronized (AppCompatDrawableManager.class) {
                if (INSTANCE == null) {
                    AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
                    INSTANCE = appCompatDrawableManager;
                    appCompatDrawableManager.mResourceManager = ResourceManagerInternal.get();
                    INSTANCE.mResourceManager.setHooks(new ResourceManagerInternal.ResourceManagerHooks() { // from class: androidx.appcompat.widget.AppCompatDrawableManager.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
                        public final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
                        public final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
                        public final int[] TINT_CHECKABLE_BUTTON_LIST;
                        public final int[] TINT_COLOR_CONTROL_NORMAL;
                        public final int[] TINT_COLOR_CONTROL_STATE_LIST;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new int[]{R.drawable.obfuscated_res_0x7f0800b2, R.drawable.obfuscated_res_0x7f0800b0, R.drawable.obfuscated_res_0x7f08005f};
                            this.TINT_COLOR_CONTROL_NORMAL = new int[]{R.drawable.obfuscated_res_0x7f080077, R.drawable.obfuscated_res_0x7f0800a0, R.drawable.obfuscated_res_0x7f08007e, R.drawable.obfuscated_res_0x7f080079, R.drawable.obfuscated_res_0x7f08007a, R.drawable.obfuscated_res_0x7f08007d, R.drawable.obfuscated_res_0x7f08007c};
                            this.COLORFILTER_COLOR_CONTROL_ACTIVATED = new int[]{R.drawable.obfuscated_res_0x7f0800af, R.drawable.obfuscated_res_0x7f0800b1, R.drawable.obfuscated_res_0x7f080070, R.drawable.obfuscated_res_0x7f0800a8, R.drawable.obfuscated_res_0x7f0800a9, R.drawable.obfuscated_res_0x7f0800ab, R.drawable.obfuscated_res_0x7f0800ad, R.drawable.obfuscated_res_0x7f0800aa, R.drawable.obfuscated_res_0x7f0800ac, R.drawable.obfuscated_res_0x7f0800ae};
                            this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new int[]{R.drawable.obfuscated_res_0x7f080096, R.drawable.obfuscated_res_0x7f08006e, R.drawable.obfuscated_res_0x7f080095};
                            this.TINT_COLOR_CONTROL_STATE_LIST = new int[]{R.drawable.obfuscated_res_0x7f0800a6, R.drawable.obfuscated_res_0x7f0800b3};
                            this.TINT_CHECKABLE_BUTTON_LIST = new int[]{R.drawable.obfuscated_res_0x7f080062, R.drawable.obfuscated_res_0x7f080068, R.drawable.obfuscated_res_0x7f080063, R.drawable.obfuscated_res_0x7f080069};
                        }

                        private boolean arrayContains(int[] iArr, int i) {
                            InterceptResult invokeLI;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(65537, this, iArr, i)) == null) {
                                for (int i2 : iArr) {
                                    if (i2 == i) {
                                        return true;
                                    }
                                }
                                return false;
                            }
                            return invokeLI.booleanValue;
                        }

                        private ColorStateList createBorderlessButtonColorStateList(@NonNull Context context) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(65538, this, context)) == null) {
                                return createButtonColorStateList(context, 0);
                            }
                            return (ColorStateList) invokeL.objValue;
                        }

                        private ColorStateList createColoredButtonColorStateList(@NonNull Context context) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
                                return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04016b));
                            }
                            return (ColorStateList) invokeL.objValue;
                        }

                        private ColorStateList createDefaultButtonColorStateList(@NonNull Context context) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(65541, this, context)) == null) {
                                return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04016d));
                            }
                            return (ColorStateList) invokeL.objValue;
                        }

                        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                        public PorterDuff.Mode getTintModeForDrawableRes(int i) {
                            InterceptResult invokeI;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                                if (i == R.drawable.obfuscated_res_0x7f0800a4) {
                                    return PorterDuff.Mode.MULTIPLY;
                                }
                                return null;
                            }
                            return (PorterDuff.Mode) invokeI.objValue;
                        }

                        private ColorStateList createButtonColorStateList(@NonNull Context context, @ColorInt int i) {
                            InterceptResult invokeLI;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(65539, this, context, i)) == null) {
                                int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04016f);
                                return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.PRESSED_STATE_SET, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, R.attr.obfuscated_res_0x7f04016d), ColorUtils.compositeColors(themeAttrColor, i), ColorUtils.compositeColors(themeAttrColor, i), i});
                            }
                            return (ColorStateList) invokeLI.objValue;
                        }

                        private ColorStateList createSwitchThumbColorStateList(Context context) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(65542, this, context)) == null) {
                                int[][] iArr = new int[3];
                                int[] iArr2 = new int[3];
                                ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, R.attr.obfuscated_res_0x7f04017f);
                                if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
                                    iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                                    iArr2[0] = themeAttrColorStateList.getColorForState(iArr[0], 0);
                                    iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                                    iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04016e);
                                    iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                                    iArr2[2] = themeAttrColorStateList.getDefaultColor();
                                } else {
                                    iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                                    iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.obfuscated_res_0x7f04017f);
                                    iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                                    iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04016e);
                                    iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                                    iArr2[2] = ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04017f);
                                }
                                return new ColorStateList(iArr, iArr2);
                            }
                            return (ColorStateList) invokeL.objValue;
                        }

                        private void setPorterDuffColorFilter(Drawable drawable, int i, PorterDuff.Mode mode) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLIL(65543, this, drawable, i, mode) == null) {
                                if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                                    drawable = drawable.mutate();
                                }
                                if (mode == null) {
                                    mode = AppCompatDrawableManager.DEFAULT_MODE;
                                }
                                drawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i, mode));
                            }
                        }

                        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                        public Drawable createDrawableFor(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, int i) {
                            InterceptResult invokeLLI;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLLI = interceptable2.invokeLLI(1048576, this, resourceManagerInternal, context, i)) == null) {
                                if (i == R.drawable.obfuscated_res_0x7f08006f) {
                                    return new LayerDrawable(new Drawable[]{resourceManagerInternal.getDrawable(context, R.drawable.obfuscated_res_0x7f08006e), resourceManagerInternal.getDrawable(context, R.drawable.obfuscated_res_0x7f080070)});
                                }
                                return null;
                            }
                            return (Drawable) invokeLLI.objValue;
                        }

                        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                        public ColorStateList getTintListForDrawableRes(@NonNull Context context, int i) {
                            InterceptResult invokeLI;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i)) == null) {
                                if (i == R.drawable.obfuscated_res_0x7f080073) {
                                    return AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f06037a);
                                }
                                if (i == R.drawable.obfuscated_res_0x7f0800a5) {
                                    return AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f06037d);
                                }
                                if (i == R.drawable.obfuscated_res_0x7f0800a4) {
                                    return createSwitchThumbColorStateList(context);
                                }
                                if (i == R.drawable.obfuscated_res_0x7f080067) {
                                    return createDefaultButtonColorStateList(context);
                                }
                                if (i == R.drawable.obfuscated_res_0x7f080061) {
                                    return createBorderlessButtonColorStateList(context);
                                }
                                if (i == R.drawable.obfuscated_res_0x7f080066) {
                                    return createColoredButtonColorStateList(context);
                                }
                                if (i != R.drawable.obfuscated_res_0x7f0800a2 && i != R.drawable.obfuscated_res_0x7f0800a3) {
                                    if (arrayContains(this.TINT_COLOR_CONTROL_NORMAL, i)) {
                                        return ThemeUtils.getThemeAttrColorStateList(context, R.attr.obfuscated_res_0x7f040170);
                                    }
                                    if (arrayContains(this.TINT_COLOR_CONTROL_STATE_LIST, i)) {
                                        return AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f060379);
                                    }
                                    if (arrayContains(this.TINT_CHECKABLE_BUTTON_LIST, i)) {
                                        return AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f060378);
                                    }
                                    if (i == R.drawable.obfuscated_res_0x7f08009f) {
                                        return AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f06037b);
                                    }
                                    return null;
                                }
                                return AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f06037c);
                            }
                            return (ColorStateList) invokeLI.objValue;
                        }

                        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                        public boolean tintDrawable(@NonNull Context context, int i, @NonNull Drawable drawable) {
                            InterceptResult invokeLIL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048579, this, context, i, drawable)) == null) {
                                if (i == R.drawable.obfuscated_res_0x7f0800a1) {
                                    LayerDrawable layerDrawable = (LayerDrawable) drawable;
                                    setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f040170), AppCompatDrawableManager.DEFAULT_MODE);
                                    setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f040170), AppCompatDrawableManager.DEFAULT_MODE);
                                    setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04016e), AppCompatDrawableManager.DEFAULT_MODE);
                                    return true;
                                } else if (i != R.drawable.obfuscated_res_0x7f080098 && i != R.drawable.obfuscated_res_0x7f080097 && i != R.drawable.obfuscated_res_0x7f080099) {
                                    return false;
                                } else {
                                    LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                                    setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(context, R.attr.obfuscated_res_0x7f040170), AppCompatDrawableManager.DEFAULT_MODE);
                                    setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04016e), AppCompatDrawableManager.DEFAULT_MODE);
                                    setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04016e), AppCompatDrawableManager.DEFAULT_MODE);
                                    return true;
                                }
                            }
                            return invokeLIL.booleanValue;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
                        /* JADX WARN: Removed duplicated region for block: B:30:0x0069 A[RETURN] */
                        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public boolean tintDrawableUsingColorFilter(@NonNull Context context, int i, @NonNull Drawable drawable) {
                            InterceptResult invokeLIL;
                            int i2;
                            boolean z;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048580, this, context, i, drawable)) == null) {
                                PorterDuff.Mode mode = AppCompatDrawableManager.DEFAULT_MODE;
                                int i3 = 16842801;
                                if (arrayContains(this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i)) {
                                    i3 = R.attr.obfuscated_res_0x7f040170;
                                } else if (arrayContains(this.COLORFILTER_COLOR_CONTROL_ACTIVATED, i)) {
                                    i3 = R.attr.obfuscated_res_0x7f04016e;
                                } else if (arrayContains(this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i)) {
                                    mode = PorterDuff.Mode.MULTIPLY;
                                } else if (i == R.drawable.obfuscated_res_0x7f08008a) {
                                    i3 = 16842800;
                                    i2 = Math.round(40.8f);
                                    z = true;
                                    if (!z) {
                                        return false;
                                    }
                                    if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                                        drawable = drawable.mutate();
                                    }
                                    drawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, i3), mode));
                                    if (i2 != -1) {
                                        drawable.setAlpha(i2);
                                    }
                                    return true;
                                } else if (i != R.drawable.obfuscated_res_0x7f080072) {
                                    i2 = -1;
                                    z = false;
                                    i3 = 0;
                                    if (!z) {
                                    }
                                }
                                i2 = -1;
                                z = true;
                                if (!z) {
                                }
                            } else {
                                return invokeLIL.booleanValue;
                            }
                        }
                    });
                }
            }
        }
    }

    public static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, drawable, tintInfo, iArr) == null) {
            ResourceManagerInternal.tintDrawable(drawable, tintInfo, iArr);
        }
    }

    public synchronized Drawable onDrawableLoadedFromResources(@NonNull Context context, @NonNull VectorEnabledTintResources vectorEnabledTintResources, @DrawableRes int i) {
        InterceptResult invokeLLI;
        Drawable onDrawableLoadedFromResources;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, context, vectorEnabledTintResources, i)) == null) {
            synchronized (this) {
                onDrawableLoadedFromResources = this.mResourceManager.onDrawableLoadedFromResources(context, vectorEnabledTintResources, i);
            }
            return onDrawableLoadedFromResources;
        }
        return (Drawable) invokeLLI.objValue;
    }

    public boolean tintDrawableUsingColorFilter(@NonNull Context context, @DrawableRes int i, @NonNull Drawable drawable) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, context, i, drawable)) == null) {
            return this.mResourceManager.tintDrawableUsingColorFilter(context, i, drawable);
        }
        return invokeLIL.booleanValue;
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i, boolean z) {
        InterceptResult invokeCommon;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            synchronized (this) {
                drawable = this.mResourceManager.getDrawable(context, i, z);
            }
            return drawable;
        }
        return (Drawable) invokeCommon.objValue;
    }

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            synchronized (this) {
                this.mResourceManager.onConfigurationChanged(context);
            }
        }
    }
}
