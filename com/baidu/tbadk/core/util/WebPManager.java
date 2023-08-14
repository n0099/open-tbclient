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
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.y9a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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

        public ResourceStateType(String str, int i, boolean z, boolean z2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            this.stateCount = i2;
        }

        public static ResourceStateType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
                return (ResourceStateType) Enum.valueOf(ResourceStateType.class, str);
            }
            return (ResourceStateType) invokeL.objValue;
        }

        public static ResourceStateType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
                return (ResourceStateType[]) $VALUES.clone();
            }
            return (ResourceStateType[]) invokeV.objValue;
        }
    }

    public WebPManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ColorStateList getColorListByResourceType(@ColorInt int i, ResourceStateType resourceStateType) {
        InterceptResult invokeIL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, resourceStateType)) == null) {
            if (resourceStateType == null) {
                resourceStateType = ResourceStateType.NORMAL;
            }
            int[] iArr = new int[resourceStateType.stateCount];
            int[][] iArr2 = new int[resourceStateType.stateCount];
            if (resourceStateType.canPress) {
                iArr[0] = y9a.a(i, SkinManager.RESOURCE_ALPHA_PRESS);
                iArr2[0] = new int[]{16842919, 16842910};
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (resourceStateType.canDisable) {
                iArr[i2] = i;
                int[] iArr3 = new int[1];
                iArr3[0] = 16842910;
                iArr2[i2] = iArr3;
                int i3 = i2 + 1;
                iArr[i3] = y9a.a(i, SkinManager.RESOURCE_ALPHA_DISABLE);
                iArr2[i3] = new int[0];
            } else {
                iArr[i2] = i;
                iArr2[i2] = new int[0];
            }
            return new ColorStateList(iArr2, iArr);
        }
        return (ColorStateList) invokeIL.objValue;
    }

    public static Drawable getMaskDrawable(int i, @Nullable ResourceStateType resourceStateType) {
        InterceptResult invokeIL;
        Drawable maskedDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, resourceStateType)) == null) {
            if (i <= 0) {
                return null;
            }
            if (resourceStateType == null) {
                resourceStateType = ResourceStateType.NORMAL;
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            if (resourceStateType.canPress && (maskedDrawable = getMaskedDrawable(i)) != null) {
                maskedDrawable.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
                stateListDrawable.addState(new int[]{16842919}, maskedDrawable);
            }
            Drawable maskedDrawable2 = getMaskedDrawable(i);
            if (resourceStateType.canDisable) {
                stateListDrawable.addState(new int[0], maskedDrawable2);
                Drawable maskedDrawable3 = getMaskedDrawable(i);
                maskedDrawable3.setAlpha((int) (SkinManager.RESOURCE_ALPHA_DISABLE * 255.0f));
                stateListDrawable.addState(new int[0], maskedDrawable3);
            } else {
                stateListDrawable.addState(new int[0], maskedDrawable2);
            }
            return stateListDrawable;
        }
        return (Drawable) invokeIL.objValue;
    }

    public static Drawable getMaskDrawable(int i, boolean z) {
        InterceptResult invokeCommon;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (z) {
                drawable = SkinManager.getDrawable(i);
            } else {
                drawable = SkinManager.getDrawable(0, i);
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

    public static Drawable getMaskedDrawable(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            Drawable drawable = SkinManager.getDrawable(i);
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

    public static Drawable getPureDrawable(int i, @ColorInt int i2, @Nullable ResourceStateType resourceStateType) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65541, null, i, i2, resourceStateType)) == null) {
            if (i <= 0) {
                return null;
            }
            if (resourceStateType == null) {
                resourceStateType = ResourceStateType.NORMAL;
            }
            Drawable drawable = SkinManager.getDrawable(i);
            if (drawable == null) {
                return null;
            }
            Drawable mutate = drawable.mutate();
            mutate.setTintList(getColorListByResourceType(i2, resourceStateType));
            return mutate;
        }
        return (Drawable) invokeIIL.objValue;
    }

    public static void setMaskDrawable(ImageView imageView, @DrawableRes int i, ResourceStateType resourceStateType) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65544, null, imageView, i, resourceStateType) == null) && i != 0 && imageView != null) {
            if (resourceStateType == null) {
                resourceStateType = ResourceStateType.NORMAL;
            }
            imageView.setImageDrawable(getMaskDrawable(i, resourceStateType));
        }
    }

    @Deprecated
    public static Drawable getSeletableDrawableForEditorTools(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65542, null, i, i2, i3)) == null) {
            if (i <= 0) {
                return null;
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = SkinManager.getDrawable(i);
            if (drawable2 == null) {
                return null;
            }
            Drawable mutate = SkinManager.getDrawable(i).mutate();
            mutate.setTint(y9a.a(SkinManager.getColor(i3, (int) R.color.CAM_X0105), SkinManager.RESOURCE_ALPHA_DISABLE));
            stateListDrawable.addState(new int[]{-16842910}, mutate);
            if (i2 > 0 && (drawable = SkinManager.getDrawable(i2)) != null) {
                Drawable mutate2 = SkinManager.getDrawable(i2).mutate();
                mutate2.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
                stateListDrawable.addState(new int[]{16842913, 16842919}, mutate2);
                stateListDrawable.addState(new int[]{16842913}, drawable);
            }
            Drawable mutate3 = SkinManager.getDrawable(i).mutate();
            mutate3.setTint(y9a.a(SkinManager.getColor(i3, (int) R.color.CAM_X0105), SkinManager.RESOURCE_ALPHA_PRESS));
            stateListDrawable.addState(new int[]{16842919}, mutate3);
            drawable2.mutate().setTint(SkinManager.getColor(i3, (int) R.color.CAM_X0105));
            stateListDrawable.addState(new int[0], drawable2);
            return stateListDrawable;
        }
        return (Drawable) invokeIII.objValue;
    }

    public static Drawable getSeletableDrawableForEditorToolsEM(int i, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (i <= 0) {
                return null;
            }
            if (i3 <= 0) {
                i3 = R.color.CAM_X0107;
            }
            if (i4 <= 0) {
                i4 = R.color.CAM_X0302;
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = SkinManager.getDrawable(i);
            if (drawable2 == null) {
                return null;
            }
            Drawable mutate = SkinManager.getDrawable(i).mutate();
            mutate.setTint(y9a.a(SkinManager.getColor(i5, i3), SkinManager.RESOURCE_ALPHA_DISABLE));
            stateListDrawable.addState(new int[]{-16842910}, mutate);
            if (i2 > 0 && (drawable = SkinManager.getDrawable(i2)) != null) {
                Drawable mutate2 = SkinManager.getDrawable(i2).mutate();
                mutate2.setAlpha((int) (SkinManager.RESOURCE_ALPHA_PRESS * 255.0f));
                mutate2.setTint(SkinManager.getColor(i5, i4));
                stateListDrawable.addState(new int[]{16842913, 16842919}, mutate2);
                drawable.mutate().setTint(SkinManager.getColor(i5, i4));
                stateListDrawable.addState(new int[]{16842913}, drawable);
            }
            Drawable mutate3 = SkinManager.getDrawable(i).mutate();
            mutate3.setTint(y9a.a(SkinManager.getColor(i5, i3), SkinManager.RESOURCE_ALPHA_PRESS));
            stateListDrawable.addState(new int[]{16842919}, mutate3);
            drawable2.mutate().setTint(SkinManager.getColor(i5, i3));
            stateListDrawable.addState(new int[0], drawable2);
            return stateListDrawable;
        }
        return (Drawable) invokeCommon.objValue;
    }

    public static void setPureDrawable(ImageView imageView, @DrawableRes int i, @ColorRes int i2, ResourceStateType resourceStateType) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{imageView, Integer.valueOf(i), Integer.valueOf(i2), resourceStateType}) == null) && i != 0 && imageView != null) {
            if (resourceStateType == null) {
                resourceStateType = ResourceStateType.NORMAL;
            }
            imageView.setImageDrawable(getPureDrawable(i, SkinManager.getColor(i2), resourceStateType));
        }
    }
}
