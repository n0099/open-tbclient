package com.baidu.searchbox.player.session;

import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.StateEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.message.IMessenger;
/* loaded from: classes3.dex */
public class VideoKernelState {
    public IMessenger mCourier;
    public PlayerStatus mStatus;

    public VideoKernelState(IMessenger iMessenger) {
        this.mCourier = iMessenger;
        init();
    }

    private VideoEvent setupEvent(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        VideoEvent obtainEvent = StateEvent.obtainEvent();
        obtainEvent.putExtra(1, playerStatus);
        obtainEvent.putExtra(2, playerStatus2);
        return obtainEvent;
    }

    @PublicMethod
    public PlayerStatus getStatus() {
        return this.mStatus;
    }

    public void init() {
        this.mStatus = PlayerStatus.IDLE;
    }

    @PublicMethod
    public boolean isComplete() {
        return this.mStatus == PlayerStatus.COMPLETE;
    }

    @PublicMethod
    public boolean isError() {
        return this.mStatus == PlayerStatus.ERROR;
    }

    @PublicMethod
    public boolean isIdle() {
        return this.mStatus == PlayerStatus.IDLE;
    }

    @PublicMethod
    public boolean isPause() {
        return this.mStatus == PlayerStatus.PAUSE;
    }

    @PublicMethod
    public boolean isPlaying() {
        return this.mStatus == PlayerStatus.PLAYING;
    }

    @PublicMethod
    public boolean isPrepared() {
        return this.mStatus == PlayerStatus.PREPARED;
    }

    @PublicMethod
    public boolean isPreparing() {
        return this.mStatus == PlayerStatus.PREPARING;
    }

    @PublicMethod
    public boolean isStop() {
        return this.mStatus == PlayerStatus.STOP;
    }

    public void receivePlayerEvent(VideoEvent videoEvent) {
        if (videoEvent.getType() == 4 || videoEvent.getType() == 2) {
            String action = videoEvent.getAction();
            char c2 = 65535;
            switch (action.hashCode()) {
                case -525235558:
                    if (action.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -461848373:
                    if (action.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 154871702:
                    if (action.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1370689931:
                    if (action.equals(PlayerEvent.ACTION_ON_INFO)) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                int intValue = ((Integer) videoEvent.getExtra(1)).intValue();
                if (904 == intValue || 956 == intValue) {
                    stateChangeNotify(PlayerStatus.PLAYING);
                }
            } else if (c2 == 1) {
                stateChangeNotify(PlayerStatus.COMPLETE);
            } else if (c2 == 2) {
                stateChangeNotify(PlayerStatus.PREPARED);
            } else if (c2 != 3) {
            } else {
                stateChangeNotify(PlayerStatus.ERROR);
            }
        }
    }

    public void stateChangeNotify(PlayerStatus playerStatus) {
        PlayerStatus playerStatus2 = this.mStatus;
        if (playerStatus == playerStatus2) {
            return;
        }
        this.mCourier.notifyEvent(setupEvent(playerStatus2, playerStatus));
        this.mStatus = playerStatus;
    }
}
