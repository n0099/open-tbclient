package com.baidu.smallgame.sdk.gpuimage.graphics;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class Drawable2d$Prefab {
    public static final /* synthetic */ Drawable2d$Prefab[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Drawable2d$Prefab FULL_RECTANGLE;
    public static final Drawable2d$Prefab FULL_RECTANGLE_MIRRORED;
    public static final Drawable2d$Prefab RECTANGLE;
    public static final Drawable2d$Prefab TRIANGLE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1545445792, "Lcom/baidu/smallgame/sdk/gpuimage/graphics/Drawable2d$Prefab;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1545445792, "Lcom/baidu/smallgame/sdk/gpuimage/graphics/Drawable2d$Prefab;");
                return;
            }
        }
        TRIANGLE = new Drawable2d$Prefab("TRIANGLE", 0);
        RECTANGLE = new Drawable2d$Prefab("RECTANGLE", 1);
        FULL_RECTANGLE = new Drawable2d$Prefab("FULL_RECTANGLE", 2);
        Drawable2d$Prefab drawable2d$Prefab = new Drawable2d$Prefab("FULL_RECTANGLE_MIRRORED", 3);
        FULL_RECTANGLE_MIRRORED = drawable2d$Prefab;
        $VALUES = new Drawable2d$Prefab[]{TRIANGLE, RECTANGLE, FULL_RECTANGLE, drawable2d$Prefab};
    }

    public Drawable2d$Prefab(String str, int i2) {
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

    public static Drawable2d$Prefab valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Drawable2d$Prefab) Enum.valueOf(Drawable2d$Prefab.class, str) : (Drawable2d$Prefab) invokeL.objValue;
    }

    public static Drawable2d$Prefab[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Drawable2d$Prefab[]) $VALUES.clone() : (Drawable2d$Prefab[]) invokeV.objValue;
    }
}
