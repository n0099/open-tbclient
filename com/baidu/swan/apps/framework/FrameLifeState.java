package com.baidu.swan.apps.framework;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class FrameLifeState {
    public static final /* synthetic */ FrameLifeState[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final FrameLifeState INACTIVATED;
    public static final FrameLifeState JUST_CREATED;
    public static final FrameLifeState JUST_RESUMED;
    public static final FrameLifeState JUST_STARTED;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-511755243, "Lcom/baidu/swan/apps/framework/FrameLifeState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-511755243, "Lcom/baidu/swan/apps/framework/FrameLifeState;");
                return;
            }
        }
        INACTIVATED = new FrameLifeState("INACTIVATED", 0);
        JUST_CREATED = new FrameLifeState("JUST_CREATED", 1);
        JUST_STARTED = new FrameLifeState("JUST_STARTED", 2);
        FrameLifeState frameLifeState = new FrameLifeState("JUST_RESUMED", 3);
        JUST_RESUMED = frameLifeState;
        $VALUES = new FrameLifeState[]{INACTIVATED, JUST_CREATED, JUST_STARTED, frameLifeState};
    }

    public FrameLifeState(String str, int i) {
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

    public static FrameLifeState valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FrameLifeState) Enum.valueOf(FrameLifeState.class, str) : (FrameLifeState) invokeL.objValue;
    }

    public static FrameLifeState[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FrameLifeState[]) $VALUES.clone() : (FrameLifeState[]) invokeV.objValue;
    }

    public final boolean activated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? moreActiveThan(INACTIVATED) : invokeV.booleanValue;
    }

    public final int activatedLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ordinal() : invokeV.intValue;
    }

    public final boolean hasCreated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? noMoreInactiveThan(JUST_CREATED) : invokeV.booleanValue;
    }

    public final boolean hasResumed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? noMoreInactiveThan(JUST_RESUMED) : invokeV.booleanValue;
    }

    public final boolean hasStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? noMoreInactiveThan(JUST_STARTED) : invokeV.booleanValue;
    }

    public final boolean inactivated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? !activated() : invokeV.booleanValue;
    }

    public final boolean moreActiveThan(@NonNull FrameLifeState frameLifeState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, frameLifeState)) == null) ? compareTo(frameLifeState) > 0 : invokeL.booleanValue;
    }

    public final boolean moreInactiveThan(@NonNull FrameLifeState frameLifeState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, frameLifeState)) == null) ? compareTo(frameLifeState) < 0 : invokeL.booleanValue;
    }

    public final boolean noMoreActiveThan(@NonNull FrameLifeState frameLifeState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frameLifeState)) == null) ? !moreActiveThan(frameLifeState) : invokeL.booleanValue;
    }

    public final boolean noMoreInactiveThan(@NonNull FrameLifeState frameLifeState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, frameLifeState)) == null) ? !moreInactiveThan(frameLifeState) : invokeL.booleanValue;
    }
}
