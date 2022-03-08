package com.baidu.searchbox.player.event;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class InternalSyncControlEvent extends ControlEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String INTERNAL_ACTION_PAUSE = "internal_sync_control_event_pause";
    public static final String INTERNAL_ACTION_PREPARE = "internal_sync_control_event_prepare";
    public static final String INTERNAL_ACTION_RESUME = "internal_sync_control_event_resume";
    public static final String INTERNAL_ACTION_START = "internal_sync_event_start";
    public static final String INTERNAL_ACTION_STOP = "internal_sync_control_event_stop";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InternalSyncControlEvent(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
