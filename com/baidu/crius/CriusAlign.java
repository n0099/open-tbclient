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
public final class CriusAlign {
    public static final /* synthetic */ CriusAlign[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CriusAlign AUTO;
    public static final CriusAlign CENTER;
    public static final CriusAlign FLEX_END;
    public static final CriusAlign FLEX_START;
    public static final CriusAlign SPACE_AROUND;
    public static final CriusAlign SPACE_BETWEEN;
    public static final CriusAlign STRETCH;
    public transient /* synthetic */ FieldHolder $fh;
    public int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1455396119, "Lcom/baidu/crius/CriusAlign;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1455396119, "Lcom/baidu/crius/CriusAlign;");
                return;
            }
        }
        AUTO = new CriusAlign("AUTO", 0, 0);
        FLEX_START = new CriusAlign("FLEX_START", 1, 1);
        CENTER = new CriusAlign("CENTER", 2, 2);
        FLEX_END = new CriusAlign("FLEX_END", 3, 3);
        STRETCH = new CriusAlign("STRETCH", 4, 4);
        SPACE_BETWEEN = new CriusAlign("SPACE_BETWEEN", 5, 5);
        CriusAlign criusAlign = new CriusAlign("SPACE_AROUND", 6, 6);
        SPACE_AROUND = criusAlign;
        $VALUES = new CriusAlign[]{AUTO, FLEX_START, CENTER, FLEX_END, STRETCH, SPACE_BETWEEN, criusAlign};
    }

    public CriusAlign(String str, int i, int i2) {
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

    public static CriusAlign fromInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            switch (i) {
                case 0:
                    return AUTO;
                case 1:
                    return FLEX_START;
                case 2:
                    return CENTER;
                case 3:
                    return FLEX_END;
                case 4:
                    return STRETCH;
                case 5:
                    return SPACE_BETWEEN;
                case 6:
                    return SPACE_AROUND;
                default:
                    if (!CriusConstants.DEBUG) {
                        return AUTO;
                    }
                    throw new IllegalArgumentException("Unknown enum value: " + i);
            }
        }
        return (CriusAlign) invokeI.objValue;
    }

    public static CriusAlign valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (CriusAlign) Enum.valueOf(CriusAlign.class, str);
        }
        return (CriusAlign) invokeL.objValue;
    }

    public static CriusAlign[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (CriusAlign[]) $VALUES.clone();
        }
        return (CriusAlign[]) invokeV.objValue;
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
