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
public final class Animation$PlayMode {
    public static final /* synthetic */ Animation$PlayMode[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Animation$PlayMode LOOP;
    public static final Animation$PlayMode LOOP_PINGPONG;
    public static final Animation$PlayMode LOOP_RANDOM;
    public static final Animation$PlayMode LOOP_REVERSED;
    public static final Animation$PlayMode NORMAL;
    public static final Animation$PlayMode REVERSED;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1148688538, "Lcom/badlogic/gdx/graphics/g2d/Animation$PlayMode;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1148688538, "Lcom/badlogic/gdx/graphics/g2d/Animation$PlayMode;");
                return;
            }
        }
        NORMAL = new Animation$PlayMode("NORMAL", 0);
        REVERSED = new Animation$PlayMode("REVERSED", 1);
        LOOP = new Animation$PlayMode("LOOP", 2);
        LOOP_REVERSED = new Animation$PlayMode("LOOP_REVERSED", 3);
        LOOP_PINGPONG = new Animation$PlayMode("LOOP_PINGPONG", 4);
        Animation$PlayMode animation$PlayMode = new Animation$PlayMode("LOOP_RANDOM", 5);
        LOOP_RANDOM = animation$PlayMode;
        $VALUES = new Animation$PlayMode[]{NORMAL, REVERSED, LOOP, LOOP_REVERSED, LOOP_PINGPONG, animation$PlayMode};
    }

    public Animation$PlayMode(String str, int i) {
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

    public static Animation$PlayMode valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Animation$PlayMode) Enum.valueOf(Animation$PlayMode.class, str) : (Animation$PlayMode) invokeL.objValue;
    }

    public static Animation$PlayMode[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Animation$PlayMode[]) $VALUES.clone() : (Animation$PlayMode[]) invokeV.objValue;
    }
}
