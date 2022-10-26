package com.baidu.crius;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class CriusDirection {
    public static final /* synthetic */ CriusDirection[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CriusDirection INHERIT;
    public static final CriusDirection LTR;
    public static final CriusDirection RTL;
    public transient /* synthetic */ FieldHolder $fh;
    public int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(965429295, "Lcom/baidu/crius/CriusDirection;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(965429295, "Lcom/baidu/crius/CriusDirection;");
                return;
            }
        }
        INHERIT = new CriusDirection("INHERIT", 0, 0);
        LTR = new CriusDirection(StaticLayoutBuilderCompat.TEXT_DIR_CLASS_LTR, 1, 1);
        CriusDirection criusDirection = new CriusDirection(StaticLayoutBuilderCompat.TEXT_DIR_CLASS_RTL, 2, 2);
        RTL = criusDirection;
        $VALUES = new CriusDirection[]{INHERIT, LTR, criusDirection};
    }

    public CriusDirection(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
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
        this.mIntValue = i2;
    }

    public static CriusDirection fromInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (!CriusConstants.DEBUG) {
                            return INHERIT;
                        }
                        throw new IllegalArgumentException("Unknown enum value: " + i);
                    }
                    return RTL;
                }
                return LTR;
            }
            return INHERIT;
        }
        return (CriusDirection) invokeI.objValue;
    }

    public static CriusDirection valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (CriusDirection) Enum.valueOf(CriusDirection.class, str);
        }
        return (CriusDirection) invokeL.objValue;
    }

    public static CriusDirection[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (CriusDirection[]) $VALUES.clone();
        }
        return (CriusDirection[]) invokeV.objValue;
    }

    public int intValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mIntValue;
        }
        return invokeV.intValue;
    }
}
