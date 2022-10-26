package com.baidu.searchbox.player.event;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.VideoReceiver;
import com.baidu.searchbox.player.helper.NetUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class SystemEventTrigger extends AbsEventTrigger implements VideoReceiver.VideoReceiverListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final VideoReceiver mVideoReceiver;

    public SystemEventTrigger() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mVideoReceiver = new VideoReceiver(this);
    }

    @Override // com.baidu.searchbox.player.event.VideoReceiver.VideoReceiverListener
    public void onConfigurationChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            triggerEvent(SystemEvent.obtainEvent(SystemEvent.ACTION_CONFIGURATION_CHANGED));
        }
    }

    public void registerReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                this.mVideoReceiver.registerReceiver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.mVideoReceiver.unregisterReceiver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.player.event.VideoReceiver.VideoReceiverListener
    public void onBatteryChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            VideoEvent obtainEvent = SystemEvent.obtainEvent(SystemEvent.ACTION_BATTERY_CHANGED);
            obtainEvent.setLogLevel(1);
            obtainEvent.putExtra(4, Integer.valueOf(i));
            triggerEvent(obtainEvent);
        }
    }

    @Override // com.baidu.searchbox.player.event.VideoReceiver.VideoReceiverListener
    public void onBluetoothHeadsetChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            VideoEvent obtainEvent = SystemEvent.obtainEvent(SystemEvent.ACTION_BLUETOOTH_HEADSET);
            obtainEvent.putExtra(6, Boolean.valueOf(z));
            triggerEvent(obtainEvent);
        }
    }

    @Override // com.baidu.searchbox.player.event.VideoReceiver.VideoReceiverListener
    public void onHeadsetPlug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            VideoEvent obtainEvent = SystemEvent.obtainEvent(SystemEvent.ACTION_HEADSET_PLUG);
            obtainEvent.putExtra(3, Boolean.valueOf(z));
            triggerEvent(obtainEvent);
        }
    }

    @Override // com.baidu.searchbox.player.event.VideoReceiver.VideoReceiverListener
    public void onScreenStatusChanged(boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                str = SystemEvent.ACTION_SCREEN_OFF;
            } else {
                str = SystemEvent.ACTION_SCREEN_ON;
            }
            VideoEvent obtainEvent = SystemEvent.obtainEvent(str);
            obtainEvent.putExtra(2, Boolean.valueOf(z));
            triggerEvent(obtainEvent);
        }
    }

    @Override // com.baidu.searchbox.player.event.VideoReceiver.VideoReceiverListener
    public void onVolumeChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            VideoEvent obtainEvent = SystemEvent.obtainEvent(SystemEvent.ACTION_VOLUME_CHANGED);
            obtainEvent.putExtra(5, Integer.valueOf(i));
            triggerEvent(obtainEvent);
        }
    }

    @Override // com.baidu.searchbox.player.event.VideoReceiver.VideoReceiverListener
    public void onConnectChanged(NetUtils.NetStatus netStatus, NetUtils.NetStatus netStatus2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, netStatus, netStatus2) == null) {
            VideoEvent obtainEvent = SystemEvent.obtainEvent(SystemEvent.ACTION_CONNECT_CHANGED);
            obtainEvent.putExtra(1, netStatus2);
            triggerEvent(obtainEvent);
        }
    }
}
