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
public final class ParticleShader$AlignMode {
    public static final /* synthetic */ ParticleShader$AlignMode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ParticleShader$AlignMode Screen;
    public static final ParticleShader$AlignMode ViewPoint;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1660420929, "Lcom/badlogic/gdx/graphics/g3d/particles/ParticleShader$AlignMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1660420929, "Lcom/badlogic/gdx/graphics/g3d/particles/ParticleShader$AlignMode;");
                return;
            }
        }
        Screen = new ParticleShader$AlignMode("Screen", 0);
        ParticleShader$AlignMode particleShader$AlignMode = new ParticleShader$AlignMode("ViewPoint", 1);
        ViewPoint = particleShader$AlignMode;
        $VALUES = new ParticleShader$AlignMode[]{Screen, particleShader$AlignMode};
    }

    public ParticleShader$AlignMode(String str, int i) {
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

    public static ParticleShader$AlignMode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ParticleShader$AlignMode) Enum.valueOf(ParticleShader$AlignMode.class, str) : (ParticleShader$AlignMode) invokeL.objValue;
    }

    public static ParticleShader$AlignMode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ParticleShader$AlignMode[]) $VALUES.clone() : (ParticleShader$AlignMode[]) invokeV.objValue;
    }
}
