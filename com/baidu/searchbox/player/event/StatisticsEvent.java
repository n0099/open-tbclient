package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.interfaces.INeuron;
/* loaded from: classes4.dex */
public class StatisticsEvent extends VideoEvent {
    public static final String ACTION_ADD_PLAY_SPEED_RECORD = "monitor_add_play_speed_record";
    public static final String ACTION_ASYNC_REQUEST_CALLBACK = "statistics_async_request_callback";
    public static final String ACTION_AUTH_CALLBACK = "statistics_auth_callback";
    public static final String ACTION_BACK_OR_FOREGROUND = "statistics_back_or_foreground";
    public static final String ACTION_BUFFER_END = "statistics_player_buffer_end";
    public static final String ACTION_BUFFER_START = "statistics_player_buffer_start";
    public static final String ACTION_END_PREPARE_RESOURCE = "statistic_end_prepare_resource";
    public static final String ACTION_ERROR_RETRY_END = "statistics_player_error_retry_end";
    public static final String ACTION_ERROR_RETRY_START = "statistics_player_error_retry_start";
    public static final String ACTION_FLOATING_BACK = "statistics_floating_back";
    public static final String ACTION_FLOATING_CLICK = "statistics_floating_click";
    public static final String ACTION_FLOATING_DISMISS = "statistics_floating_dismiss";
    public static final String ACTION_FLOATING_DRAG_END = "statistics_floating_drag_end";
    public static final String ACTION_FLOATING_GESTURE_SCALE = "statistics_floating_gesture_scale";
    public static final String ACTION_FLOATING_PLAY_CLICK = "statistics_floating_play_click";
    public static final String ACTION_FLOATING_SCALE = "statistics_floating_scale";
    public static final String ACTION_FLOATING_SHOW = "statistics_floating_show";
    public static final String ACTION_FLOATING_SHOW_IN_APP_BACKGROUND = "statistics_floating_show_app_background";
    public static final String ACTION_FLOATING_SHOW_IN_APP_FOREGROUND = "statistics_floating_show_app_foreground";
    public static final String ACTION_FLOATING_VIDEO_SWITCH = "statistics_floating_video_switch";
    public static final String ACTION_PLAYER_CARLTON = "statistics_player_carlton";
    public static final String ACTION_PLAYER_COMPLETE = "statistics_player_complete";
    public static final String ACTION_PLAYER_ERROR = "statistics_player_error";
    public static final String ACTION_PLAYER_FIRST_FRAME_DISPLAY = "statistics_player_first_frame_display";
    public static final String ACTION_PLAYER_PAUSE = "statistics_player_pause";
    public static final String ACTION_PLAYER_RESUME = "statistics_player_resume";
    public static final String ACTION_PLAYER_START = "statistics_player_start";
    public static final String ACTION_PLAYER_STOP = "statistics_player_stop";
    public static final String ACTION_PLAY_FROM_LOCAL_CACHE = "statistic_play_from_local_cache";
    public static final String ACTION_START_PREPARE_RESOURCE = "statistic_start_prepare_resource";
    public static final String ACTION_UPDATE_CONTENT = "statistics_update_content";
    public static final int KEY_AUTH_TYPE = 16;
    public static final int KEY_EXTRA = 4;
    public static final int KEY_FLOATING_APP_FOREGROUND = 18;
    public static final int KEY_FLOATING_POSITION_X = 11;
    public static final int KEY_FLOATING_POSITION_Y = 12;
    public static final int KEY_FLOATING_SCALE_ENLARGE = 10;
    public static final int KEY_FLOATING_SCALE_LEVEL = 9;
    public static final int KEY_FOREGROUND_STATUS = 8;
    public static final int KEY_FROM = 6;
    public static final int KEY_IGNORE_SCHEME = 15;
    public static final int KEY_INFO_OBJECT = 2;
    public static final int KEY_LOOP_COUNT = 1;
    public static final int KEY_MPD_TYPE = 14;
    public static final int KEY_PAGE = 7;
    public static final int KEY_PLAY_LOCAL_CACHE_SIZE = 19;
    public static final int KEY_SOURCE = 17;
    public static final int KEY_START_TIME = 5;
    public static final int KEY_UPDATE_CONTENT = 13;
    public static final int KEY_WHAT = 3;

    public static VideoEvent obtainEvent(@NonNull String str) {
        VideoEvent obtain = VideoEvent.obtain(str, 6);
        obtain.setTargetType(1);
        obtain.setPriority(1);
        return obtain;
    }

    @Override // com.baidu.searchbox.player.event.VideoEvent
    public boolean filter(@NonNull INeuron iNeuron) {
        if (1 != iNeuron.getType()) {
            return true;
        }
        return false;
    }
}
