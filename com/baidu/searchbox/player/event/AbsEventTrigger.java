package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public abstract class AbsEventTrigger implements IEventTrigger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<IMessenger> mMessengers;

    public AbsEventTrigger() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMessengers = new ArrayList<>();
    }

    @PublicMethod
    public void bindMessenger(@NonNull IMessenger iMessenger) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iMessenger) == null) || this.mMessengers.contains(iMessenger)) {
            return;
        }
        this.mMessengers.add(iMessenger);
    }

    @PublicMethod
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mMessengers.clear();
        }
    }

    @Override // com.baidu.searchbox.player.event.IEventTrigger
    @PublicMethod
    public void triggerEvent(@NonNull VideoEvent videoEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, videoEvent) == null) {
            int size = this.mMessengers.size();
            for (int i2 = 0; i2 < size; i2++) {
                IMessenger iMessenger = this.mMessengers.get(i2);
                if (i2 == 0) {
                    iMessenger.notifyEvent(videoEvent);
                } else {
                    iMessenger.notifyEvent(VideoEvent.copy(videoEvent));
                }
            }
        }
    }

    @PublicMethod
    public void unbindMessenger(@NonNull IMessenger iMessenger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iMessenger) == null) {
            this.mMessengers.remove(iMessenger);
        }
    }
}
