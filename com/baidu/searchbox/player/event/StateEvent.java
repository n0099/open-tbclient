package com.baidu.searchbox.player.event;

import com.baidu.searchbox.player.constants.PlayerStatus;
/* loaded from: classes4.dex */
public class StateEvent extends VideoEvent {
    public static final String ACTION_STATE_CHANGED = "state_event_state_changed";
    public static final int KEY_NEW_STATUS = 2;
    public static final int KEY_OLD_STATUS = 1;

    public StateEvent() {
        super(ACTION_STATE_CHANGED);
        setType(5);
    }

    public PlayerStatus getOldStatus() {
        return getStatus(1);
    }

    public PlayerStatus getStatus() {
        return getStatus(2);
    }

    private PlayerStatus getStatus(int i) {
        return (PlayerStatus) getExtra(i);
    }

    public static VideoEvent obtainEvent(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        VideoEvent obtain = VideoEvent.obtain(ACTION_STATE_CHANGED, 5);
        obtain.putExtra(1, playerStatus);
        obtain.putExtra(2, playerStatus2);
        return obtain;
    }

    public void setStatus(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        putExtra(1, playerStatus);
        putExtra(2, playerStatus2);
    }
}
