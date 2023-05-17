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
public final class CriusFlexDirection {
    public static final /* synthetic */ CriusFlexDirection[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CriusFlexDirection COLUMN;
    public static final CriusFlexDirection COLUMN_REVERSE;
    public static final CriusFlexDirection ROW;
    public static final CriusFlexDirection ROW_REVERSE;
    public transient /* synthetic */ FieldHolder $fh;
    public int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1075593096, "Lcom/baidu/crius/CriusFlexDirection;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1075593096, "Lcom/baidu/crius/CriusFlexDirection;");
                return;
            }
        }
        COLUMN = new CriusFlexDirection("COLUMN", 0, 0);
        COLUMN_REVERSE = new CriusFlexDirection("COLUMN_REVERSE", 1, 1);
        ROW = new CriusFlexDirection("ROW", 2, 2);
        CriusFlexDirection criusFlexDirection = new CriusFlexDirection("ROW_REVERSE", 3, 3);
        ROW_REVERSE = criusFlexDirection;
        $VALUES = new CriusFlexDirection[]{COLUMN, COLUMN_REVERSE, ROW, criusFlexDirection};
    }

    public CriusFlexDirection(String str, int i, int i2) {
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

    public static CriusFlexDirection fromInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (!CriusConstants.DEBUG) {
                                return COLUMN;
                            }
                            throw new IllegalArgumentException("Unknown enum value: " + i);
                        }
                        return ROW_REVERSE;
                    }
                    return ROW;
                }
                return COLUMN_REVERSE;
            }
            return COLUMN;
        }
        return (CriusFlexDirection) invokeI.objValue;
    }

    public static CriusFlexDirection valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (CriusFlexDirection) Enum.valueOf(CriusFlexDirection.class, str);
        }
        return (CriusFlexDirection) invokeL.objValue;
    }

    public static CriusFlexDirection[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (CriusFlexDirection[]) $VALUES.clone();
        }
        return (CriusFlexDirection[]) invokeV.objValue;
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
