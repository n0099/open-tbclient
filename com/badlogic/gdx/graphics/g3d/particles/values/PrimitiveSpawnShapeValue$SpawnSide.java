package com.badlogic.gdx.graphics.g3d.particles.values;

import com.baidu.sapi2.utils.enums.ShareDirectionType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class PrimitiveSpawnShapeValue$SpawnSide {
    public static final /* synthetic */ PrimitiveSpawnShapeValue$SpawnSide[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PrimitiveSpawnShapeValue$SpawnSide both;
    public static final PrimitiveSpawnShapeValue$SpawnSide bottom;
    public static final PrimitiveSpawnShapeValue$SpawnSide top;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(988450761, "Lcom/badlogic/gdx/graphics/g3d/particles/values/PrimitiveSpawnShapeValue$SpawnSide;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(988450761, "Lcom/badlogic/gdx/graphics/g3d/particles/values/PrimitiveSpawnShapeValue$SpawnSide;");
                return;
            }
        }
        both = new PrimitiveSpawnShapeValue$SpawnSide(ShareDirectionType.BOTH, 0);
        top = new PrimitiveSpawnShapeValue$SpawnSide("top", 1);
        PrimitiveSpawnShapeValue$SpawnSide primitiveSpawnShapeValue$SpawnSide = new PrimitiveSpawnShapeValue$SpawnSide("bottom", 2);
        bottom = primitiveSpawnShapeValue$SpawnSide;
        $VALUES = new PrimitiveSpawnShapeValue$SpawnSide[]{both, top, primitiveSpawnShapeValue$SpawnSide};
    }

    public PrimitiveSpawnShapeValue$SpawnSide(String str, int i) {
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

    public static PrimitiveSpawnShapeValue$SpawnSide valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (PrimitiveSpawnShapeValue$SpawnSide) Enum.valueOf(PrimitiveSpawnShapeValue$SpawnSide.class, str);
        }
        return (PrimitiveSpawnShapeValue$SpawnSide) invokeL.objValue;
    }

    public static PrimitiveSpawnShapeValue$SpawnSide[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (PrimitiveSpawnShapeValue$SpawnSide[]) $VALUES.clone();
        }
        return (PrimitiveSpawnShapeValue$SpawnSide[]) invokeV.objValue;
    }
}
