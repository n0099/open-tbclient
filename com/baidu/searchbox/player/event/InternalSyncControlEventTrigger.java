package com.baidu.searchbox.player.event;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class InternalSyncControlEventTrigger extends SingleTargetTrigger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public InternalSyncControlEventTrigger() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @PublicMethod
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            VideoEvent obtainEvent = ControlEvent.obtainEvent(InternalSyncControlEvent.INTERNAL_ACTION_PAUSE);
            obtainEvent.setPriority(1);
            triggerEvent(obtainEvent);
        }
    }

    @PublicMethod
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            VideoEvent obtainEvent = ControlEvent.obtainEvent(InternalSyncControlEvent.INTERNAL_ACTION_PREPARE);
            obtainEvent.setPriority(1);
            triggerEvent(obtainEvent);
        }
    }

    @PublicMethod
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            VideoEvent obtainEvent = ControlEvent.obtainEvent(InternalSyncControlEvent.INTERNAL_ACTION_RESUME);
            obtainEvent.setPriority(1);
            triggerEvent(obtainEvent);
        }
    }

    @PublicMethod
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            VideoEvent obtainEvent = ControlEvent.obtainEvent(InternalSyncControlEvent.INTERNAL_ACTION_START);
            obtainEvent.setPriority(1);
            triggerEvent(obtainEvent);
        }
    }

    @PublicMethod
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            VideoEvent obtainEvent = ControlEvent.obtainEvent(InternalSyncControlEvent.INTERNAL_ACTION_STOP);
            obtainEvent.setPriority(1);
            triggerEvent(obtainEvent);
        }
    }
}
