package com.baidu.searchbox.player.event;

import android.graphics.Point;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class StatisticsEventTrigger extends SingleTargetTrigger {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int KEY_LOOP_COUNT = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public StatisticsEventTrigger() {
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

    public void onError(int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, obj) == null) {
            VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_ERROR);
            obtainEvent.putExtra(2, String.valueOf(obj));
            obtainEvent.putExtra(4, Integer.valueOf(i3));
            triggerEvent(obtainEvent);
        }
    }

    public void onFloatingClick(String str, Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, point) == null) {
            VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_FLOATING_CLICK);
            obtainEvent.putExtra(9, str);
            obtainEvent.putExtra(11, Integer.valueOf(point.x));
            obtainEvent.putExtra(12, Integer.valueOf(point.y));
            triggerEvent(obtainEvent);
        }
    }

    public void onFloatingDismiss(String str, Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, point) == null) {
            VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_FLOATING_DISMISS);
            obtainEvent.putExtra(9, str);
            obtainEvent.putExtra(11, Integer.valueOf(point.x));
            obtainEvent.putExtra(12, Integer.valueOf(point.y));
            triggerEvent(obtainEvent);
        }
    }

    public void onFloatingScale(boolean z, String str, Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), str, point}) == null) {
            VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_FLOATING_SCALE);
            obtainEvent.putExtra(10, Boolean.valueOf(z));
            obtainEvent.putExtra(9, str);
            obtainEvent.putExtra(11, Integer.valueOf(point.x));
            obtainEvent.putExtra(12, Integer.valueOf(point.y));
            triggerEvent(obtainEvent);
        }
    }

    public void onFloatingShow(String str, Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, point) == null) {
            VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_FLOATING_SHOW);
            obtainEvent.putExtra(9, str);
            obtainEvent.putExtra(11, Integer.valueOf(point.x));
            obtainEvent.putExtra(12, Integer.valueOf(point.y));
            triggerEvent(obtainEvent);
        }
    }

    public void onInfo(int i2, int i3, Object obj) {
        VideoEvent obtainEvent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, obj) == null) {
            if (i2 == 701) {
                obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_BUFFER_START);
            } else if (i2 == 702) {
                obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_BUFFER_END);
            } else if (i2 == 904 || i2 == 956) {
                obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_FIRST_FRAME_DISPLAY);
                obtainEvent.putExtra(2, String.valueOf(obj));
            } else if (i2 == 10009) {
                obtainEvent = StatisticsEvent.obtainEvent("statistics_player_carlton");
                obtainEvent.putExtra(2, String.valueOf(obj));
            } else if (i2 != 11004) {
                obtainEvent = i2 != 11005 ? null : StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_ERROR_RETRY_END);
            } else {
                obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_ERROR_RETRY_START);
                obtainEvent.putExtra(4, Integer.valueOf(i3));
            }
            if (obtainEvent != null) {
                triggerEvent(obtainEvent);
            }
        }
    }

    public void onPlayerBackOrForeground(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_BACK_OR_FOREGROUND);
            obtainEvent.putExtra(8, Boolean.valueOf(z));
            triggerEvent(obtainEvent);
        }
    }

    public void onPlayerComplete(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_COMPLETE);
            obtainEvent.putExtra(1, Integer.valueOf(i2));
            triggerEvent(obtainEvent);
        }
    }

    public void onPlayerPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            triggerEvent(StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_PAUSE));
        }
    }

    public void onPlayerResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            triggerEvent(StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_RESUME));
        }
    }

    public void onPlayerStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            triggerEvent(StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_START));
        }
    }

    public void onPlayerStop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_STOP);
            obtainEvent.putExtra(1, Integer.valueOf(i2));
            triggerEvent(obtainEvent);
        }
    }
}
