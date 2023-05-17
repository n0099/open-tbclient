package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes3.dex */
public class ControlEvent extends VideoEvent {
    public static final String ACTION_CONTINUE_PLAY = "control_event_continue_play";
    public static final String ACTION_CONTINUE_TIPS_SHOW = "control_event_continue_tips_show";
    @Deprecated
    public static final String ACTION_LIVE_PAYMENT_FLOATING_PREVIEW_VIEW = "layer_event_live_payment_floating_preview_view";
    public static final String ACTION_PAUSE = "control_event_pause";
    @Deprecated
    public static final String ACTION_PAYMENT_STATUS = "control_event_payment_status";
    public static final String ACTION_PREPARE = "control_event_prepare";
    public static final String ACTION_RESUME = "control_event_resume";
    public static final String ACTION_SEEK = "control_event_seek";
    public static final String ACTION_SEEK_MS = "control_event_seek_ms";
    public static final String ACTION_SHOW_TIP = "control_event_show_tip";
    public static final String ACTION_START = "control_event_start";
    public static final String ACTION_STATUS_SYNC = "control_event_status_sync";
    public static final String ACTION_STOP = "control_event_stop";
    public static final String ACTION_SWITCH_MODE = "control_event_switch_mode";
    public static final String ACTION_SYNC_PROGRESS = "control_event_sync_progress";
    public static final int KEY_BUFFER_POSITION = 3;
    public static final int KEY_CONTINUE_PLAY = 6;
    public static final int KEY_DURATION = 2;
    public static final int KEY_HAS_GAPLESS_PLAY = 9;
    public static final int KEY_IS_HAVE_AD = 8;
    public static final int KEY_PAUSE_FROM_USER_CLICK = 7;
    public static final int KEY_PAUSE_TYPE = 11;
    @Deprecated
    public static final int KEY_PAYMENT_STATUS = 32;
    public static final int KEY_PROGRESS = 1;
    public static final int KEY_SEEK_MODE = 12;
    public static final int KEY_SEEK_PROGRESS = 5;
    public static final int KEY_SWITCH_MODE = 4;

    public ControlEvent(String str) {
        super(str);
    }

    @PublicMethod
    public static VideoEvent obtainEvent(@NonNull String str) {
        return VideoEvent.obtain(str, 2);
    }
}
