package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatDelegate;
import android.util.LruCache;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class SvgManager {
    private b elb;
    private Resources mResources;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        static SvgManager elc = new SvgManager();
    }

    /* loaded from: classes2.dex */
    public enum SvgResourceStateType {
        NORMAL(false, false, 1),
        NORMAL_PRESS(true, false, 2),
        NORMAL_PRESS_DISABLE(true, true, 3),
        NORMAL_DISABLE(false, true, 2);
        
        private boolean canDisable;
        private boolean canPress;
        private int stateCount;

        SvgResourceStateType(boolean z, boolean z2, int i) {
            this.canPress = z;
            this.canDisable = z2;
            this.stateCount = i;
        }

        public ColorStateList getColorListByResourceType(@ColorInt int i) {
            int i2;
            int[] iArr = new int[this.stateCount];
            int[][] iArr2 = new int[this.stateCount];
            if (this.canDisable) {
                iArr[0] = com.baidu.tieba.tbadkCore.c.l(i, 0.3f);
                int[] iArr3 = new int[1];
                iArr3[0] = -16842910;
                iArr2[0] = iArr3;
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (this.canPress) {
                iArr[i2] = com.baidu.tieba.tbadkCore.c.l(i, 0.5f);
                int[] iArr4 = new int[1];
                iArr4[0] = 16842919;
                iArr2[i2] = iArr4;
                i2++;
            }
            iArr[i2] = i;
            iArr2[i2] = new int[0];
            return new ColorStateList(iArr2, iArr);
        }
    }

    private SvgManager() {
        this.elb = new b();
        try {
            this.mResources = (Resources) Class.forName("android.support.v7.widget.VectorEnabledTintResources").getDeclaredConstructor(Context.class, Resources.class).newInstance(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources());
        } catch (Exception e) {
            this.mResources = TbadkCoreApplication.getInst().getResources();
        }
    }

    public static synchronized SvgManager bjq() {
        SvgManager svgManager;
        synchronized (SvgManager.class) {
            svgManager = a.elc;
        }
        return svgManager;
    }

    public void a(@NonNull ImageView imageView, int i, @ColorRes int i2, SvgResourceStateType svgResourceStateType) {
        if (i != 0 && i2 != 0 && imageView != null) {
            if (svgResourceStateType == null) {
                svgResourceStateType = SvgResourceStateType.NORMAL;
            }
            imageView.setImageDrawable(a(i, i2, svgResourceStateType));
        }
    }

    public void a(@NonNull ImageView imageView, int i, SvgResourceStateType svgResourceStateType) {
        if (i != 0 && imageView != null) {
            if (svgResourceStateType == null) {
                svgResourceStateType = SvgResourceStateType.NORMAL;
            }
            imageView.setImageDrawable(a(i, svgResourceStateType));
        }
    }

    public Drawable a(int i, @ColorRes int i2, SvgResourceStateType svgResourceStateType) {
        return a(i, i2, svgResourceStateType, true);
    }

    public Drawable a(int i, @ColorRes int i2, SvgResourceStateType svgResourceStateType, boolean z) {
        if (i == 0 || i2 == 0) {
            return null;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        Drawable i3 = i(i, 1, false);
        if (i3 == null) {
            return null;
        }
        ColorStateList colorListByResourceType = svgResourceStateType.getColorListByResourceType(z ? ap.getColor(i2) : TbadkCoreApplication.getInst().getResources().getColor(i2));
        if (colorListByResourceType == null) {
            return null;
        }
        Drawable mutate = i3.mutate();
        DrawableCompat.setTintList(mutate, colorListByResourceType);
        return mutate;
    }

    public Drawable b(int i, @ColorInt int i2, SvgResourceStateType svgResourceStateType) {
        ColorStateList colorListByResourceType;
        if (i == 0 || i2 == 0) {
            return null;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        Drawable i3 = i(i, 1, false);
        if (i3 == null || (colorListByResourceType = svgResourceStateType.getColorListByResourceType(i2)) == null) {
            return null;
        }
        Drawable mutate = i3.mutate();
        DrawableCompat.setTintList(mutate, colorListByResourceType);
        return mutate;
    }

    public Drawable c(int i, @ColorInt int i2, SvgResourceStateType svgResourceStateType) {
        ColorStateList colorListByResourceType;
        if (i == 0 || i2 == 0) {
            return null;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        Drawable i3 = i(i, 1, false);
        if (i3 == null || (colorListByResourceType = svgResourceStateType.getColorListByResourceType(i2)) == null) {
            return null;
        }
        Drawable mutate = i3.mutate();
        DrawableCompat.setTintList(mutate, colorListByResourceType);
        return mutate;
    }

    public Drawable a(int i, SvgResourceStateType svgResourceStateType) {
        Drawable nW;
        Drawable nW2;
        if (i == 0) {
            return null;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (svgResourceStateType.canDisable && (nW2 = nW(i)) != null) {
            nW2.setAlpha(76);
            stateListDrawable.addState(new int[]{-16842910}, nW2);
        }
        if (svgResourceStateType.canPress && (nW = nW(i)) != null) {
            nW.setAlpha(127);
            stateListDrawable.addState(new int[]{16842919}, nW);
        }
        Drawable nW3 = nW(i);
        if (nW3 != null) {
            stateListDrawable.addState(new int[0], nW3);
            return stateListDrawable;
        }
        return null;
    }

    public Drawable x(int i, int i2, int i3) {
        Drawable nW;
        if (i <= 0) {
            return null;
        }
        int i4 = R.color.cp_cont_b;
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable i5 = i(i, 1, false);
        if (i5 != null) {
            Drawable mutate = i(i, 1, false).mutate();
            DrawableCompat.setTint(mutate, com.baidu.tieba.tbadkCore.c.l(ap.getColor(i3, i4), 0.3f));
            stateListDrawable.addState(new int[]{-16842910}, mutate);
            if (i2 > 0 && (nW = nW(i2)) != null) {
                Drawable mutate2 = nW(i2).mutate();
                mutate2.setAlpha(127);
                stateListDrawable.addState(new int[]{16842913, 16842919}, mutate2);
                stateListDrawable.addState(new int[]{16842913}, nW);
            }
            Drawable mutate3 = i(i, 1, false).mutate();
            DrawableCompat.setTint(mutate3, com.baidu.tieba.tbadkCore.c.l(ap.getColor(i3, i4), 0.5f));
            stateListDrawable.addState(new int[]{16842919}, mutate3);
            DrawableCompat.setTint(i5.mutate(), ap.getColor(i3, i4));
            stateListDrawable.addState(new int[0], i5);
            return stateListDrawable;
        }
        return null;
    }

    private Drawable nW(int i) {
        Drawable i2;
        Drawable drawable = null;
        if (i != 0 && (i2 = i(i, 1, false)) != null) {
            drawable = i2.mutate();
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1) {
                drawable.setColorFilter(ap.getColor(R.color.cp_mask_a), PorterDuff.Mode.SRC_ATOP);
            } else if (skinType == 4) {
                drawable.setColorFilter(ap.getColor(R.color.cp_mask_a), PorterDuff.Mode.SRC_ATOP);
            }
        }
        return drawable;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Drawable i(int i, int i2, boolean z) {
        int i3;
        if (i == 0) {
            return null;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        try {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
            if (z) {
                if (skinType == 1) {
                    i3 = ap.c(this.mResources, i);
                } else if (skinType == 4) {
                    i3 = ap.d(this.mResources, i);
                }
                if (i3 == 0) {
                    i3 = i;
                }
                switch (i2) {
                    case 1:
                        VectorDrawableCompat nX = this.elb.nX(i3);
                        if (nX == null) {
                            return ap.getDrawable(skinType, this.mResources, ap.getVectorToDefaultResId(this.mResources, i));
                        }
                        return nX;
                    case 2:
                        AnimatedVectorDrawableCompat nY = this.elb.nY(i3);
                        if (nY == null) {
                            return ap.getDrawable(skinType, this.mResources, ap.getVectorToDefaultResId(this.mResources, i));
                        }
                        return nY;
                    case 3:
                        StateListDrawable a2 = this.elb.a(i3, this.mResources);
                        if (a2 == null) {
                            return ap.getDrawable(skinType, this.mResources, ap.getVectorToDefaultResId(this.mResources, i));
                        }
                        return a2;
                    default:
                        return null;
                }
            }
            i3 = i;
            if (i3 == 0) {
            }
            switch (i2) {
            }
        } catch (Exception e) {
            return ap.getDrawable(skinType, this.mResources, ap.getVectorToDefaultResId(this.mResources, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        private LruCache<Integer, Drawable.ConstantState> eld = new LruCache<>(50);

        b() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public VectorDrawableCompat nX(int i) {
            Drawable.ConstantState constantState;
            Throwable th;
            VectorDrawableCompat vectorDrawableCompat;
            Drawable.ConstantState constantState2;
            Drawable.ConstantState constantState3 = this.eld.get(Integer.valueOf(i));
            if (constantState3 == null) {
                try {
                    VectorDrawableCompat create = VectorDrawableCompat.create(TbadkCoreApplication.getInst().getResources(), i, null);
                    if (create != null) {
                        try {
                            constantState2 = create.getConstantState();
                        } catch (Throwable th2) {
                            vectorDrawableCompat = create;
                            constantState = constantState3;
                            th = th2;
                            BdLog.e(th);
                            if (constantState != null) {
                            }
                            if (vectorDrawableCompat != null) {
                            }
                        }
                    } else {
                        constantState2 = constantState3;
                    }
                    if (constantState2 != null) {
                        try {
                            this.eld.put(Integer.valueOf(i), constantState2);
                        } catch (Throwable th3) {
                            th = th3;
                            constantState = constantState2;
                            vectorDrawableCompat = create;
                            BdLog.e(th);
                            if (constantState != null) {
                            }
                            if (vectorDrawableCompat != null) {
                            }
                        }
                    }
                    constantState = constantState2;
                    vectorDrawableCompat = create;
                } catch (Throwable th4) {
                    constantState = constantState3;
                    th = th4;
                    vectorDrawableCompat = null;
                }
            } else {
                vectorDrawableCompat = null;
                constantState = constantState3;
            }
            if (constantState != null) {
                Drawable newDrawable = constantState.newDrawable();
                if (newDrawable instanceof VectorDrawableCompat) {
                    return (VectorDrawableCompat) newDrawable;
                }
            }
            if (vectorDrawableCompat != null) {
                return vectorDrawableCompat;
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public StateListDrawable a(int i, @NonNull Resources resources) {
            StateListDrawable stateListDrawable;
            StateListDrawable stateListDrawable2;
            Drawable.ConstantState constantState = this.eld.get(Integer.valueOf(i));
            if (constantState == null) {
                try {
                    stateListDrawable2 = (StateListDrawable) ResourcesCompat.getDrawable(resources, i, null);
                    if (stateListDrawable2 != null) {
                        try {
                            constantState = stateListDrawable2.getConstantState();
                        } catch (Throwable th) {
                            th = th;
                            BdLog.e(th);
                            stateListDrawable = stateListDrawable2;
                            if (stateListDrawable != null) {
                            }
                        }
                    }
                    if (constantState != null) {
                        this.eld.put(Integer.valueOf(i), constantState);
                        Drawable newDrawable = constantState.newDrawable();
                        if (newDrawable instanceof StateListDrawable) {
                            return (StateListDrawable) newDrawable;
                        }
                    }
                    stateListDrawable = stateListDrawable2;
                } catch (Throwable th2) {
                    th = th2;
                    stateListDrawable2 = null;
                }
            } else {
                stateListDrawable = null;
            }
            if (stateListDrawable != null) {
                return null;
            }
            return stateListDrawable;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AnimatedVectorDrawableCompat nY(int i) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat;
            Drawable.ConstantState constantState = this.eld.get(Integer.valueOf(i));
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
                        this.eld.put(Integer.valueOf(i), constantState);
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
    }
}
