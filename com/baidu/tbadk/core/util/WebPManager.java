package com.baidu.tbadk.core.util;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.h3.c;
/* loaded from: classes4.dex */
public class WebPManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class ResourceStateType {
        public static final /* synthetic */ ResourceStateType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ResourceStateType NORMAL;
        public static final ResourceStateType NORMAL_DISABLE;
        public static final ResourceStateType NORMAL_PRESS;
        public static final ResourceStateType NORMAL_PRESS_DISABLE;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean canDisable;
        public boolean canPress;
        public int stateCount;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1832564015, "Lcom/baidu/tbadk/core/util/WebPManager$ResourceStateType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1832564015, "Lcom/baidu/tbadk/core/util/WebPManager$ResourceStateType;");
                    return;
                }
            }
            NORMAL = new ResourceStateType("NORMAL", 0, false, false, 1);
            NORMAL_PRESS = new ResourceStateType("NORMAL_PRESS", 1, true, false, 2);
            NORMAL_PRESS_DISABLE = new ResourceStateType("NORMAL_PRESS_DISABLE", 2, true, true, 3);
            ResourceStateType resourceStateType = new ResourceStateType("NORMAL_DISABLE", 3, false, true, 2);
            NORMAL_DISABLE = resourceStateType;
            $VALUES = new ResourceStateType[]{NORMAL, NORMAL_PRESS, NORMAL_PRESS_DISABLE, resourceStateType};
        }

        public ResourceStateType(String str, int i2, boolean z, boolean z2, int i3) {
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

        public static ResourceStateType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? (ResourceStateType) Enum.valueOf(ResourceStateType.class, str) : (ResourceStateType) invokeL.objValue;
        }

        public static ResourceStateType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? (ResourceStateType[]) $VALUES.clone() : (ResourceStateType[]) invokeV.objValue;
        }
    }

    public WebPManager() {
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

    public static ColorStateList getColorListByResourceType(@ColorInt int i2, ResourceStateType resourceStateType) {
        InterceptResult invokeIL;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, resourceStateType)) == null) {
            if (resourceStateType == null) {
                resourceStateType = ResourceStateType.NORMAL;
            }
            int[] iArr = new int[resourceStateType.stateCount];
            int[][] iArr2 = new int[resourceStateType.stateCount];
            if (resourceStateType.canPress) {
                iArr[0] = c.a(i2, SkinManager.RESOURCE_ALPHA_PRESS);
                iArr2[0] = new int[]{16842919, 16842910};
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (resourceStateType.canDisable) {
                iArr[i3] = i2;
                int[] iArr3 = new int[1];
                iArr3[0] = 16842910;
                iArr2[i3] = iArr3;
                int i4 = i3 + 1;
                iArr[i4] = c.a(i2, SkinManager.RESOURCE_ALPHA_DISABLE);
                iArr2[i4] = new int[0];
            } else {
                iArr[i3] = i2;
                iArr2[i3] = new int[0];
            }
            return new ColorStateList(iArr2, iArr);
        }
        return (ColorStateList) invokeIL.objValue;
    }

    public static Drawable getMaskDrawable(int i2, @Nullable ResourceStateType resourceStateType) {
        InterceptResult invokeIL;
        Drawable maskedDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, resourceStateType)) == null) {
            if (i2 <= 0) {
                return null;
            }
            if (resourceStateType == null) {
                resourceStateType = ResourceStateType.NORMAL;
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            if (resourceStateType.canPress && (maskedDrawable = getMaskedDrawable(i2)) != null) {
                maskedDrawable.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
                stateListDrawable.addState(new int[]{16842919}, maskedDrawable);
            }
            Drawable maskedDrawable2 = getMaskedDrawable(i2);
            if (resourceStateType.canDisable) {
                stateListDrawable.addState(new int[0], maskedDrawable2);
                Drawable maskedDrawable3 = getMaskedDrawable(i2);
                maskedDrawable3.setAlpha((int) (SkinManager.RESOURCE_ALPHA_DISABLE * 255.0f));
                stateListDrawable.addState(new int[0], maskedDrawable3);
            } else {
                stateListDrawable.addState(new int[0], maskedDrawable2);
            }
            return stateListDrawable;
        }
        return (Drawable) invokeIL.objValue;
    }

    public static Drawable getMaskedDrawable(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65540, null, i2)) == null) {
            Drawable drawable = SkinManager.getDrawable(i2);
            if (drawable == null) {
                return null;
            }
            Drawable mutate = drawable.mutate();
            if (TbadkCoreApplication.getInst().getSkinType() != 0) {
                mutate.setColorFilter(SkinManager.getColor(R.color.CAM_X0501), PorterDuff.Mode.SRC_ATOP);
            }
            return mutate;
        }
        return (Drawable) invokeI.objValue;
    }

    public static Drawable getPureDrawable(int i2, @ColorInt int i3, @Nullable ResourceStateType resourceStateType) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(AdIconUtil.AD_TEXT_ID, null, i2, i3, resourceStateType)) == null) {
            if (i2 <= 0) {
                return null;
            }
            if (resourceStateType == null) {
                resourceStateType = ResourceStateType.NORMAL;
            }
            Drawable drawable = SkinManager.getDrawable(i2);
            if (drawable == null) {
                return null;
            }
            Drawable mutate = drawable.mutate();
            mutate.setTintList(getColorListByResourceType(i3, resourceStateType));
            return mutate;
        }
        return (Drawable) invokeIIL.objValue;
    }

    @Deprecated
    public static Drawable getSeletableDrawableForEditorTools(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3, i4)) == null) {
            if (i2 <= 0) {
                return null;
            }
            int i5 = R.color.CAM_X0105;
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = SkinManager.getDrawable(i2);
            if (drawable2 == null) {
                return null;
            }
            Drawable mutate = SkinManager.getDrawable(i2).mutate();
            mutate.setTint(c.a(SkinManager.getColor(i4, i5), SkinManager.RESOURCE_ALPHA_DISABLE));
            stateListDrawable.addState(new int[]{-16842910}, mutate);
            if (i3 > 0 && (drawable = SkinManager.getDrawable(i3)) != null) {
                Drawable mutate2 = SkinManager.getDrawable(i3).mutate();
                mutate2.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
                stateListDrawable.addState(new int[]{16842913, 16842919}, mutate2);
                stateListDrawable.addState(new int[]{16842913}, drawable);
            }
            Drawable mutate3 = SkinManager.getDrawable(i2).mutate();
            mutate3.setTint(c.a(SkinManager.getColor(i4, i5), SkinManager.RESOURCE_ALPHA_PRESS));
            stateListDrawable.addState(new int[]{16842919}, mutate3);
            drawable2.mutate().setTint(SkinManager.getColor(i4, i5));
            stateListDrawable.addState(new int[0], drawable2);
            return stateListDrawable;
        }
        return (Drawable) invokeIII.objValue;
    }

    public static Drawable getSeletableDrawableForEditorToolsEM(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65543, null, i2, i3, i4)) == null) {
            if (i2 <= 0) {
                return null;
            }
            int i5 = R.color.CAM_X0107;
            int i6 = R.color.CAM_X0302;
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = SkinManager.getDrawable(i2);
            if (drawable2 == null) {
                return null;
            }
            Drawable mutate = SkinManager.getDrawable(i2).mutate();
            mutate.setTint(c.a(SkinManager.getColor(i4, i5), SkinManager.RESOURCE_ALPHA_DISABLE));
            stateListDrawable.addState(new int[]{-16842910}, mutate);
            if (i3 > 0 && (drawable = SkinManager.getDrawable(i3)) != null) {
                Drawable mutate2 = SkinManager.getDrawable(i3).mutate();
                mutate2.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
                mutate2.setTint(SkinManager.getColor(i4, i6));
                stateListDrawable.addState(new int[]{16842913, 16842919}, mutate2);
                drawable.mutate().setTint(SkinManager.getColor(i4, i6));
                stateListDrawable.addState(new int[]{16842913}, drawable);
            }
            Drawable mutate3 = SkinManager.getDrawable(i2).mutate();
            mutate3.setTint(c.a(SkinManager.getColor(i4, i5), SkinManager.RESOURCE_ALPHA_PRESS));
            stateListDrawable.addState(new int[]{16842919}, mutate3);
            drawable2.mutate().setTint(SkinManager.getColor(i4, i5));
            stateListDrawable.addState(new int[0], drawable2);
            return stateListDrawable;
        }
        return (Drawable) invokeIII.objValue;
    }

    public static void setMaskDrawable(ImageView imageView, @DrawableRes int i2, ResourceStateType resourceStateType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65544, null, imageView, i2, resourceStateType) == null) || i2 == 0 || imageView == null) {
            return;
        }
        if (resourceStateType == null) {
            resourceStateType = ResourceStateType.NORMAL;
        }
        imageView.setImageDrawable(getMaskDrawable(i2, resourceStateType));
    }

    public static void setPureDrawable(ImageView imageView, @DrawableRes int i2, @ColorRes int i3, ResourceStateType resourceStateType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{imageView, Integer.valueOf(i2), Integer.valueOf(i3), resourceStateType}) == null) || i2 == 0 || imageView == null) {
            return;
        }
        if (resourceStateType == null) {
            resourceStateType = ResourceStateType.NORMAL;
        }
        imageView.setImageDrawable(getPureDrawable(i2, SkinManager.getColor(i3), resourceStateType));
    }

    public static Drawable getMaskDrawable(int i2, boolean z) {
        InterceptResult invokeCommon;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (z) {
                drawable = SkinManager.getDrawable(i2);
            } else {
                drawable = SkinManager.getDrawable(0, i2);
            }
            if (drawable == null) {
                return null;
            }
            Drawable mutate = drawable.mutate();
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (z && skinType != 0) {
                mutate.setColorFilter(SkinManager.getColor(R.color.CAM_X0501), PorterDuff.Mode.SRC_ATOP);
            }
            return mutate;
        }
        return (Drawable) invokeCommon.objValue;
    }
}
