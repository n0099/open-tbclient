package com.badlogic.gdx.graphics.g3d.particles.emitters;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.webrtc.PeerConnectionFactory;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class RegularEmitter$EmissionMode {
    public static final /* synthetic */ RegularEmitter$EmissionMode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final RegularEmitter$EmissionMode Disabled;
    public static final RegularEmitter$EmissionMode Enabled;
    public static final RegularEmitter$EmissionMode EnabledUntilCycleEnd;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(500339932, "Lcom/badlogic/gdx/graphics/g3d/particles/emitters/RegularEmitter$EmissionMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(500339932, "Lcom/badlogic/gdx/graphics/g3d/particles/emitters/RegularEmitter$EmissionMode;");
                return;
            }
        }
        Enabled = new RegularEmitter$EmissionMode(PeerConnectionFactory.TRIAL_ENABLED, 0);
        EnabledUntilCycleEnd = new RegularEmitter$EmissionMode("EnabledUntilCycleEnd", 1);
        RegularEmitter$EmissionMode regularEmitter$EmissionMode = new RegularEmitter$EmissionMode("Disabled", 2);
        Disabled = regularEmitter$EmissionMode;
        $VALUES = new RegularEmitter$EmissionMode[]{Enabled, EnabledUntilCycleEnd, regularEmitter$EmissionMode};
    }

    public RegularEmitter$EmissionMode(String str, int i) {
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

    public static RegularEmitter$EmissionMode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (RegularEmitter$EmissionMode) Enum.valueOf(RegularEmitter$EmissionMode.class, str);
        }
        return (RegularEmitter$EmissionMode) invokeL.objValue;
    }

    public static RegularEmitter$EmissionMode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (RegularEmitter$EmissionMode[]) $VALUES.clone();
        }
        return (RegularEmitter$EmissionMode[]) invokeV.objValue;
    }
}
