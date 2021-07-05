package com.baidu.tbadk.core.business;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class HalfType {
    public static final /* synthetic */ HalfType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final HalfType ALL;
    public static final HalfType BOTTOM;
    public static final HalfType LEFT;
    public static final HalfType RIGHT;
    public static final HalfType TOP;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-471358292, "Lcom/baidu/tbadk/core/business/HalfType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-471358292, "Lcom/baidu/tbadk/core/business/HalfType;");
                return;
            }
        }
        LEFT = new HalfType("LEFT", 0);
        RIGHT = new HalfType("RIGHT", 1);
        TOP = new HalfType("TOP", 2);
        BOTTOM = new HalfType("BOTTOM", 3);
        HalfType halfType = new HalfType("ALL", 4);
        ALL = halfType;
        $VALUES = new HalfType[]{LEFT, RIGHT, TOP, BOTTOM, halfType};
    }

    public HalfType(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static HalfType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (HalfType) Enum.valueOf(HalfType.class, str) : (HalfType) invokeL.objValue;
    }

    public static HalfType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (HalfType[]) $VALUES.clone() : (HalfType[]) invokeV.objValue;
    }
}
