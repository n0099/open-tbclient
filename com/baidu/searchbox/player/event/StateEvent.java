package com.baidu.searchbox.player.event;

import com.baidu.searchbox.player.constants.PlayerStatus;
/* loaded from: classes19.dex */
public class StateEvent extends VideoEvent {
    private static final String ACTION_STATE_CHANGED = "state_event_state_changed";
    public static final int KEY_NEW_STATUS = 2;
    public static final int KEY_OLD_STATUS = 1;

    public StateEvent() {
        super(ACTION_STATE_CHANGED);
        setType(5);
    }

    public void setStatus(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        putExtra(1, playerStatus);
        putExtra(2, playerStatus2);
    }

    private PlayerStatus getStatus(int i) {
        return (PlayerStatus) getExtra(i);
    }

    public PlayerStatus getStatus() {
        return getStatus(2);
    }

    public PlayerStatus getOldStatus() {
        return getStatus(1);
    }

    public static VideoEvent obtainEvent() {
        return obtain(ACTION_STATE_CHANGED, 5);
    }
}
