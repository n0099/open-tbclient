package com.baidu.searchbox.player.event;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class SingleTargetTrigger implements IEventTrigger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IMessenger mIMessenger;

    public SingleTargetTrigger() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mIMessenger = null;
        }
    }

    public void setMessenger(IMessenger iMessenger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iMessenger) == null) {
            this.mIMessenger = iMessenger;
        }
    }

    @Override // com.baidu.searchbox.player.event.IEventTrigger
    public void triggerEvent(VideoEvent videoEvent) {
        IMessenger iMessenger;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, videoEvent) != null) || (iMessenger = this.mIMessenger) == null) {
            return;
        }
        iMessenger.notifyEvent(videoEvent);
    }
}
