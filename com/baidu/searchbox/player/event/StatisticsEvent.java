package com.baidu.searchbox.player.event;

import android.support.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.interfaces.INeuron;
/* loaded from: classes15.dex */
public class StatisticsEvent extends VideoEvent {
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

    @Override // com.baidu.searchbox.player.event.VideoEvent
    public boolean filter(@NonNull INeuron iNeuron) {
        return 1 != iNeuron.getType();
    }

    @PublicMethod(version = "11.24.0.0")
    public static VideoEvent obtainEvent(@NonNull String str) {
        VideoEvent obtain = obtain(str, 6);
        obtain.setTargetType(1);
        obtain.setPriority(1);
        return obtain;
    }
}
