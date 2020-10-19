package com.baidu.searchbox.player.event;

import android.support.annotation.NonNull;
/* loaded from: classes15.dex */
public class SystemEvent extends VideoEvent {
    public static final String ACTION_BATTERY_CHANGED = "system_event_battery_changed";
    public static final String ACTION_BLUETOOTH_HEADSET = "system_event_bluetooth_headset";
    public static final String ACTION_CLOSE_SYSTEM_DIALOGS = "system_event_net_changed";
    public static final String ACTION_CONNECT_CHANGED = "system_event_connect_changed";
    public static final String ACTION_HEADSET_PLUG = "system_event_headset_plug";
    public static final String ACTION_SCREEN_OFF = "system_event_screen_off";
    public static final String ACTION_SCREEN_ON = "system_event_screen_on";
    public static final String ACTION_VOLUME_CHANGED = "system_event_volume_changed";
    public static final int KEY_BATTERY_LEVEL = 4;
    public static final int KEY_BLUETOOTH_HEADSET_CONNECT_STATE = 6;
    public static final int KEY_CONNNECT_STATE = 1;
    public static final int KEY_HEADSET_CONNECT_STATE = 3;
    public static final int KEY_SCREEN_STATE = 2;
    public static final int KEY_VOLUME = 5;

    public static VideoEvent obtainEvent(@NonNull String str) {
        return obtain(str, 1);
    }
}
