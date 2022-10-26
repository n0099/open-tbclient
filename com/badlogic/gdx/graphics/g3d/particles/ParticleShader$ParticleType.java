package com.badlogic.gdx.graphics.g3d.particles;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class ParticleShader$ParticleType {
    public static final /* synthetic */ ParticleShader$ParticleType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ParticleShader$ParticleType Billboard;
    public static final ParticleShader$ParticleType Point;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1753101297, "Lcom/badlogic/gdx/graphics/g3d/particles/ParticleShader$ParticleType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1753101297, "Lcom/badlogic/gdx/graphics/g3d/particles/ParticleShader$ParticleType;");
                return;
            }
        }
        Billboard = new ParticleShader$ParticleType("Billboard", 0);
        ParticleShader$ParticleType particleShader$ParticleType = new ParticleShader$ParticleType("Point", 1);
        Point = particleShader$ParticleType;
        $VALUES = new ParticleShader$ParticleType[]{Billboard, particleShader$ParticleType};
    }

    public ParticleShader$ParticleType(String str, int i) {
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

    public static ParticleShader$ParticleType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (ParticleShader$ParticleType) Enum.valueOf(ParticleShader$ParticleType.class, str);
        }
        return (ParticleShader$ParticleType) invokeL.objValue;
    }

    public static ParticleShader$ParticleType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (ParticleShader$ParticleType[]) $VALUES.clone();
        }
        return (ParticleShader$ParticleType[]) invokeV.objValue;
    }
}
