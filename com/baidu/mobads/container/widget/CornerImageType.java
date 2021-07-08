package com.baidu.mobads.container.widget;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class CornerImageType {
    public static final /* synthetic */ CornerImageType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CornerImageType Circle;
    public static final CornerImageType OVAL;
    public static final CornerImageType RoundRect;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-835175097, "Lcom/baidu/mobads/container/widget/CornerImageType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-835175097, "Lcom/baidu/mobads/container/widget/CornerImageType;");
                return;
            }
        }
        OVAL = new CornerImageType("OVAL", 0);
        RoundRect = new CornerImageType("RoundRect", 1);
        CornerImageType cornerImageType = new CornerImageType("Circle", 2);
        Circle = cornerImageType;
        $VALUES = new CornerImageType[]{OVAL, RoundRect, cornerImageType};
    }

    public CornerImageType(String str, int i2) {
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

    public static CornerImageType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CornerImageType) Enum.valueOf(CornerImageType.class, str) : (CornerImageType) invokeL.objValue;
    }

    public static CornerImageType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CornerImageType[]) $VALUES.clone() : (CornerImageType[]) invokeV.objValue;
    }
}
