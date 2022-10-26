package com.baidu.crius;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class CriusMeasureMode {
    public static final /* synthetic */ CriusMeasureMode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CriusMeasureMode AT_MOST;
    public static final CriusMeasureMode EXACTLY;
    public static final CriusMeasureMode UNDEFINED;
    public transient /* synthetic */ FieldHolder $fh;
    public int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1279600883, "Lcom/baidu/crius/CriusMeasureMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1279600883, "Lcom/baidu/crius/CriusMeasureMode;");
                return;
            }
        }
        UNDEFINED = new CriusMeasureMode("UNDEFINED", 0, 0);
        EXACTLY = new CriusMeasureMode("EXACTLY", 1, 1);
        CriusMeasureMode criusMeasureMode = new CriusMeasureMode("AT_MOST", 2, 2);
        AT_MOST = criusMeasureMode;
        $VALUES = new CriusMeasureMode[]{UNDEFINED, EXACTLY, criusMeasureMode};
    }

    public CriusMeasureMode(String str, int i, int i2) {
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

    public static CriusMeasureMode fromInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (!CriusConstants.DEBUG) {
                            return UNDEFINED;
                        }
                        throw new IllegalArgumentException("Unknown enum value: " + i);
                    }
                    return AT_MOST;
                }
                return EXACTLY;
            }
            return UNDEFINED;
        }
        return (CriusMeasureMode) invokeI.objValue;
    }

    public static CriusMeasureMode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (CriusMeasureMode) Enum.valueOf(CriusMeasureMode.class, str);
        }
        return (CriusMeasureMode) invokeL.objValue;
    }

    public static CriusMeasureMode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (CriusMeasureMode[]) $VALUES.clone();
        }
        return (CriusMeasureMode[]) invokeV.objValue;
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
