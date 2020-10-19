package com.baidu.searchbox.player.event;

import android.support.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes15.dex */
public class PlayerEvent extends VideoEvent {
    public static final String ACTION_BUFFER_UPDATE = "player_event_buffer_update";
    public static final String ACTION_EVENT_AD_SHOW = "layer_event_ad_show";
    public static final String ACTION_GO_BACK_OR_FOREGROUND = "player_event_go_back_or_foreground";
    public static final String ACTION_ON_COMPLETE = "player_event_on_complete";
    public static final String ACTION_ON_ERROR = "player_event_on_error";
    public static final String ACTION_ON_INFO = "player_event_on_info";
    public static final String ACTION_ON_PREPARED = "player_event_on_prepared";
    public static final String ACTION_PLAYER_ATTACH = "player_event_attach";
    public static final String ACTION_PLAYER_DETACH = "player_event_detach";
    public static final String ACTION_SEEK_COMPLETE = "player_event_seek_complete";
    public static final String ACTION_SET_DATA_SOURCE = "player_event_set_data";
    public static final String ACTION_VIDEO_SIZE_CHANGED = "player_event_video_size_changed";
    public static final int KEY_EXTRA = 2;
    public static final int KEY_GO_BACK_OR_FOREGROUND = 4;
    public static final int KEY_HEIGHT = 6;
    public static final int KEY_OBJECT = 3;
    public static final int KEY_WHAT = 1;
    public static final int KEY_WIDTH = 5;

    @PublicMethod
    public static VideoEvent obtainEvent(@NonNull String str) {
        return obtain(str, 4);
    }
}
