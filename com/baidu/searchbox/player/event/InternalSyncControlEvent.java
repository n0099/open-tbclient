package com.baidu.searchbox.player.event;
/* loaded from: classes4.dex */
public class InternalSyncControlEvent extends ControlEvent {
    public static final String INTERNAL_ACTION_PAUSE = "internal_sync_control_event_pause";
    public static final String INTERNAL_ACTION_PREPARE = "internal_sync_control_event_prepare";
    public static final String INTERNAL_ACTION_RESUME = "internal_sync_control_event_resume";
    public static final String INTERNAL_ACTION_START = "internal_sync_event_start";
    public static final String INTERNAL_ACTION_STOP = "internal_sync_control_event_stop";

    public InternalSyncControlEvent(String str) {
        super(str);
    }
}
