package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.LruCache;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.k0.d3.c;
/* loaded from: classes3.dex */
public class SvgManager {
    public static final int DRAWABLE_TYPE_ANIMATED_VECTOR_DRAWABLE = 2;
    public static final int DRAWABLE_TYPE_STATE_LIST = 3;
    public static final int DRAWABLE_TYPE_VECTOR = 1;
    public Resources mResources;
    public VectorDrawableCache mVectorDrawableCache;

    /* loaded from: classes3.dex */
    public static class InstanceHolder {
        public static SvgManager SvgManagerInstance = new SvgManager();
    }

    /* loaded from: classes3.dex */
    public enum SvgResourceStateType {
        NORMAL(false, false, 1),
        NORMAL_PRESS(true, false, 2),
        NORMAL_PRESS_DISABLE(true, true, 3),
        NORMAL_DISABLE(false, true, 2);
        
        public boolean canDisable;
        public boolean canPress;
        public int stateCount;

        SvgResourceStateType(boolean z, boolean z2, int i2) {
            this.canPress = z;
            this.canDisable = z2;
            this.stateCount = i2;
        }

        public ColorStateList getColorListByResourceType(@ColorInt int i2) {
            int i3;
            int i4 = this.stateCount;
            int[] iArr = new int[i4];
            int[][] iArr2 = new int[i4];
            if (this.canPress) {
                iArr[0] = c.a(i2, SkinManager.RESOURCE_ALPHA_PRESS);
                iArr2[0] = new int[]{16842919, 16842910};
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (this.canDisable) {
                iArr[i3] = i2;
                int[] iArr3 = new int[1];
                iArr3[0] = 16842910;
                iArr2[i3] = iArr3;
                int i5 = i3 + 1;
                iArr[i5] = c.a(i2, SkinManager.RESOURCE_ALPHA_DISABLE);
                iArr2[i5] = new int[0];
            } else {
                iArr[i3] = i2;
                iArr2[i3] = new int[0];
            }
            return new ColorStateList(iArr2, iArr);
        }
    }

    /* loaded from: classes3.dex */
    public static class VectorDrawableCache {
        public static final int COUNT_OF_CACHED_SVG_ICON = 50;
        public LruCache<Integer, Drawable.ConstantState> mVectorCache = new LruCache<>(50);

