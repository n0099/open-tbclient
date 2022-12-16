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
public final class CriusWrap {
    public static final /* synthetic */ CriusWrap[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CriusWrap NO_WRAP;
    public static final CriusWrap WRAP;
    public static final CriusWrap WRAP_REVERSE;
    public transient /* synthetic */ FieldHolder $fh;
    public int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1913203134, "Lcom/baidu/crius/CriusWrap;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1913203134, "Lcom/baidu/crius/CriusWrap;");
                return;
            }
        }
        NO_WRAP = new CriusWrap("NO_WRAP", 0, 0);
        WRAP = new CriusWrap("WRAP", 1, 1);
        CriusWrap criusWrap = new CriusWrap("WRAP_REVERSE", 2, 2);
        WRAP_REVERSE = criusWrap;
        $VALUES = new CriusWrap[]{NO_WRAP, WRAP, criusWrap};
    }

    public CriusWrap(String str, int i, int i2) {
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

    public static CriusWrap fromInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (!CriusConstants.DEBUG) {
                            return NO_WRAP;
                        }
                        throw new IllegalArgumentException("Unknown enum value: " + i);
                    }
                    return WRAP_REVERSE;
                }
                return WRAP;
            }
            return NO_WRAP;
        }
        return (CriusWrap) invokeI.objValue;
    }

    public static CriusWrap valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (CriusWrap) Enum.valueOf(CriusWrap.class, str);
        }
        return (CriusWrap) invokeL.objValue;
    }

    public static CriusWrap[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (CriusWrap[]) $VALUES.clone();
        }
        return (CriusWrap[]) invokeV.objValue;
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
