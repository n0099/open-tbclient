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
public final class CriusEdge {
    public static final /* synthetic */ CriusEdge[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CriusEdge ALL;
    public static final CriusEdge BOTTOM;
    public static final CriusEdge HORIZONTAL;
    public static final CriusEdge LEFT;
    public static final CriusEdge RIGHT;
    public static final CriusEdge TOP;
    public static final CriusEdge VERTICAL;
    public transient /* synthetic */ FieldHolder $fh;
    public int mIntValue;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1896168107, "Lcom/baidu/crius/CriusEdge;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1896168107, "Lcom/baidu/crius/CriusEdge;");
                return;
            }
        }
        LEFT = new CriusEdge("LEFT", 0, 0);
        TOP = new CriusEdge("TOP", 1, 1);
        RIGHT = new CriusEdge("RIGHT", 2, 2);
        BOTTOM = new CriusEdge("BOTTOM", 3, 3);
        HORIZONTAL = new CriusEdge("HORIZONTAL", 4, 4);
        VERTICAL = new CriusEdge("VERTICAL", 5, 5);
        CriusEdge criusEdge = new CriusEdge("ALL", 6, 6);
        ALL = criusEdge;
        $VALUES = new CriusEdge[]{LEFT, TOP, RIGHT, BOTTOM, HORIZONTAL, VERTICAL, criusEdge};
    }

    public CriusEdge(String str, int i, int i2) {
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

    public static CriusEdge fromInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            switch (i) {
                case 0:
                    return LEFT;
                case 1:
                    return TOP;
                case 2:
                    return RIGHT;
                case 3:
                    return BOTTOM;
                case 4:
                    return HORIZONTAL;
                case 5:
                    return VERTICAL;
                case 6:
                    return ALL;
                default:
                    if (!CriusConstants.DEBUG) {
                        return LEFT;
                    }
                    throw new IllegalArgumentException("Unknown enum value: " + i);
            }
        }
        return (CriusEdge) invokeI.objValue;
    }

    public static CriusEdge valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return (CriusEdge) Enum.valueOf(CriusEdge.class, str);
        }
        return (CriusEdge) invokeL.objValue;
    }

    public static CriusEdge[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return (CriusEdge[]) $VALUES.clone();
        }
        return (CriusEdge[]) invokeV.objValue;
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
