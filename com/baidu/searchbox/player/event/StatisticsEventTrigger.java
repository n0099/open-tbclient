package com.baidu.searchbox.player.event;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
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

    public void onInfo(int i2, int i3, Object obj) {
        VideoEvent obtainEvent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, obj) == null) {
            if (i2 == 701) {
                obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_BUFFER_START);
            } else if (i2 == 702) {
                obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_BUFFER_END);
            } else if (i2 == 904 || i2 == 956) {
                obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_FIRST_FRAME_DISPLAY);
                obtainEvent.putExtra(2, String.valueOf(obj));
            } else if (i2 != 10009) {
                obtainEvent = null;
            } else {
                obtainEvent = StatisticsEvent.obtainEvent("statistics_player_carlton");
                obtainEvent.putExtra(2, String.valueOf(obj));
            }
            if (obtainEvent != null) {
                triggerEvent(obtainEvent);
            }
        }
    }

    public void onPlayerComplete(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_COMPLETE);
            obtainEvent.putExtra(1, Integer.valueOf(i2));
            triggerEvent(obtainEvent);
        }
    }

    public void onPlayerStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            triggerEvent(StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_START));
        }
    }

    public void onPlayerStop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            VideoEvent obtainEvent = StatisticsEvent.obtainEvent(StatisticsEvent.ACTION_PLAYER_STOP);
            obtainEvent.putExtra(1, Integer.valueOf(i2));
            triggerEvent(obtainEvent);
        }
    }
}
