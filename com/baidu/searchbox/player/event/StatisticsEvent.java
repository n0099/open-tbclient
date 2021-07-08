package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class StatisticsEvent extends VideoEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_ADD_PLAY_SPEED_RECORD = "monitor_add_play_speed_record";
    public static final String ACTION_BUFFER_END = "statistics_player_buffer_end";
    public static final String ACTION_BUFFER_START = "statistics_player_buffer_start";
    public static final String ACTION_PLAYER_CARLTON = "statistics_player_carlton";
    public static final String ACTION_PLAYER_COMPLETE = "statistics_player_complete";
    public static final String ACTION_PLAYER_ERROR = "statistics_player_error";
    public static final String ACTION_PLAYER_FIRST_FRAME_DISPLAY = "statistics_player_first_frame_display";
    public static final String ACTION_PLAYER_START = "statistics_player_start";
    public static final String ACTION_PLAYER_STOP = "statistics_player_stop";
    public static final int KEY_EXTRA = 4;
    public static final int KEY_FROM = 6;
    public static final int KEY_INFO_OBJECT = 2;
    public static final int KEY_LOOP_COUNT = 1;
    public static final int KEY_PAGE = 7;
    public static final int KEY_START_TIME = 5;
    public static final int KEY_WHAT = 3;
    public transient /* synthetic */ FieldHolder $fh;

    public StatisticsEvent() {
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

    @PublicMethod(version = "11.24.0.0")
    public static VideoEvent obtainEvent(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            VideoEvent obtain = VideoEvent.obtain(str, 6);
            obtain.setTargetType(1);
            obtain.setPriority(1);
            return obtain;
        }
        return (VideoEvent) invokeL.objValue;
    }

    @Override // com.baidu.searchbox.player.event.VideoEvent
    public boolean filter(@NonNull INeuron iNeuron) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iNeuron)) == null) ? 1 != iNeuron.getType() : invokeL.booleanValue;
    }
}
