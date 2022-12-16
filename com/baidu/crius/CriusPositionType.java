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
/* loaded from: classes2.dex */
public final class CriusPositionType {
    public static final /* synthetic */ CriusPositionType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CriusPositionType ABSOLUTE;
    public static final CriusPositionType RELATIVE;
    public transient /* synthetic */ FieldHolder $fh;
    public int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-704891867, "Lcom/baidu/crius/CriusPositionType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-704891867, "Lcom/baidu/crius/CriusPositionType;");
                return;
            }
        }
        RELATIVE = new CriusPositionType("RELATIVE", 0, 0);
        CriusPositionType criusPositionType = new CriusPositionType("ABSOLUTE", 1, 1);
        ABSOLUTE = criusPositionType;
        $VALUES = new CriusPositionType[]{RELATIVE, criusPositionType};
    }

    public CriusPositionType(String str, int i, int i2) {
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

    public static CriusPositionType fromInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (!CriusConstants.DEBUG) {
                        return RELATIVE;
                    }
                    throw new IllegalArgumentException("Unknown enum value: " + i);
                }
                return ABSOLUTE;
            }
            return RELATIVE;
        }
        return (CriusPositionType) invokeI.objValue;
    }

    public static CriusPositionType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (CriusPositionType) Enum.valueOf(CriusPositionType.class, str);
        }
        return (CriusPositionType) invokeL.objValue;
    }

    public static CriusPositionType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (CriusPositionType[]) $VALUES.clone();
        }
        return (CriusPositionType[]) invokeV.objValue;
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
