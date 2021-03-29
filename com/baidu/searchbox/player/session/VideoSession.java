package com.baidu.searchbox.player.session;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEventTrigger;
import com.baidu.searchbox.player.event.PlayerEventTrigger;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import com.baidu.searchbox.player.layer.ILayer;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.pool.IPoolItem;
/* loaded from: classes2.dex */
public final class VideoSession implements IPoolItem {
    public ControlEventTrigger mControlEventTrigger;
    public IMessenger mCourier;
    public StringBuilder mDesc;
    public PlayerEventTrigger mPlayerEventTrigger;
    public VideoKernelState mState;
    public BDVideoPlayer mTargetPlayer;

    public VideoSession() {
        init();
    }

    private void init() {
        IMessenger createMessenger = BDPlayerConfig.getMessengerFactory().createMessenger(this);
        this.mCourier = createMessenger;
        this.mState = new VideoKernelState(createMessenger);
        PlayerEventTrigger playerEventTrigger = new PlayerEventTrigger();
        this.mPlayerEventTrigger = playerEventTrigger;
        playerEventTrigger.register(this.mCourier);
        ControlEventTrigger controlEventTrigger = new ControlEventTrigger();
        this.mControlEventTrigger = controlEventTrigger;
        controlEventTrigger.register(this.mCourier);
    }

    public void bind(@NonNull BDVideoPlayer bDVideoPlayer) {
        this.mTargetPlayer = bDVideoPlayer;
    }

    @NonNull
    @PublicMethod
    public ControlEventTrigger getControlEventTrigger() {
        return this.mControlEventTrigger;
    }

    @PublicMethod
    public IMessenger getMessenger() {
        return this.mCourier;
    }

    @NonNull
    @PublicMethod
    public PlayerEventTrigger getPlayerEventTrigger() {
        return this.mPlayerEventTrigger;
    }

    @NonNull
    @PublicMethod
    public VideoKernelState getState() {
        return this.mState;
    }

    @NonNull
    @PublicMethod
    public PlayerStatus getStatus() {
        return this.mState.getStatus();
    }

    @PublicMethod
    public BDVideoPlayer getTargetPlayer() {
        return this.mTargetPlayer;
    }

    @PublicMethod
    public boolean isBindPlayer() {
        return this.mTargetPlayer != null;
    }

    @PublicMethod
    public boolean isComplete() {
        return this.mState.isComplete();
    }

    @PublicMethod
    public boolean isError() {
        return this.mState.isError();
    }

    @PublicMethod
    public boolean isPause() {
        return this.mState.isPause();
    }

    @PublicMethod
    public boolean isPlaying() {
        return this.mState.isPlaying();
    }

    @PublicMethod
    public boolean isPrepared() {
        return this.mState.isPrepared();
    }

    @PublicMethod
    public boolean isPreparing() {
        return this.mState.isPreparing();
    }

    @PublicMethod
    public boolean isStop() {
        return this.mState.isStop();
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onInit() {
        init();
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        unbind();
        IMessenger iMessenger = this.mCourier;
        if (iMessenger != null) {
            iMessenger.release();
            this.mCourier = null;
        }
        this.mPlayerEventTrigger.clear();
        this.mControlEventTrigger.clear();
    }

    @PublicMethod
    public void registerLayer(@NonNull ILayer iLayer, int i) {
        IMessenger iMessenger = this.mCourier;
        if (iMessenger != null) {
            iMessenger.register(i, iLayer);
        }
    }

    @PublicMethod
    public void sendEvent(VideoEvent videoEvent) {
        IMessenger iMessenger = this.mCourier;
        if (iMessenger != null) {
            iMessenger.notifyEvent(videoEvent);
        }
    }

    @PublicMethod
    public void setInterceptor(IVideoEventInterceptor iVideoEventInterceptor) {
        IMessenger iMessenger = this.mCourier;
        if (iMessenger != null) {
            iMessenger.setInterceptor(iVideoEventInterceptor);
        }
    }

    @PublicMethod
    public void syncSession(@NonNull VideoSession videoSession) {
        this.mTargetPlayer = videoSession.getTargetPlayer();
        this.mState.stateChangeNotify(videoSession.getStatus());
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
            sb3.append("VideoSession【TargetPlayer :");
            sb3.append(this.mTargetPlayer);
            sb3.append("，Courier :");
            sb3.append(this.mCourier);
            sb3.append("，VideoKernelState :");
            sb3.append(this.mState);
            sb3.append("，PlayerEventTrigger :");
            sb3.append(this.mPlayerEventTrigger);
            sb3.append("，ControlEventTrigger :");
            sb3.append(this.mControlEventTrigger);
            sb3.append("，hash :");
            sb3.append(hashCode());
            sb3.append("】");
            return this.mDesc.toString();
        }
        return super.toString();
    }

    public void unbind() {
        this.mTargetPlayer = null;
    }

    @PublicMethod
    public void unregisterLayer(@NonNull ILayer iLayer) {
        IMessenger iMessenger = this.mCourier;
        if (iMessenger != null) {
            iMessenger.unregister(iLayer);
        }
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        return false;
    }
}
