package com.baidu.crius;

import androidx.core.view.InputDeviceCompat;
import com.baidu.crius.annotations.DoNotStrip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@DoNotStrip
/* loaded from: classes3.dex */
public final class CriusUnit {
    public static final /* synthetic */ CriusUnit[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CriusUnit AUTO;
    public static final CriusUnit PERCENT;
    public static final CriusUnit POINT;
    public static final CriusUnit UNDEFINED;
    public transient /* synthetic */ FieldHolder $fh;
    public int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1911244740, "Lcom/baidu/crius/CriusUnit;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1911244740, "Lcom/baidu/crius/CriusUnit;");
                return;
            }
        }
        UNDEFINED = new CriusUnit("UNDEFINED", 0, 0);
        POINT = new CriusUnit("POINT", 1, 1);
        PERCENT = new CriusUnit("PERCENT", 2, 2);
        CriusUnit criusUnit = new CriusUnit("AUTO", 3, 3);
        AUTO = criusUnit;
        $VALUES = new CriusUnit[]{UNDEFINED, POINT, PERCENT, criusUnit};
    }

    public CriusUnit(String str, int i, int i2) {
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

    public static CriusUnit fromInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (!CriusConstants.DEBUG) {
                                return UNDEFINED;
                            }
                            throw new IllegalArgumentException("Unknown enum value: " + i);
                        }
                        return AUTO;
                    }
                    return PERCENT;
                }
                return POINT;
            }
            return UNDEFINED;
        }
        return (CriusUnit) invokeI.objValue;
    }

    public static CriusUnit valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (CriusUnit) Enum.valueOf(CriusUnit.class, str);
        }
        return (CriusUnit) invokeL.objValue;
    }

    public static CriusUnit[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (CriusUnit[]) $VALUES.clone();
        }
        return (CriusUnit[]) invokeV.objValue;
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
