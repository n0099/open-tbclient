package com.baidu.tbadk.core.elementsMaven;

import com.baidu.adp.widget.HorizontalTranslateLayout;
import com.baidu.adp.widget.VerticalTranslateLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class Direction {
    public static final /* synthetic */ Direction[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Direction BOTTOM;
    public static final Direction LEFT;
    public static final Direction RIGHT;
    public static final Direction TOP;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(533436836, "Lcom/baidu/tbadk/core/elementsMaven/Direction;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(533436836, "Lcom/baidu/tbadk/core/elementsMaven/Direction;");
                return;
            }
        }
        TOP = new Direction("TOP", 0, VerticalTranslateLayout.TOP);
        BOTTOM = new Direction("BOTTOM", 1, "bottom");
        LEFT = new Direction("LEFT", 2, "left");
        Direction direction = new Direction("RIGHT", 3, HorizontalTranslateLayout.RIGHT);
        RIGHT = direction;
        $VALUES = new Direction[]{TOP, BOTTOM, LEFT, direction};
    }

    public Direction(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Direction valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Direction) Enum.valueOf(Direction.class, str) : (Direction) invokeL.objValue;
    }

    public static Direction[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Direction[]) $VALUES.clone() : (Direction[]) invokeV.objValue;
    }
}
