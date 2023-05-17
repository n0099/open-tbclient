package com.baidu.searchbox.player.session;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEventTrigger;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.searchbox.player.event.StateEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.message.IMessenger;
/* loaded from: classes3.dex */
public final class VideoSession {
    public StringBuilder mDesc;
    @Nullable
    public IMessenger mMessenger;
    public PlayerStatus mStatus = PlayerStatus.IDLE;
    public ControlEventTrigger mControlEventTrigger = new ControlEventTrigger();

    private void init() {
    }

    public VideoSession() {
        init();
    }

    @Deprecated
    public ControlEventTrigger getControlEventTrigger() {
        return this.mControlEventTrigger;
    }

    @Nullable
    @PublicMethod
    public IMessenger getMessenger() {
        return this.mMessenger;
    }

    @NonNull
    @PublicMethod
    public PlayerStatus getStatus() {
        return this.mStatus;
    }

    @PublicMethod
    public boolean isComplete() {
        if (this.mStatus == PlayerStatus.COMPLETE) {
            return true;
        }
        return false;
    }

    @PublicMethod
    public boolean isError() {
        if (this.mStatus == PlayerStatus.ERROR) {
            return true;
        }
        return false;
    }

    @PublicMethod
    public boolean isIdle() {
        if (this.mStatus == PlayerStatus.IDLE) {
            return true;
        }
        return false;
    }

    @PublicMethod
    public boolean isPause() {
        if (this.mStatus == PlayerStatus.PAUSE) {
            return true;
        }
        return false;
    }

    @PublicMethod
    public boolean isPlaying() {
        if (this.mStatus == PlayerStatus.PLAYING) {
            return true;
        }
        return false;
    }

    @PublicMethod
    public boolean isPrepared() {
        if (this.mStatus == PlayerStatus.PREPARED) {
            return true;
        }
        return false;
    }

    @PublicMethod
    public boolean isPreparing() {
        if (this.mStatus == PlayerStatus.PREPARING) {
            return true;
        }
        return false;
    }

    @PublicMethod
    public boolean isStop() {
        if (this.mStatus == PlayerStatus.STOP) {
            return true;
        }
        return false;
    }

    public void reset() {
        unbindMessenger();
        this.mStatus = PlayerStatus.IDLE;
    }

    public void unbindMessenger() {
        this.mMessenger = null;
    }

    public void accessEventNotify(VideoEvent videoEvent) {
        if (videoEvent.getType() != 4 && videoEvent.getType() != 2) {
            return;
        }
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
        if (c != 0) {
            if (c != 1) {
                if (c != 2) {
                    if (c == 3) {
                        statusChangeNotify(PlayerStatus.ERROR);
                        return;
                    }
                    return;
                }
                statusChangeNotify(PlayerStatus.PREPARED);
                return;
            }
            statusChangeNotify(PlayerStatus.COMPLETE);
            return;
        }
        int intExtra = videoEvent.getIntExtra(1);
        if (904 == intExtra || 956 == intExtra) {
            statusChangeNotify(PlayerStatus.PLAYING);
        }
    }

    public void bindMessenger(@NonNull IMessenger iMessenger) {
        this.mMessenger = iMessenger;
    }

    public boolean matchStatus(@NonNull PlayerStatus... playerStatusArr) {
        for (PlayerStatus playerStatus : playerStatusArr) {
            if (playerStatus == getStatus()) {
                return true;
            }
        }
        return false;
    }

    public void statusChangeNotify(PlayerStatus playerStatus) {
        PlayerStatus playerStatus2 = this.mStatus;
        if (playerStatus == playerStatus2) {
            return;
        }
        this.mStatus = playerStatus;
        IMessenger iMessenger = this.mMessenger;
        if (iMessenger != null) {
            iMessenger.notifyEvent(StateEvent.obtainEvent(playerStatus2, playerStatus));
        }
    }

    public String toString() {
        if (BDPlayerConfig.isDebug()) {
            StringBuilder sb = this.mDesc;
            if (sb == null) {
                this.mDesc = new StringBuilder();
            } else if (sb.length() > 0) {
                StringBuilder sb2 = this.mDesc;
                sb2.delete(0, sb2.length());
            }
            StringBuilder sb3 = this.mDesc;
            sb3.append("，Courier :");
            sb3.append(this.mMessenger);
            sb3.append("，status :");
            sb3.append(this.mStatus);
            sb3.append("，hash :");
            sb3.append(hashCode());
            sb3.append("】");
            return this.mDesc.toString();
        }
        return super.toString();
    }
}
