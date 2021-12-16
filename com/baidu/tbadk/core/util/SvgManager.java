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
import androidx.core.view.InputDeviceCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import c.a.s0.v3.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SvgManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DRAWABLE_TYPE_ANIMATED_VECTOR_DRAWABLE = 2;
    public static final int DRAWABLE_TYPE_STATE_LIST = 3;
    public static final int DRAWABLE_TYPE_VECTOR = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Resources mResources;
    public VectorDrawableCache mVectorDrawableCache;

    /* renamed from: com.baidu.tbadk.core.util.SvgManager$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static class InstanceHolder {
        public static /* synthetic */ Interceptable $ic;
        public static SvgManager SvgManagerInstance;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1565044351, "Lcom/baidu/tbadk/core/util/SvgManager$InstanceHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1565044351, "Lcom/baidu/tbadk/core/util/SvgManager$InstanceHolder;");
                    return;
                }
            }
            SvgManagerInstance = new SvgManager(null);
        }

        public InstanceHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class SvgResourceStateType {
        public static final /* synthetic */ SvgResourceStateType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SvgResourceStateType NORMAL;
        public static final SvgResourceStateType NORMAL_DISABLE;
        public static final SvgResourceStateType NORMAL_PRESS;
        public static final SvgResourceStateType NORMAL_PRESS_DISABLE;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean canDisable;
        public boolean canPress;
        public int stateCount;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1197137049, "Lcom/baidu/tbadk/core/util/SvgManager$SvgResourceStateType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1197137049, "Lcom/baidu/tbadk/core/util/SvgManager$SvgResourceStateType;");
                    return;
                }
            }
            NORMAL = new SvgResourceStateType("NORMAL", 0, false, false, 1);
            NORMAL_PRESS = new SvgResourceStateType("NORMAL_PRESS", 1, true, false, 2);
            NORMAL_PRESS_DISABLE = new SvgResourceStateType("NORMAL_PRESS_DISABLE", 2, true, true, 3);
            SvgResourceStateType svgResourceStateType = new SvgResourceStateType("NORMAL_DISABLE", 3, false, true, 2);
            NORMAL_DISABLE = svgResourceStateType;
            $VALUES = new SvgResourceStateType[]{NORMAL, NORMAL_PRESS, NORMAL_PRESS_DISABLE, svgResourceStateType};
        }

        public SvgResourceStateType(String str, int i2, boolean z, boolean z2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.canPress = z;
            this.canDisable = z2;
            this.stateCount = i3;
        }

        public static SvgResourceStateType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (SvgResourceStateType) Enum.valueOf(SvgResourceStateType.class, str) : (SvgResourceStateType) invokeL.objValue;
        }

        public static SvgResourceStateType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (SvgResourceStateType[]) $VALUES.clone() : (SvgResourceStateType[]) invokeV.objValue;
        }

        public ColorStateList getColorListByResourceType(@ColorInt int i2) {
            InterceptResult invokeI;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
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
            return (ColorStateList) invokeI.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class VectorDrawableCache {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int COUNT_OF_CACHED_SVG_ICON = 50;
        public transient /* synthetic */ FieldHolder $fh;
        public LruCache<Integer, Drawable.ConstantState> mVectorCache;

        public VectorDrawableCache() {
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
            this.mVectorCache = new LruCache<>(50);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0047 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0048 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AnimatedVectorDrawableCompat getAnimatedDrawable(int i2) {
            InterceptResult invokeI;
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
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
            return (AnimatedVectorDrawableCompat) invokeI.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0041 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0042 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public StateListDrawable getStateListDrawable(int i2, @NonNull Resources resources) {
            InterceptResult invokeIL;
            StateListDrawable stateListDrawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, resources)) == null) {
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
            return (StateListDrawable) invokeIL.objValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x004a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x004b A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public VectorDrawableCompat getVectorDrawable(int i2) {
            InterceptResult invokeI;
            VectorDrawableCompat vectorDrawableCompat;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
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
            return (VectorDrawableCompat) invokeI.objValue;
        }
    }

    public /* synthetic */ SvgManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    private Drawable getDrawableWithDayNightMask(int i2) {
        InterceptResult invokeI;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
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
        return (Drawable) invokeI.objValue;
    }

    public static synchronized SvgManager getInstance() {
        InterceptResult invokeV;
        SvgManager svgManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (SvgManager.class) {
                svgManager = InstanceHolder.SvgManagerInstance;
            }
            return svgManager;
        }
        return (SvgManager) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Drawable getDrawable(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) != null) {
            return (Drawable) invokeCommon.objValue;
        }
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
        InterceptResult invokeIL;
        Drawable drawableWithDayNightMask;
        Drawable drawableWithDayNightMask2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, svgResourceStateType)) == null) {
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
        return (Drawable) invokeIL.objValue;
    }

    public Drawable getNormalDrawable(int i2, SvgResourceStateType svgResourceStateType) {
        InterceptResult invokeIL;
        Drawable drawable;
        Drawable drawable2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, svgResourceStateType)) == null) {
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
        return (Drawable) invokeIL.objValue;
    }

    public Drawable getPureDrawable(int i2, @ColorRes int i3, SvgResourceStateType svgResourceStateType) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048579, this, i2, i3, svgResourceStateType)) == null) ? getPureDrawable(i2, i3, svgResourceStateType, true) : (Drawable) invokeIIL.objValue;
    }

    public Drawable getPureDrawableColorInt(int i2, @ColorInt int i3, SvgResourceStateType svgResourceStateType) {
        InterceptResult invokeIIL;
        ColorStateList colorListByResourceType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048581, this, i2, i3, svgResourceStateType)) == null) {
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
        return (Drawable) invokeIIL.objValue;
    }

    public Drawable getPureDrawableWithColorValue(int i2, @ColorInt int i3, SvgResourceStateType svgResourceStateType) {
        InterceptResult invokeIIL;
        ColorStateList colorListByResourceType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048582, this, i2, i3, svgResourceStateType)) == null) {
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
        return (Drawable) invokeIIL.objValue;
    }

    public Drawable getSeletableDrawableForEditorTools(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Drawable drawableWithDayNightMask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048583, this, i2, i3, i4)) == null) {
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
        return (Drawable) invokeIII.objValue;
    }

    public void setDrawableWithTintList(ImageView imageView, int i2, int i3) {
        Drawable drawable;
        ColorStateList colorList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, imageView, i2, i3) == null) || imageView == null || i2 == 0 || i3 == 0 || (drawable = getDrawable(i2, 1, true)) == null || (colorList = SkinManager.getColorList(i3)) == null) {
            return;
        }
        DrawableCompat.setTintList(drawable, colorList);
        imageView.setImageDrawable(drawable);
    }

    public void setMaskDrawableWithDayNightModeAutoChange(@NonNull ImageView imageView, int i2, SvgResourceStateType svgResourceStateType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048585, this, imageView, i2, svgResourceStateType) == null) || i2 == 0 || imageView == null) {
            return;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        imageView.setImageDrawable(getMaskDrawable(i2, svgResourceStateType));
    }

    public void setPureDrawableWithDayNightModeAutoChange(@NonNull ImageView imageView, int i2, @ColorRes int i3, SvgResourceStateType svgResourceStateType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), svgResourceStateType}) == null) || i2 == 0 || i3 == 0 || imageView == null) {
            return;
        }
        if (svgResourceStateType == null) {
            svgResourceStateType = SvgResourceStateType.NORMAL;
        }
        imageView.setImageDrawable(getPureDrawable(i2, i3, svgResourceStateType));
    }

    public SvgManager() {
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
        this.mVectorDrawableCache = new VectorDrawableCache();
        try {
            this.mResources = (Resources) Class.forName("androidx.appcompat.widget.VectorEnabledTintResources").getDeclaredConstructor(Context.class, Resources.class).newInstance(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources());
        } catch (Exception unused) {
            this.mResources = TbadkCoreApplication.getInst().getResources();
        }
    }

    public Drawable getPureDrawable(int i2, @ColorRes int i3, SvgResourceStateType svgResourceStateType, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), svgResourceStateType, Boolean.valueOf(z)})) == null) {
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
        return (Drawable) invokeCommon.objValue;
    }
}
