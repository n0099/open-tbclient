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
public final class CriusJustify {
    public static final /* synthetic */ CriusJustify[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CriusJustify CENTER;
    public static final CriusJustify FLEX_END;
    public static final CriusJustify FLEX_START;
    public static final CriusJustify SPACE_AROUND;
    public static final CriusJustify SPACE_BETWEEN;
    public transient /* synthetic */ FieldHolder $fh;
    public int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-275116034, "Lcom/baidu/crius/CriusJustify;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-275116034, "Lcom/baidu/crius/CriusJustify;");
                return;
            }
        }
        FLEX_START = new CriusJustify("FLEX_START", 0, 0);
        CENTER = new CriusJustify("CENTER", 1, 1);
        FLEX_END = new CriusJustify("FLEX_END", 2, 2);
        SPACE_BETWEEN = new CriusJustify("SPACE_BETWEEN", 3, 3);
        CriusJustify criusJustify = new CriusJustify("SPACE_AROUND", 4, 4);
        SPACE_AROUND = criusJustify;
        $VALUES = new CriusJustify[]{FLEX_START, CENTER, FLEX_END, SPACE_BETWEEN, criusJustify};
    }

    public CriusJustify(String str, int i, int i2) {
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

    public static CriusJustify fromInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (!CriusConstants.DEBUG) {
                                    return FLEX_START;
                                }
                                throw new IllegalArgumentException("Unknown enum value: " + i);
                            }
                            return SPACE_AROUND;
                        }
                        return SPACE_BETWEEN;
                    }
                    return FLEX_END;
                }
                return CENTER;
            }
            return FLEX_START;
        }
        return (CriusJustify) invokeI.objValue;
    }

    public static CriusJustify valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (CriusJustify) Enum.valueOf(CriusJustify.class, str);
        }
        return (CriusJustify) invokeL.objValue;
    }

    public static CriusJustify[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (CriusJustify[]) $VALUES.clone();
        }
        return (CriusJustify[]) invokeV.objValue;
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
