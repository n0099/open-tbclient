package com.badlogic.gdx.graphics.g2d;

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
public final class ParticleEmitter$SpawnEllipseSide {
    public static final /* synthetic */ ParticleEmitter$SpawnEllipseSide[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ParticleEmitter$SpawnEllipseSide both;
    public static final ParticleEmitter$SpawnEllipseSide bottom;
    public static final ParticleEmitter$SpawnEllipseSide top;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(120984347, "Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$SpawnEllipseSide;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(120984347, "Lcom/badlogic/gdx/graphics/g2d/ParticleEmitter$SpawnEllipseSide;");
                return;
            }
        }
        both = new ParticleEmitter$SpawnEllipseSide(ShareDirectionType.BOTH, 0);
        top = new ParticleEmitter$SpawnEllipseSide("top", 1);
        ParticleEmitter$SpawnEllipseSide particleEmitter$SpawnEllipseSide = new ParticleEmitter$SpawnEllipseSide("bottom", 2);
        bottom = particleEmitter$SpawnEllipseSide;
        $VALUES = new ParticleEmitter$SpawnEllipseSide[]{both, top, particleEmitter$SpawnEllipseSide};
    }

    public ParticleEmitter$SpawnEllipseSide(String str, int i) {
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

    public static ParticleEmitter$SpawnEllipseSide valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (ParticleEmitter$SpawnEllipseSide) Enum.valueOf(ParticleEmitter$SpawnEllipseSide.class, str);
        }
        return (ParticleEmitter$SpawnEllipseSide) invokeL.objValue;
    }

    public static ParticleEmitter$SpawnEllipseSide[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (ParticleEmitter$SpawnEllipseSide[]) $VALUES.clone();
        }
        return (ParticleEmitter$SpawnEllipseSide[]) invokeV.objValue;
    }
}
