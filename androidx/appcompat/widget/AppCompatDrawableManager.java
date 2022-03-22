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
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
                            this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new int[]{R$drawable.abc_textfield_search_default_mtrl_alpha, R$drawable.abc_textfield_default_mtrl_alpha, R$drawable.abc_ab_share_pack_mtrl_alpha};
                            this.TINT_COLOR_CONTROL_NORMAL = new int[]{R$drawable.abc_ic_commit_search_api_mtrl_alpha, R$drawable.abc_seekbar_tick_mark_material, R$drawable.abc_ic_menu_share_mtrl_alpha, R$drawable.abc_ic_menu_copy_mtrl_am_alpha, R$drawable.abc_ic_menu_cut_mtrl_alpha, R$drawable.abc_ic_menu_selectall_mtrl_alpha, R$drawable.abc_ic_menu_paste_mtrl_am_alpha};
                            this.COLORFILTER_COLOR_CONTROL_ACTIVATED = new int[]{R$drawable.abc_textfield_activated_mtrl_alpha, R$drawable.abc_textfield_search_activated_mtrl_alpha, R$drawable.abc_cab_background_top_mtrl_alpha, R$drawable.abc_text_cursor_material, R$drawable.abc_text_select_handle_left_mtrl_dark, R$drawable.abc_text_select_handle_middle_mtrl_dark, R$drawable.abc_text_select_handle_right_mtrl_dark, R$drawable.abc_text_select_handle_left_mtrl_light, R$drawable.abc_text_select_handle_middle_mtrl_light, R$drawable.abc_text_select_handle_right_mtrl_light};
                            this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new int[]{R$drawable.abc_popup_background_mtrl_mult, R$drawable.abc_cab_background_internal_bg, R$drawable.abc_menu_hardkey_panel_mtrl_mult};
                            this.TINT_COLOR_CONTROL_STATE_LIST = new int[]{R$drawable.abc_tab_indicator_material, R$drawable.abc_textfield_search_material};
                            this.TINT_CHECKABLE_BUTTON_LIST = new int[]{R$drawable.abc_btn_check_material, R$drawable.abc_btn_radio_material, R$drawable.abc_btn_check_material_anim, R$drawable.abc_btn_radio_material_anim};
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
                            return (interceptable2 == null || (invokeL = interceptable2.invokeL(65538, this, context)) == null) ? createButtonColorStateList(context, 0) : (ColorStateList) invokeL.objValue;
                        }

                        private ColorStateList createButtonColorStateList(@NonNull Context context, @ColorInt int i) {
                            InterceptResult invokeLI;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(65539, this, context, i)) == null) {
                                int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R$attr.colorControlHighlight);
                                return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.PRESSED_STATE_SET, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, R$attr.colorButtonNormal), ColorUtils.compositeColors(themeAttrColor, i), ColorUtils.compositeColors(themeAttrColor, i), i});
                            }
                            return (ColorStateList) invokeLI.objValue;
                        }

                        private ColorStateList createColoredButtonColorStateList(@NonNull Context context) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeL = interceptable2.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) ? createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R$attr.obfuscated)) : (ColorStateList) invokeL.objValue;
                        }

                        private ColorStateList createDefaultButtonColorStateList(@NonNull Context context) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeL = interceptable2.invokeL(65541, this, context)) == null) ? createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R$attr.colorButtonNormal)) : (ColorStateList) invokeL.objValue;
                        }

                        private ColorStateList createSwitchThumbColorStateList(Context context) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(65542, this, context)) == null) {
                                int[][] iArr = new int[3];
                                int[] iArr2 = new int[3];
                                ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, R$attr.colorSwitchThumbNormal);
                                if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
                                    iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                                    iArr2[0] = themeAttrColorStateList.getColorForState(iArr[0], 0);
                                    iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                                    iArr2[1] = ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated);
                                    iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                                    iArr2[2] = themeAttrColorStateList.getDefaultColor();
                                } else {
                                    iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                                    iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, R$attr.colorSwitchThumbNormal);
                                    iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                                    iArr2[1] = ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated);
                                    iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                                    iArr2[2] = ThemeUtils.getThemeAttrColor(context, R$attr.colorSwitchThumbNormal);
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
                                if (i == R$drawable.abc_cab_background_top_material) {
                                    return new LayerDrawable(new Drawable[]{resourceManagerInternal.getDrawable(context, R$drawable.abc_cab_background_internal_bg), resourceManagerInternal.getDrawable(context, R$drawable.abc_cab_background_top_mtrl_alpha)});
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
                                if (i == R$drawable.abc_edit_text_material) {
                                    return AppCompatResources.getColorStateList(context, R$color.abc_tint_edittext);
                                }
                                if (i == R$drawable.abc_switch_track_mtrl_alpha) {
                                    return AppCompatResources.getColorStateList(context, R$color.abc_tint_switch_track);
                                }
                                if (i == R$drawable.abc_switch_thumb_material) {
                                    return createSwitchThumbColorStateList(context);
                                }
                                if (i == R$drawable.abc_btn_default_mtrl_shape) {
                                    return createDefaultButtonColorStateList(context);
                                }
                                if (i == R$drawable.abc_btn_borderless_material) {
                                    return createBorderlessButtonColorStateList(context);
                                }
                                if (i == R$drawable.abc_btn_colored_material) {
                                    return createColoredButtonColorStateList(context);
                                }
                                if (i != R$drawable.abc_spinner_mtrl_am_alpha && i != R$drawable.abc_spinner_textfield_background_material) {
                                    if (arrayContains(this.TINT_COLOR_CONTROL_NORMAL, i)) {
                                        return ThemeUtils.getThemeAttrColorStateList(context, R$attr.obfuscated);
                                    }
                                    if (arrayContains(this.TINT_COLOR_CONTROL_STATE_LIST, i)) {
                                        return AppCompatResources.getColorStateList(context, R$color.abc_tint_default);
                                    }
                                    if (arrayContains(this.TINT_CHECKABLE_BUTTON_LIST, i)) {
                                        return AppCompatResources.getColorStateList(context, R$color.abc_tint_btn_checkable);
                                    }
                                    if (i == R$drawable.abc_seekbar_thumb_material) {
                                        return AppCompatResources.getColorStateList(context, R$color.abc_tint_seek_thumb);
                                    }
                                    return null;
                                }
                                return AppCompatResources.getColorStateList(context, R$color.abc_tint_spinner);
                            }
                            return (ColorStateList) invokeLI.objValue;
                        }

                        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                        public PorterDuff.Mode getTintModeForDrawableRes(int i) {
                            InterceptResult invokeI;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                                if (i == R$drawable.abc_switch_thumb_material) {
                                    return PorterDuff.Mode.MULTIPLY;
                                }
                                return null;
                            }
                            return (PorterDuff.Mode) invokeI.objValue;
                        }

                        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                        public boolean tintDrawable(@NonNull Context context, int i, @NonNull Drawable drawable) {
                            InterceptResult invokeLIL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048579, this, context, i, drawable)) == null) {
                                if (i == R$drawable.abc_seekbar_track_material) {
                                    LayerDrawable layerDrawable = (LayerDrawable) drawable;
                                    setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(context, R$attr.obfuscated), AppCompatDrawableManager.DEFAULT_MODE);
                                    setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, R$attr.obfuscated), AppCompatDrawableManager.DEFAULT_MODE);
                                    setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                                    return true;
                                } else if (i == R$drawable.abc_ratingbar_material || i == R$drawable.abc_ratingbar_indicator_material || i == R$drawable.abc_ratingbar_small_material) {
                                    LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                                    setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(context, R$attr.obfuscated), AppCompatDrawableManager.DEFAULT_MODE);
                                    setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                                    setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R$attr.colorControlActivated), AppCompatDrawableManager.DEFAULT_MODE);
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                            return invokeLIL.booleanValue;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
                        /* JADX WARN: Removed duplicated region for block: B:30:0x0065 A[RETURN] */
                        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public boolean tintDrawableUsingColorFilter(@NonNull Context context, int i, @NonNull Drawable drawable) {
                            InterceptResult invokeLIL;
                            int i2;
                            boolean z;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null && (invokeLIL = interceptable2.invokeLIL(1048580, this, context, i, drawable)) != null) {
                                return invokeLIL.booleanValue;
                            }
                            PorterDuff.Mode mode = AppCompatDrawableManager.DEFAULT_MODE;
                            int i3 = 16842801;
                            if (arrayContains(this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i)) {
                                i3 = R$attr.obfuscated;
                            } else if (arrayContains(this.COLORFILTER_COLOR_CONTROL_ACTIVATED, i)) {
                                i3 = R$attr.colorControlActivated;
                            } else if (arrayContains(this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i)) {
                                mode = PorterDuff.Mode.MULTIPLY;
                            } else if (i == R$drawable.abc_list_divider_mtrl_alpha) {
                                i3 = 16842800;
                                i2 = Math.round(40.8f);
                                z = true;
                                if (z) {
                                    if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                                        drawable = drawable.mutate();
                                    }
                                    drawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, i3), mode));
                                    if (i2 != -1) {
                                        drawable.setAlpha(i2);
                                    }
                                    return true;
                                }
                                return false;
                            } else if (i != R$drawable.abc_dialog_material_background) {
                                i2 = -1;
                                z = false;
                                i3 = 0;
                                if (z) {
                                }
                            }
                            i2 = -1;
                            z = true;
                            if (z) {
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

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            synchronized (this) {
                this.mResourceManager.onConfigurationChanged(context);
            }
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
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, context, i, drawable)) == null) ? this.mResourceManager.tintDrawableUsingColorFilter(context, i, drawable) : invokeLIL.booleanValue;
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
}
