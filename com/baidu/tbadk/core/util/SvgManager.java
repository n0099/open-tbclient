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
import d.b.i0.c3.c;
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

        SvgResourceStateType(boolean z, boolean z2, int i) {
            this.canPress = z;
            this.canDisable = z2;
            this.stateCount = i;
        }

        public ColorStateList getColorListByResourceType(@ColorInt int i) {
            int i2;
            int i3 = this.stateCount;
            int[] iArr = new int[i3];
            int[][] iArr2 = new int[i3];
            if (this.canPress) {
                iArr[0] = c.a(i, SkinManager.RESOURCE_ALPHA_PRESS);
                iArr2[0] = new int[]{16842919, 16842910};
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (this.canDisable) {
                iArr[i2] = i;
                int[] iArr3 = new int[1];
                iArr3[0] = 16842910;
                iArr2[i2] = iArr3;
                int i4 = i2 + 1;
                iArr[i4] = c.a(i, SkinManager.RESOURCE_ALPHA_DISABLE);
                iArr2[i4] = new int[0];
            } else {
                iArr[i2] = i;
                iArr2[i2] = new int[0];
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
        public AnimatedVectorDrawableCompat getAnimatedDrawable(int i) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat;
            Drawable.ConstantState constantState = this.mVectorCache.get(Integer.valueOf(i));
            if (constantState == null) {
                try {
                    animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(TbadkCoreApplication.getInst(), i);
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
                        this.mVectorCache.put(Integer.valueOf(i), constantState);
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
        public StateListDrawable getStateListDrawable(int i, @NonNull Resources resources) {
            StateListDrawable stateListDrawable;
            Drawable.ConstantState constantState = this.mVectorCache.get(Integer.valueOf(i));
            if (constantState == null) {
                try {
                    stateListDrawable = (StateListDrawable) ResourcesCompat.getDrawable(resources, i, null);
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
                        this.mVectorCache.put(Integer.valueOf(i), constantState);
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
        public VectorDrawableCompat getVectorDrawable(int i) {
            VectorDrawableCompat vectorDrawableCompat;
            Drawable.ConstantState constantState = this.mVectorCache.get(Integer.valueOf(i));
            if (constantState == null) {
                try {
                    vectorDrawableCompat = VectorDrawableCompat.create(TbadkCoreApplication.getInst().getResources(), i, null);
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
                        this.mVectorCache.put(Integer.valueOf(i), constantState);
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

    private Drawable getDrawableWithDayNightMask(int i) {
        Drawable drawable;
        if (i == 0 || (drawable = getDrawable(i, 1, false)) == null) {
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
    public Drawable getDrawable(int i, int i2, boolean z) {
        int i3;
        if (i == 0) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        try {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
            if (z) {
                if (skinType == 1) {
                    i3 = SkinManager.getNightResouceId(this.mResources, i);
                } else if (skinType == 4) {
                    i3 = SkinManager.getDarkResourceId(this.mResources, i);
                }
                if (i3 == 0) {
                    i3 = i;
                }
                if (i2 != 1) {
                    VectorDrawableCompat vectorDrawable = this.mVectorDrawableCache.getVectorDrawable(i3);
                    if (vectorDrawable == null) {
                        Resources resources = this.mResources;
                        return SkinManager.getDrawable(skinType, resources, SkinManager.getVectorToDefaultResId(resources, i));
                    }
                    return vectorDrawable;
                } else if (i2 == 2) {
                    AnimatedVectorDrawableCompat animatedDrawable = this.mVectorDrawableCache.getAnimatedDrawable(i3);
                    if (animatedDrawable == null) {
                        Resources resources2 = this.mResources;
                        return SkinManager.getDrawable(skinType, resources2, SkinManager.getVectorToDefaultResId(resources2, i));
                    }
                    return animatedDrawable;
                } else if (i2 != 3) {
                    return null;
                } else {
                    StateListDrawable stateListDrawable = this.mVectorDrawableCache.getStateListDrawable(i3, this.mResources);
                    if (stateListDrawable == null) {
                        Resources resources3 = this.mResources;
                        return SkinManager.getDrawable(skinType, resources3, SkinManager.getVectorToDefaultResId(resources3, i));
                    }
                    return stateListDrawable;
                }
            }
            i3 = i;
            if (i3 == 0) {
            }
            if (i2 != 1) {
            }
        } catch (Exception unused) {
            Resources resources4 = this.mResources;
            return SkinManager.getDrawable(skinType, resources4, SkinManager.getVectorToDefaultResId(resources4, i));
        }
    }

    public Drawable getMaskDrawable(int i, SvgResourceStateType svgResourceStateType) {
        Drawable drawableWithDayNightMask;
        Drawable drawableWithDayNightMask2;
        if (i == 0) {
            return null;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (svgResourceStateType.canDisable && (drawableWithDayNightMask2 = getDrawableWithDayNightMask(i)) != null) {
            drawableWithDayNightMask2.setAlpha((int) (SkinManager.RESOURCE_ALPHA_DISABLE * 255.0f));
            stateListDrawable.addState(new int[]{-16842910}, drawableWithDayNightMask2);
        }
        if (svgResourceStateType.canPress && (drawableWithDayNightMask = getDrawableWithDayNightMask(i)) != null) {
            drawableWithDayNightMask.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
            stateListDrawable.addState(new int[]{16842919}, drawableWithDayNightMask);
        }
        Drawable drawableWithDayNightMask3 = getDrawableWithDayNightMask(i);
        if (drawableWithDayNightMask3 != null) {
            stateListDrawable.addState(new int[0], drawableWithDayNightMask3);
            return stateListDrawable;
        }
        return null;
    }

    public Drawable getNormalDrawable(int i, SvgResourceStateType svgResourceStateType) {
        Drawable drawable;
        Drawable drawable2;
        if (i == 0) {
            return null;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (svgResourceStateType.canDisable && (drawable2 = getDrawable(i, 1, true)) != null) {
            drawable2.setAlpha((int) (SkinManager.RESOURCE_ALPHA_DISABLE * 255.0f));
            stateListDrawable.addState(new int[]{-16842910}, drawable2);
        }
        if (svgResourceStateType.canPress && (drawable = getDrawable(i, 1, true)) != null) {
            drawable.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
            stateListDrawable.addState(new int[]{16842919}, drawable);
        }
        Drawable drawable3 = getDrawable(i, 1, true);
        if (drawable3 != null) {
            stateListDrawable.addState(new int[0], drawable3);
            return stateListDrawable;
        }
        return null;
    }

    public Drawable getPureDrawable(int i, @ColorRes int i2, SvgResourceStateType svgResourceStateType) {
        return getPureDrawable(i, i2, svgResourceStateType, true);
    }

    public Drawable getPureDrawableColorInt(int i, @ColorInt int i2, SvgResourceStateType svgResourceStateType) {
        ColorStateList colorListByResourceType;
        if (i == 0 || i2 == 0) {
            return null;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        Drawable drawable = getDrawable(i, 1, false);
        if (drawable == null || (colorListByResourceType = svgResourceStateType.getColorListByResourceType(i2)) == null) {
            return null;
        }
        Drawable mutate = drawable.mutate();
        DrawableCompat.setTintList(mutate, colorListByResourceType);
        return mutate;
    }

    public Drawable getPureDrawableWithColorValue(int i, @ColorInt int i2, SvgResourceStateType svgResourceStateType) {
        ColorStateList colorListByResourceType;
        if (i == 0 || i2 == 0) {
            return null;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        Drawable drawable = getDrawable(i, 1, false);
        if (drawable == null || (colorListByResourceType = svgResourceStateType.getColorListByResourceType(i2)) == null) {
            return null;
        }
        Drawable mutate = drawable.mutate();
        DrawableCompat.setTintList(mutate, colorListByResourceType);
        return mutate;
    }

    public Drawable getSeletableDrawableForEditorTools(int i, int i2, int i3) {
        Drawable drawableWithDayNightMask;
        if (i <= 0) {
            return null;
        }
        int i4 = R.color.CAM_X0105;
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = getDrawable(i, 1, false);
        if (drawable == null) {
            return null;
        }
        Drawable mutate = getDrawable(i, 1, false).mutate();
        DrawableCompat.setTint(mutate, c.a(SkinManager.getColor(i3, i4), SkinManager.RESOURCE_ALPHA_DISABLE));
        stateListDrawable.addState(new int[]{-16842910}, mutate);
        if (i2 > 0 && (drawableWithDayNightMask = getDrawableWithDayNightMask(i2)) != null) {
            Drawable mutate2 = getDrawableWithDayNightMask(i2).mutate();
            mutate2.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
            stateListDrawable.addState(new int[]{16842913, 16842919}, mutate2);
            stateListDrawable.addState(new int[]{16842913}, drawableWithDayNightMask);
        }
        Drawable mutate3 = getDrawable(i, 1, false).mutate();
        DrawableCompat.setTint(mutate3, c.a(SkinManager.getColor(i3, i4), SkinManager.RESOURCE_ALPHA_PRESS));
        stateListDrawable.addState(new int[]{16842919}, mutate3);
        DrawableCompat.setTint(drawable.mutate(), SkinManager.getColor(i3, i4));
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public void setDrawableWithTintList(ImageView imageView, int i, int i2) {
        Drawable drawable;
        ColorStateList colorList;
        if (imageView == null || i == 0 || i2 == 0 || (drawable = getDrawable(i, 1, true)) == null || (colorList = SkinManager.getColorList(i2)) == null) {
            return;
        }
        DrawableCompat.setTintList(drawable, colorList);
        imageView.setImageDrawable(drawable);
    }

    public void setMaskDrawableWithDayNightModeAutoChange(@NonNull ImageView imageView, int i, SvgResourceStateType svgResourceStateType) {
        if (i == 0 || imageView == null) {
            return;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        imageView.setImageDrawable(getMaskDrawable(i, svgResourceStateType));
    }

    public void setPureDrawableWithDayNightModeAutoChange(@NonNull ImageView imageView, int i, @ColorRes int i2, SvgResourceStateType svgResourceStateType) {
        if (i == 0 || i2 == 0 || imageView == null) {
            return;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        imageView.setImageDrawable(getPureDrawable(i, i2, svgResourceStateType));
    }

    public SvgManager() {
        this.mVectorDrawableCache = new VectorDrawableCache();
        try {
            this.mResources = (Resources) Class.forName("androidx.appcompat.widget.VectorEnabledTintResources").getDeclaredConstructor(Context.class, Resources.class).newInstance(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources());
        } catch (Exception unused) {
            this.mResources = TbadkCoreApplication.getInst().getResources();
        }
    }

    public Drawable getPureDrawable(int i, @ColorRes int i2, SvgResourceStateType svgResourceStateType, boolean z) {
        if (i == 0 || i2 == 0) {
            return null;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        Drawable drawable = getDrawable(i, 1, false);
        if (drawable == null) {
            return null;
        }
        ColorStateList colorListByResourceType = svgResourceStateType.getColorListByResourceType(z ? SkinManager.getColor(i2) : TbadkCoreApplication.getInst().getResources().getColor(i2));
        if (colorListByResourceType == null) {
            return null;
        }
        Drawable mutate = drawable.mutate();
        DrawableCompat.setTintList(mutate, colorListByResourceType);
        return mutate;
    }
}
