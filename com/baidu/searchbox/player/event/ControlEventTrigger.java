package com.baidu.searchbox.player.event;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ControlEventTrigger extends SingleTargetTrigger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ControlEventTrigger() {
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

    @PublicMethod
    public void prepare() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_PREPARE));
        }
    }

    @PublicMethod
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_RESUME));
        }
    }

    @PublicMethod
    public void resumeContinuePlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_CONTINUE_PLAY);
            obtainEvent.putExtra(6, Boolean.TRUE);
            triggerEvent(obtainEvent);
        }
    }

    @PublicMethod
    public void showGaplessPlayTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_CONTINUE_TIPS_SHOW);
            obtainEvent.putExtra(9, Boolean.TRUE);
            triggerEvent(obtainEvent);
        }
    }

    @PublicMethod
    public void showNetTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_SHOW_TIP));
        }
    }

    @PublicMethod
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_START));
        }
    }

    @PublicMethod
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            triggerEvent(ControlEvent.obtainEvent(ControlEvent.ACTION_STOP));
        }
    }

    @PublicMethod
    public void stopContinuePlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_CONTINUE_PLAY);
            obtainEvent.putExtra(6, Boolean.FALSE);
            triggerEvent(obtainEvent);
        }
    }

    @PublicMethod
    public void pause(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_PAUSE);
            obtainEvent.putExtra(11, Integer.valueOf(i));
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            obtainEvent.putExtra(7, Boolean.valueOf(z));
            triggerEvent(obtainEvent);
        }
    }

    @PublicMethod
    public void showNextVideoTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_CONTINUE_TIPS_SHOW);
            obtainEvent.putExtra(8, Boolean.valueOf(z));
            triggerEvent(obtainEvent);
        }
    }

    @PublicMethod
    public void switchMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_SWITCH_MODE);
            obtainEvent.putExtra(4, Boolean.valueOf(z));
            triggerEvent(obtainEvent);
        }
    }

    @PublicMethod
    public void pause(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_PAUSE);
            obtainEvent.putExtra(7, Boolean.valueOf(z));
            triggerEvent(obtainEvent);
        }
    }

    @PublicMethod
    public void seekToMs(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_SEEK_MS);
            obtainEvent.putExtra(5, Integer.valueOf(i));
            obtainEvent.putExtra(12, Integer.valueOf(i2));
            triggerEvent(obtainEvent);
        }
    }

    @PublicMethod
    public void syncPos(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i, i2, i3) == null) {
            VideoEvent obtainEvent = ControlEvent.obtainEvent(ControlEvent.ACTION_SYNC_PROGRESS);
            obtainEvent.putExtra(1, Integer.valueOf(i));
            obtainEvent.putExtra(2, Integer.valueOf(i2));
            obtainEvent.putExtra(3, Integer.valueOf(i3));
            obtainEvent.setLogLevel(1);
            triggerEvent(obtainEvent);
        }
    }
}
