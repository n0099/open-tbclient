package com.badlogic.gdx.graphics.g2d;

import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class ParticleEmitter$SpawnShape {
    public static final /* synthetic */ ParticleEmitter$SpawnShape[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ParticleEmitter$SpawnShape ellipse;
    public static final ParticleEmitter$SpawnShape line;
    public static final ParticleEmitter$SpawnShape point;
    public static final ParticleEmitter$SpawnShape square;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2025131791, "Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$SpawnShape;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2025131791, "Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$SpawnShape;");
                return;
            }
        }
        point = new ParticleEmitter$SpawnShape(Config.EVENT_HEAT_POINT, 0);
        line = new ParticleEmitter$SpawnShape("line", 1);
        square = new ParticleEmitter$SpawnShape("square", 2);
        ParticleEmitter$SpawnShape particleEmitter$SpawnShape = new ParticleEmitter$SpawnShape("ellipse", 3);
        ellipse = particleEmitter$SpawnShape;
        $VALUES = new ParticleEmitter$SpawnShape[]{point, line, square, particleEmitter$SpawnShape};
    }

    public ParticleEmitter$SpawnShape(String str, int i) {
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

    public static ParticleEmitter$SpawnShape valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (ParticleEmitter$SpawnShape) Enum.valueOf(ParticleEmitter$SpawnShape.class, str);
        }
        return (ParticleEmitter$SpawnShape) invokeL.objValue;
    }

    public static ParticleEmitter$SpawnShape[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (ParticleEmitter$SpawnShape[]) $VALUES.clone();
        }
        return (ParticleEmitter$SpawnShape[]) invokeV.objValue;
    }
}
