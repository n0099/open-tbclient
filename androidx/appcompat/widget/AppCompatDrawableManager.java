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
import com.baidu.tieba.R;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class AppCompatDrawableManager {
    public static final boolean DEBUG = false;
    public static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    public static AppCompatDrawableManager INSTANCE = null;
    public static final String TAG = "AppCompatDrawableManag";
    public ResourceManagerInternal mResourceManager;

    public static synchronized AppCompatDrawableManager get() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            if (INSTANCE == null) {
                preload();
            }
            appCompatDrawableManager = INSTANCE;
        }
        return appCompatDrawableManager;
    }

    public static synchronized void preload() {
        synchronized (AppCompatDrawableManager.class) {
            if (INSTANCE == null) {
                AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
                INSTANCE = appCompatDrawableManager;
                appCompatDrawableManager.mResourceManager = ResourceManagerInternal.get();
                INSTANCE.mResourceManager.setHooks(new ResourceManagerInternal.ResourceManagerHooks() { // from class: androidx.appcompat.widget.AppCompatDrawableManager.1
                    public final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = {R.drawable.obfuscated_res_0x7f0800b3, R.drawable.obfuscated_res_0x7f0800b1, R.drawable.obfuscated_res_0x7f080060};
                    public final int[] TINT_COLOR_CONTROL_NORMAL = {R.drawable.obfuscated_res_0x7f080078, R.drawable.obfuscated_res_0x7f0800a1, R.drawable.obfuscated_res_0x7f08007f, R.drawable.obfuscated_res_0x7f08007a, R.drawable.obfuscated_res_0x7f08007b, R.drawable.obfuscated_res_0x7f08007e, R.drawable.obfuscated_res_0x7f08007d};
                    public final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED = {R.drawable.obfuscated_res_0x7f0800b0, R.drawable.obfuscated_res_0x7f0800b2, R.drawable.obfuscated_res_0x7f080071, R.drawable.obfuscated_res_0x7f0800a9, R.drawable.obfuscated_res_0x7f0800aa, R.drawable.obfuscated_res_0x7f0800ac, R.drawable.obfuscated_res_0x7f0800ae, R.drawable.obfuscated_res_0x7f0800ab, R.drawable.obfuscated_res_0x7f0800ad, R.drawable.obfuscated_res_0x7f0800af};
                    public final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY = {R.drawable.obfuscated_res_0x7f080097, R.drawable.obfuscated_res_0x7f08006f, R.drawable.obfuscated_res_0x7f080096};
                    public final int[] TINT_COLOR_CONTROL_STATE_LIST = {R.drawable.obfuscated_res_0x7f0800a7, R.drawable.obfuscated_res_0x7f0800b4};
                    public final int[] TINT_CHECKABLE_BUTTON_LIST = {R.drawable.obfuscated_res_0x7f080063, R.drawable.obfuscated_res_0x7f080069, R.drawable.obfuscated_res_0x7f080064, R.drawable.obfuscated_res_0x7f08006a};

                    private boolean arrayContains(int[] iArr, int i) {
                        for (int i2 : iArr) {
                            if (i2 == i) {
                                return true;
                            }
                        }
                        return false;
                    }

                    private ColorStateList createBorderlessButtonColorStateList(@NonNull Context context) {
                        return createButtonColorStateList(context, 0);
                    }

                    private ColorStateList createColoredButtonColorStateList(@NonNull Context context) {
                        return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f040178));
                    }

                    private ColorStateList createDefaultButtonColorStateList(@NonNull Context context) {
                        return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04017a));
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public PorterDuff.Mode getTintModeForDrawableRes(int i) {
                        if (i == R.drawable.obfuscated_res_0x7f0800a5) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }

                    private ColorStateList createButtonColorStateList(@NonNull Context context, @ColorInt int i) {
                        int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04017c);
                        return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.PRESSED_STATE_SET, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, R.attr.obfuscated_res_0x7f04017a), ColorUtils.compositeColors(themeAttrColor, i), ColorUtils.compositeColors(themeAttrColor, i), i});
                    }

                    private ColorStateList createSwitchThumbColorStateList(Context context) {
                        int[][] iArr = new int[3];
                        int[] iArr2 = new int[3];
                        ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, R.attr.obfuscated_res_0x7f040191);
                        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
                            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                            iArr2[0] = themeAttrColorStateList.getColorForState(iArr[0], 0);
                            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                            iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04017b);
                            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                            iArr2[2] = themeAttrColorStateList.getDefaultColor();
                        } else {
                            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                            iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.obfuscated_res_0x7f040191);
                            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                            iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04017b);
                            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                            iArr2[2] = ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f040191);
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    private void setPorterDuffColorFilter(Drawable drawable, int i, PorterDuff.Mode mode) {
                        if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = AppCompatDrawableManager.DEFAULT_MODE;
                        }
                        drawable.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i, mode));
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public Drawable createDrawableFor(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, int i) {
                        if (i == R.drawable.obfuscated_res_0x7f080070) {
                            return new LayerDrawable(new Drawable[]{resourceManagerInternal.getDrawable(context, R.drawable.obfuscated_res_0x7f08006f), resourceManagerInternal.getDrawable(context, R.drawable.obfuscated_res_0x7f080071)});
                        }
                        return null;
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public ColorStateList getTintListForDrawableRes(@NonNull Context context, int i) {
                        if (i == R.drawable.obfuscated_res_0x7f080074) {
                            return AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f0603d0);
                        }
                        if (i == R.drawable.obfuscated_res_0x7f0800a6) {
                            return AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f0603d3);
                        }
                        if (i == R.drawable.obfuscated_res_0x7f0800a5) {
                            return createSwitchThumbColorStateList(context);
                        }
                        if (i == R.drawable.obfuscated_res_0x7f080068) {
                            return createDefaultButtonColorStateList(context);
                        }
                        if (i == R.drawable.obfuscated_res_0x7f080062) {
                            return createBorderlessButtonColorStateList(context);
                        }
                        if (i == R.drawable.obfuscated_res_0x7f080067) {
                            return createColoredButtonColorStateList(context);
                        }
                        if (i != R.drawable.obfuscated_res_0x7f0800a3 && i != R.drawable.obfuscated_res_0x7f0800a4) {
                            if (arrayContains(this.TINT_COLOR_CONTROL_NORMAL, i)) {
                                return ThemeUtils.getThemeAttrColorStateList(context, R.attr.obfuscated_res_0x7f04017d);
                            }
                            if (arrayContains(this.TINT_COLOR_CONTROL_STATE_LIST, i)) {
                                return AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f0603cf);
                            }
                            if (arrayContains(this.TINT_CHECKABLE_BUTTON_LIST, i)) {
                                return AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f0603ce);
                            }
                            if (i == R.drawable.obfuscated_res_0x7f0800a0) {
                                return AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f0603d1);
                            }
                            return null;
                        }
                        return AppCompatResources.getColorStateList(context, R.color.obfuscated_res_0x7f0603d2);
                    }

                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    public boolean tintDrawable(@NonNull Context context, int i, @NonNull Drawable drawable) {
                        if (i == R.drawable.obfuscated_res_0x7f0800a2) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04017d), AppCompatDrawableManager.DEFAULT_MODE);
                            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04017d), AppCompatDrawableManager.DEFAULT_MODE);
                            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04017b), AppCompatDrawableManager.DEFAULT_MODE);
                            return true;
                        } else if (i != R.drawable.obfuscated_res_0x7f080099 && i != R.drawable.obfuscated_res_0x7f080098 && i != R.drawable.obfuscated_res_0x7f08009a) {
                            return false;
                        } else {
                            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                            setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(context, R.attr.obfuscated_res_0x7f04017d), AppCompatDrawableManager.DEFAULT_MODE);
                            setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04017b), AppCompatDrawableManager.DEFAULT_MODE);
                            setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R.attr.obfuscated_res_0x7f04017b), AppCompatDrawableManager.DEFAULT_MODE);
                            return true;
                        }
                    }

                    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
                    /* JADX WARN: Removed duplicated region for block: B:28:0x0065 A[RETURN] */
                    @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public boolean tintDrawableUsingColorFilter(@NonNull Context context, int i, @NonNull Drawable drawable) {
                        int i2;
                        boolean z;
                        PorterDuff.Mode mode = AppCompatDrawableManager.DEFAULT_MODE;
                        int i3 = 16842801;
                        if (arrayContains(this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i)) {
                            i3 = R.attr.obfuscated_res_0x7f04017d;
                        } else if (arrayContains(this.COLORFILTER_COLOR_CONTROL_ACTIVATED, i)) {
                            i3 = R.attr.obfuscated_res_0x7f04017b;
                        } else if (arrayContains(this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i)) {
                            mode = PorterDuff.Mode.MULTIPLY;
                        } else if (i == R.drawable.obfuscated_res_0x7f08008b) {
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
                        } else if (i != R.drawable.obfuscated_res_0x7f080073) {
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
                    }
                });
            }
        }
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (AppCompatDrawableManager.class) {
            porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(i, mode);
        }
        return porterDuffColorFilter;
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i) {
        return this.mResourceManager.getDrawable(context, i);
    }

    public synchronized ColorStateList getTintList(@NonNull Context context, @DrawableRes int i) {
        return this.mResourceManager.getTintList(context, i);
    }

    public static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.tintDrawable(drawable, tintInfo, iArr);
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i, boolean z) {
        return this.mResourceManager.getDrawable(context, i, z);
    }

    public synchronized Drawable onDrawableLoadedFromResources(@NonNull Context context, @NonNull VectorEnabledTintResources vectorEnabledTintResources, @DrawableRes int i) {
        return this.mResourceManager.onDrawableLoadedFromResources(context, vectorEnabledTintResources, i);
    }

    public boolean tintDrawableUsingColorFilter(@NonNull Context context, @DrawableRes int i, @NonNull Drawable drawable) {
        return this.mResourceManager.tintDrawableUsingColorFilter(context, i, drawable);
    }

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        this.mResourceManager.onConfigurationChanged(context);
    }
}
