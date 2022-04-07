package com.badlogic.gdx.graphics.glutils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class ShapeRenderer$ShapeType {
    public static final /* synthetic */ ShapeRenderer$ShapeType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ShapeRenderer$ShapeType Filled;
    public static final ShapeRenderer$ShapeType Line;
    public static final ShapeRenderer$ShapeType Point;
    public transient /* synthetic */ FieldHolder $fh;
    public final int glType;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1784728073, "Lcom/badlogic/gdx/graphics/glutils/ShapeRenderer$ShapeType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1784728073, "Lcom/badlogic/gdx/graphics/glutils/ShapeRenderer$ShapeType;");
                return;
            }
        }
        Point = new ShapeRenderer$ShapeType("Point", 0, 0);
        Line = new ShapeRenderer$ShapeType("Line", 1, 1);
        ShapeRenderer$ShapeType shapeRenderer$ShapeType = new ShapeRenderer$ShapeType("Filled", 2, 4);
        Filled = shapeRenderer$ShapeType;
        $VALUES = new ShapeRenderer$ShapeType[]{Point, Line, shapeRenderer$ShapeType};
    }

    public ShapeRenderer$ShapeType(String str, int i, int i2) {
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
        this.glType = i2;
    }

    public static ShapeRenderer$ShapeType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ShapeRenderer$ShapeType) Enum.valueOf(ShapeRenderer$ShapeType.class, str) : (ShapeRenderer$ShapeType) invokeL.objValue;
    }

    public static ShapeRenderer$ShapeType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ShapeRenderer$ShapeType[]) $VALUES.clone() : (ShapeRenderer$ShapeType[]) invokeV.objValue;
    }

    public int getGlType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.glType : invokeV.intValue;
    }
}
