package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SystemEvent extends VideoEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_BATTERY_CHANGED = "system_event_battery_changed";
    public static final String ACTION_BLUETOOTH_HEADSET = "system_event_bluetooth_headset";
    public static final String ACTION_CLOSE_SYSTEM_DIALOGS = "system_event_net_changed";
    public static final String ACTION_CONNECT_CHANGED = "system_event_connect_changed";
    public static final String ACTION_HEADSET_PLUG = "system_event_headset_plug";
    public static final String ACTION_SCREEN_OFF = "system_event_screen_off";
    public static final String ACTION_SCREEN_ON = "system_event_screen_on";
    public static final String ACTION_VOLUME_CHANGED = "system_event_volume_changed";
    public static final int KEY_BATTERY_LEVEL = 4;
    public static final int KEY_BLUETOOTH_HEADSET_CONNECT_STATE = 6;
    public static final int KEY_CONNNECT_STATE = 1;
    public static final int KEY_HEADSET_CONNECT_STATE = 3;
    public static final int KEY_SCREEN_STATE = 2;
    public static final int KEY_VOLUME = 5;
    public transient /* synthetic */ FieldHolder $fh;

    public SystemEvent() {
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

    public static VideoEvent obtainEvent(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? VideoEvent.obtain(str, 1) : (VideoEvent) invokeL.objValue;
    }
}
