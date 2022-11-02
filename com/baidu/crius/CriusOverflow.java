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
/* loaded from: classes.dex */
public final class CriusOverflow {
    public static final /* synthetic */ CriusOverflow[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CriusOverflow HIDDEN;
    public static final CriusOverflow SCROLL;
    public transient /* synthetic */ FieldHolder $fh;
    public int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1756802694, "Lcom/baidu/crius/CriusOverflow;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1756802694, "Lcom/baidu/crius/CriusOverflow;");
                return;
            }
        }
        HIDDEN = new CriusOverflow("HIDDEN", 0, 0);
        CriusOverflow criusOverflow = new CriusOverflow("SCROLL", 1, 1);
        SCROLL = criusOverflow;
        $VALUES = new CriusOverflow[]{HIDDEN, criusOverflow};
    }

    public CriusOverflow(String str, int i, int i2) {
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

    public static CriusOverflow fromInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (!CriusConstants.DEBUG) {
                        return HIDDEN;
                    }
                    throw new IllegalArgumentException("Unknown enum value: " + i);
                }
                return SCROLL;
            }
            return HIDDEN;
        }
        return (CriusOverflow) invokeI.objValue;
    }

    public static CriusOverflow valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (CriusOverflow) Enum.valueOf(CriusOverflow.class, str);
        }
        return (CriusOverflow) invokeL.objValue;
    }

    public static CriusOverflow[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (CriusOverflow[]) $VALUES.clone();
        }
        return (CriusOverflow[]) invokeV.objValue;
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
