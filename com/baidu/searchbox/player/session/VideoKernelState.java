package com.baidu.searchbox.player.session;

import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.StateEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.message.IMessenger;
/* loaded from: classes3.dex */
public class VideoKernelState {
    private IMessenger mCourier;
    private PlayerStatus mStatus;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoKernelState(IMessenger iMessenger) {
        this.mCourier = iMessenger;
        init();
    }

    public void init() {
        this.mStatus = PlayerStatus.IDLE;
    }

    @PublicMethod
    public PlayerStatus getStatus() {
        return this.mStatus;
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
    public boolean isIdle() {
        return this.mStatus == PlayerStatus.IDLE;
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
    public boolean isPlaying() {
        return this.mStatus == PlayerStatus.PLAYING;
    }

    @PublicMethod
    public boolean isPause() {
        return this.mStatus == PlayerStatus.PAUSE;
    }

    @PublicMethod
    public boolean isStop() {
        return this.mStatus == PlayerStatus.STOP;
    }

    public void stateChangeNotify(PlayerStatus playerStatus) {
        if (playerStatus != this.mStatus) {
            this.mCourier.notifyEvent(setupEvent(this.mStatus, playerStatus));
            this.mStatus = playerStatus;
        }
    }

    private VideoEvent setupEvent(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        VideoEvent obtainEvent = StateEvent.obtainEvent();
        obtainEvent.putExtra(1, playerStatus);
        obtainEvent.putExtra(2, playerStatus2);
        return obtainEvent;
    }

    public void receivePlayerEvent(VideoEvent videoEvent) {
        if (videoEvent.getType() == 4 || videoEvent.getType() == 2) {
            String action = videoEvent.getAction();
            char c = 65535;
            switch (action.hashCode()) {
                case -525235558:
                    if (action.equals(PlayerEvent.ACTION_ON_PREPARED)) {
                        c = 2;
                        break;
                    }
                    break;
                case -461848373:
                    if (action.equals(PlayerEvent.ACTION_ON_ERROR)) {
                        c = 3;
                        break;
                    }
                    break;
                case 154871702:
                    if (action.equals(PlayerEvent.ACTION_ON_COMPLETE)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1370689931:
                    if (action.equals(PlayerEvent.ACTION_ON_INFO)) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    int intValue = ((Integer) videoEvent.getExtra(1)).intValue();
                    if (904 == intValue || 956 == intValue) {
                        stateChangeNotify(PlayerStatus.PLAYING);
                        return;
                    }
                    return;
                case 1:
                    stateChangeNotify(PlayerStatus.COMPLETE);
                    return;
                case 2:
                    stateChangeNotify(PlayerStatus.PREPARED);
                    return;
                case 3:
                    stateChangeNotify(PlayerStatus.ERROR);
                    return;
                default:
                    return;
            }
        }
    }
}
