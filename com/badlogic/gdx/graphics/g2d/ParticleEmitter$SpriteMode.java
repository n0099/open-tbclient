package com.badlogic.gdx.graphics.g2d;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class ParticleEmitter$SpriteMode {
    public static final /* synthetic */ ParticleEmitter$SpriteMode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ParticleEmitter$SpriteMode animated;
    public static final ParticleEmitter$SpriteMode random;
    public static final ParticleEmitter$SpriteMode single;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-40481235, "Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$SpriteMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-40481235, "Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$SpriteMode;");
                return;
            }
        }
        single = new ParticleEmitter$SpriteMode("single", 0);
        random = new ParticleEmitter$SpriteMode("random", 1);
        ParticleEmitter$SpriteMode particleEmitter$SpriteMode = new ParticleEmitter$SpriteMode("animated", 2);
        animated = particleEmitter$SpriteMode;
        $VALUES = new ParticleEmitter$SpriteMode[]{single, random, particleEmitter$SpriteMode};
    }

    public ParticleEmitter$SpriteMode(String str, int i) {
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

    public static ParticleEmitter$SpriteMode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (ParticleEmitter$SpriteMode) Enum.valueOf(ParticleEmitter$SpriteMode.class, str);
        }
        return (ParticleEmitter$SpriteMode) invokeL.objValue;
    }

    public static ParticleEmitter$SpriteMode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (ParticleEmitter$SpriteMode[]) $VALUES.clone();
        }
        return (ParticleEmitter$SpriteMode[]) invokeV.objValue;
    }
}