        /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0043 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AnimatedVectorDrawableCompat getAnimatedDrawable(int i2) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat;
            Drawable.ConstantState constantState = this.mVectorCache.get(Integer.valueOf(i2));
            if (constantState == null) {
                try {
                    animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(TbadkCoreApplication.getInst(), i2);
                    if (animatedVectorDrawableCompat != null) {
                        try {
                            constantState = animatedVectorDrawableCompat.getConstantState();
                        } catch (Throwable th) {
                            th = th;
                            BdLog.e(th);
                            constantState = null;
                            if (constantState != null) {
                            }
                            if (animatedVectorDrawableCompat == null) {
                            }
                        }
                    }
                    if (constantState != null) {
                        this.mVectorCache.put(Integer.valueOf(i2), constantState);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    animatedVectorDrawableCompat = null;
                }
            } else {
                animatedVectorDrawableCompat = null;
            }
            if (constantState != null) {
                Drawable newDrawable = constantState.newDrawable();
                if (newDrawable instanceof AnimatedVectorDrawableCompat) {
                    return (AnimatedVectorDrawableCompat) newDrawable;
                }
            }
            if (animatedVectorDrawableCompat == null) {
                return animatedVectorDrawableCompat;
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x003e A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public StateListDrawable getStateListDrawable(int i2, @NonNull Resources resources) {
            StateListDrawable stateListDrawable;
            Drawable.ConstantState constantState = this.mVectorCache.get(Integer.valueOf(i2));
            if (constantState == null) {
                try {
                    stateListDrawable = (StateListDrawable) ResourcesCompat.getDrawable(resources, i2, null);
                    if (stateListDrawable != null) {
                        try {
                            constantState = stateListDrawable.getConstantState();
                        } catch (Throwable th) {
                            th = th;
                            BdLog.e(th);
                            if (stateListDrawable == null) {
                            }
                        }
                    }
                    if (constantState != null) {
                        this.mVectorCache.put(Integer.valueOf(i2), constantState);
                        Drawable newDrawable = constantState.newDrawable();
                        if (newDrawable instanceof StateListDrawable) {
                            return (StateListDrawable) newDrawable;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    stateListDrawable = null;
                }
            } else {
                stateListDrawable = null;
            }
            if (stateListDrawable == null) {
                return stateListDrawable;
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0046 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0047 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public VectorDrawableCompat getVectorDrawable(int i2) {
            VectorDrawableCompat vectorDrawableCompat;
            Drawable.ConstantState constantState = this.mVectorCache.get(Integer.valueOf(i2));
            if (constantState == null) {
                try {
                    vectorDrawableCompat = VectorDrawableCompat.create(TbadkCoreApplication.getInst().getResources(), i2, null);
                    if (vectorDrawableCompat != null) {
                        try {
                            constantState = vectorDrawableCompat.getConstantState();
                        } catch (Throwable th) {
                            th = th;
                            BdLog.e(th);
                            if (constantState != null) {
                            }
                            if (vectorDrawableCompat == null) {
                            }
                        }
                    }
                    if (constantState != null) {
                        this.mVectorCache.put(Integer.valueOf(i2), constantState);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    vectorDrawableCompat = null;
                }
            } else {
                vectorDrawableCompat = null;
            }
            if (constantState != null) {
                Drawable newDrawable = constantState.newDrawable();
                if (newDrawable instanceof VectorDrawableCompat) {
                    return (VectorDrawableCompat) newDrawable;
                }
            }
            if (vectorDrawableCompat == null) {
                return vectorDrawableCompat;
            }
            return null;
        }
    }

    private Drawable getDrawableWithDayNightMask(int i2) {
        Drawable drawable;
        if (i2 == 0 || (drawable = getDrawable(i2, 1, false)) == null) {
            return null;
        }
        Drawable mutate = drawable.mutate();
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 1) {
            mutate.setColorFilter(SkinManager.getColor(R.color.CAM_X0501), PorterDuff.Mode.SRC_ATOP);
        } else if (skinType == 4) {
            mutate.setColorFilter(SkinManager.getColor(R.color.CAM_X0501), PorterDuff.Mode.SRC_ATOP);
        }
        return mutate;
    }

    public static synchronized SvgManager getInstance() {
        SvgManager svgManager;
        synchronized (SvgManager.class) {
            svgManager = InstanceHolder.SvgManagerInstance;
        }
        return svgManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Drawable getDrawable(int i2, int i3, boolean z) {
        int i4;
        if (i2 == 0) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        try {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
            if (z) {
                if (skinType == 1) {
                    i4 = SkinManager.getNightResouceId(this.mResources, i2);
                } else if (skinType == 4) {
                    i4 = SkinManager.getDarkResourceId(this.mResources, i2);
                }
                if (i4 == 0) {
                    i4 = i2;
                }
                if (i3 != 1) {
                    VectorDrawableCompat vectorDrawable = this.mVectorDrawableCache.getVectorDrawable(i4);
                    if (vectorDrawable == null) {
                        Resources resources = this.mResources;
                        return SkinManager.getDrawable(skinType, resources, SkinManager.getVectorToDefaultResId(resources, i2));
                    }
                    return vectorDrawable;
                } else if (i3 == 2) {
                    AnimatedVectorDrawableCompat animatedDrawable = this.mVectorDrawableCache.getAnimatedDrawable(i4);
                    if (animatedDrawable == null) {
                        Resources resources2 = this.mResources;
                        return SkinManager.getDrawable(skinType, resources2, SkinManager.getVectorToDefaultResId(resources2, i2));
                    }
                    return animatedDrawable;
                } else if (i3 != 3) {
                    return null;
                } else {
                    StateListDrawable stateListDrawable = this.mVectorDrawableCache.getStateListDrawable(i4, this.mResources);
                    if (stateListDrawable == null) {
                        Resources resources3 = this.mResources;
                        return SkinManager.getDrawable(skinType, resources3, SkinManager.getVectorToDefaultResId(resources3, i2));
                    }
                    return stateListDrawable;
                }
            }
            i4 = i2;
            if (i4 == 0) {
            }
            if (i3 != 1) {
            }
        } catch (Exception unused) {
            Resources resources4 = this.mResources;
            return SkinManager.getDrawable(skinType, resources4, SkinManager.getVectorToDefaultResId(resources4, i2));
        }
    }

    public Drawable getMaskDrawable(int i2, SvgResourceStateType svgResourceStateType) {
        Drawable drawableWithDayNightMask;
        Drawable drawableWithDayNightMask2;
        if (i2 == 0) {
            return null;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (svgResourceStateType.canDisable && (drawableWithDayNightMask2 = getDrawableWithDayNightMask(i2)) != null) {
            drawableWithDayNightMask2.setAlpha((int) (SkinManager.RESOURCE_ALPHA_DISABLE * 255.0f));
            stateListDrawable.addState(new int[]{-16842910}, drawableWithDayNightMask2);
        }
        if (svgResourceStateType.canPress && (drawableWithDayNightMask = getDrawableWithDayNightMask(i2)) != null) {
            drawableWithDayNightMask.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
            stateListDrawable.addState(new int[]{16842919}, drawableWithDayNightMask);
        }
        Drawable drawableWithDayNightMask3 = getDrawableWithDayNightMask(i2);
        if (drawableWithDayNightMask3 != null) {
            stateListDrawable.addState(new int[0], drawableWithDayNightMask3);
            return stateListDrawable;
        }
        return null;
    }

    public Drawable getNormalDrawable(int i2, SvgResourceStateType svgResourceStateType) {
        Drawable drawable;
        Drawable drawable2;
        if (i2 == 0) {
            return null;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (svgResourceStateType.canDisable && (drawable2 = getDrawable(i2, 1, true)) != null) {
            drawable2.setAlpha((int) (SkinManager.RESOURCE_ALPHA_DISABLE * 255.0f));
            stateListDrawable.addState(new int[]{-16842910}, drawable2);
        }
        if (svgResourceStateType.canPress && (drawable = getDrawable(i2, 1, true)) != null) {
            drawable.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
            stateListDrawable.addState(new int[]{16842919}, drawable);
        }
        Drawable drawable3 = getDrawable(i2, 1, true);
        if (drawable3 != null) {
            stateListDrawable.addState(new int[0], drawable3);
            return stateListDrawable;
        }
        return null;
    }

    public Drawable getPureDrawable(int i2, @ColorRes int i3, SvgResourceStateType svgResourceStateType) {
        return getPureDrawable(i2, i3, svgResourceStateType, true);
    }

    public Drawable getPureDrawableColorInt(int i2, @ColorInt int i3, SvgResourceStateType svgResourceStateType) {
        ColorStateList colorListByResourceType;
        if (i2 == 0 || i3 == 0) {
            return null;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        Drawable drawable = getDrawable(i2, 1, false);
        if (drawable == null || (colorListByResourceType = svgResourceStateType.getColorListByResourceType(i3)) == null) {
            return null;
        }
        Drawable mutate = drawable.mutate();
        DrawableCompat.setTintList(mutate, colorListByResourceType);
        return mutate;
    }

    public Drawable getPureDrawableWithColorValue(int i2, @ColorInt int i3, SvgResourceStateType svgResourceStateType) {
        ColorStateList colorListByResourceType;
        if (i2 == 0 || i3 == 0) {
            return null;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        Drawable drawable = getDrawable(i2, 1, false);
        if (drawable == null || (colorListByResourceType = svgResourceStateType.getColorListByResourceType(i3)) == null) {
            return null;
        }
        Drawable mutate = drawable.mutate();
        DrawableCompat.setTintList(mutate, colorListByResourceType);
        return mutate;
    }

    public Drawable getSeletableDrawableForEditorTools(int i2, int i3, int i4) {
        Drawable drawableWithDayNightMask;
        if (i2 <= 0) {
            return null;
        }
        int i5 = R.color.CAM_X0105;
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = getDrawable(i2, 1, false);
        if (drawable == null) {
            return null;
        }
        Drawable mutate = getDrawable(i2, 1, false).mutate();
        DrawableCompat.setTint(mutate, c.a(SkinManager.getColor(i4, i5), SkinManager.RESOURCE_ALPHA_DISABLE));
        stateListDrawable.addState(new int[]{-16842910}, mutate);
        if (i3 > 0 && (drawableWithDayNightMask = getDrawableWithDayNightMask(i3)) != null) {
            Drawable mutate2 = getDrawableWithDayNightMask(i3).mutate();
            mutate2.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
            stateListDrawable.addState(new int[]{16842913, 16842919}, mutate2);
            stateListDrawable.addState(new int[]{16842913}, drawableWithDayNightMask);
        }
        Drawable mutate3 = getDrawable(i2, 1, false).mutate();
        DrawableCompat.setTint(mutate3, c.a(SkinManager.getColor(i4, i5), SkinManager.RESOURCE_ALPHA_PRESS));
        stateListDrawable.addState(new int[]{16842919}, mutate3);
        DrawableCompat.setTint(drawable.mutate(), SkinManager.getColor(i4, i5));
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public void setDrawableWithTintList(ImageView imageView, int i2, int i3) {
        Drawable drawable;
        ColorStateList colorList;
        if (imageView == null || i2 == 0 || i3 == 0 || (drawable = getDrawable(i2, 1, true)) == null || (colorList = SkinManager.getColorList(i3)) == null) {
            return;
        }
        DrawableCompat.setTintList(drawable, colorList);
        imageView.setImageDrawable(drawable);
    }

    public void setMaskDrawableWithDayNightModeAutoChange(@NonNull ImageView imageView, int i2, SvgResourceStateType svgResourceStateType) {
        if (i2 == 0 || imageView == null) {
            return;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        imageView.setImageDrawable(getMaskDrawable(i2, svgResourceStateType));
    }

    public void setPureDrawableWithDayNightModeAutoChange(@NonNull ImageView imageView, int i2, @ColorRes int i3, SvgResourceStateType svgResourceStateType) {
        if (i2 == 0 || i3 == 0 || imageView == null) {
            return;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        imageView.setImageDrawable(getPureDrawable(i2, i3, svgResourceStateType));
    }

    public SvgManager() {
        this.mVectorDrawableCache = new VectorDrawableCache();
        try {
            this.mResources = (Resources) Class.forName("androidx.appcompat.widget.VectorEnabledTintResources").getDeclaredConstructor(Context.class, Resources.class).newInstance(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources());
        } catch (Exception unused) {
            this.mResources = TbadkCoreApplication.getInst().getResources();
        }
    }

    public Drawable getPureDrawable(int i2, @ColorRes int i3, SvgResourceStateType svgResourceStateType, boolean z) {
        if (i2 == 0 || i3 == 0) {
            return null;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        Drawable drawable = getDrawable(i2, 1, false);
        if (drawable == null) {
            return null;
        }
        ColorStateList colorListByResourceType = svgResourceStateType.getColorListByResourceType(z ? SkinManager.getColor(i3) : TbadkCoreApplication.getInst().getResources().getColor(i3));
        if (colorListByResourceType == null) {
            return null;
        }
        Drawable mutate = drawable.mutate();
        DrawableCompat.setTintList(mutate, colorListByResourceType);
        return mutate;
    }
}
