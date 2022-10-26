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
public final class HdpiMode {
    public static final /* synthetic */ HdpiMode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final HdpiMode Logical;
    public static final HdpiMode Pixels;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1418054324, "Lcom/badlogic/gdx/graphics/glutils/HdpiMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1418054324, "Lcom/badlogic/gdx/graphics/glutils/HdpiMode;");
                return;
            }
        }
        Logical = new HdpiMode("Logical", 0);
        HdpiMode hdpiMode = new HdpiMode("Pixels", 1);
        Pixels = hdpiMode;
        $VALUES = new HdpiMode[]{Logical, hdpiMode};
    }

    public HdpiMode(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static HdpiMode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (HdpiMode) Enum.valueOf(HdpiMode.class, str);
        }
        return (HdpiMode) invokeL.objValue;
    }

    public static HdpiMode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (HdpiMode[]) $VALUES.clone();
        }
        return (HdpiMode[]) invokeV.objValue;
    }
}
