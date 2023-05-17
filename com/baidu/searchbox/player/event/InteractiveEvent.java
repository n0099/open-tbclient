package com.baidu.searchbox.player.event;

import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes3.dex */
public class InteractiveEvent extends VideoEvent {
    public static final String ACTION_CALL_PHONE = "interactive_event_phone";
    public static final String ACTION_CUSTOM_NOTIFY = "interactive_event_custom";
    public static final String ACTION_EVENT_RESULT = "interactive_event_result";
    public static final String ACTION_INTERACTIVE_ERROR = "interactive_event_error";
    public static final String ACTION_INTERACTIVE_FINISH = "interactive_event_finish";
    public static final String ACTION_INTERACTIVE_REPLAY_SHOW = "statistics_interactive_replay_show ";
    public static final String ACTION_INTERACTIVE_START = "interactive_event_start";
    public static final String ACTION_INTERACTIVE_VISIBLE = "interactive_event_visible";
    public static final String ACTION_JUMP_LINK = "interactive_event_url";
    public static final String ACTION_OPEN_APP = "interactive_event_open_app";
    public static final String ACTION_OPEN_SWAN = "interactive_event_open_swan";
    public static final String ACTION_REPLAY = "interactive_replay";
    public static final String ACTION_REPLAY_CURRENT_SEGMENT = "interactive_replay_current_segment";
    public static final String ACTION_SWITCH_INTERACTIVE_KERNEL = "interactive_switch_interactive_kernel";
    public static final String ACTION_VIEW_CLICK = "interactive_event_click";
    public static final String ACTION_VIEW_TOUCH_UP = "interactive_event_touch_up";
    public static final int KEY_CALL_PHONE = 5;
    public static final int KEY_CUSTOM_NOTIFY = 3;
    public static final int KEY_EVENT_RESULT = 2;
    public static final int KEY_INTERACTIVE_APP_URL = 10;
    public static final int KEY_INTERACTIVE_ERROR = 6;
    public static final int KEY_INTERACTIVE_ERROR_INFO = 7;
    public static final int KEY_INTERACTIVE_SWAN_ID = 12;
    public static final int KEY_INTERACTIVE_SWAN_PATH = 13;
    public static final int KEY_INTERACTIVE_SWITCH = 9;
    public static final int KEY_INTERACTIVE_VISIBLE = 8;
    public static final int KEY_INTERACTIVE_WEB_URL = 11;
    public static final int KEY_JUMP_LINK = 4;
    public static final int KEY_VIEW_CLICK = 1;
    public static final int KEY_VIEW_TOUCH_UP = 14;

    @PublicMethod
    public static VideoEvent obtainEvent(String str) {
        return VideoEvent.obtain(str, 8);
    }
}
