package com.baidu.searchbox.player.session;

import android.support.annotation.NonNull;
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
/* loaded from: classes8.dex */
public final class VideoSession implements IPoolItem {
    private ControlEventTrigger mControlEventTrigger;
    private IMessenger mCourier;
    private StringBuilder mDesc;
    private PlayerEventTrigger mPlayerEventTrigger;
    private VideoKernelState mState;
    private BDVideoPlayer mTargetPlayer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoSession() {
        init();
    }

    private void init() {
        this.mCourier = BDPlayerConfig.getMessengerFactory().createMessenger(this);
        this.mState = new VideoKernelState(this.mCourier);
        this.mPlayerEventTrigger = new PlayerEventTrigger();
        this.mPlayerEventTrigger.register(this.mCourier);
        this.mControlEventTrigger = new ControlEventTrigger();
        this.mControlEventTrigger.register(this.mCourier);
    }

    @PublicMethod
    public void syncSession(@NonNull VideoSession videoSession) {
        this.mTargetPlayer = videoSession.getTargetPlayer();
        this.mState.stateChangeNotify(videoSession.getStatus());
    }

    @PublicMethod
    public IMessenger getMessenger() {
        return this.mCourier;
    }

    @PublicMethod
    @NonNull
    public VideoKernelState getState() {
        return this.mState;
    }

    @PublicMethod
    @NonNull
    public PlayerStatus getStatus() {
        return this.mState.getStatus();
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
    public boolean isComplete() {
        return this.mState.isComplete();
    }

    @PublicMethod
    public boolean isError() {
        return this.mState.isError();
    }

    @PublicMethod
    public boolean isStop() {
        return this.mState.isStop();
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
    @NonNull
    public PlayerEventTrigger getPlayerEventTrigger() {
        return this.mPlayerEventTrigger;
    }

    @PublicMethod
    @NonNull
    public ControlEventTrigger getControlEventTrigger() {
        return this.mControlEventTrigger;
    }

    @PublicMethod
    public void sendEvent(VideoEvent videoEvent) {
        if (this.mCourier != null) {
            this.mCourier.notifyEvent(videoEvent);
        }
    }

    @PublicMethod
    public void setInterceptor(IVideoEventInterceptor iVideoEventInterceptor) {
        if (this.mCourier != null) {
            this.mCourier.setInterceptor(iVideoEventInterceptor);
        }
    }

    @PublicMethod
    public void registerLayer(@NonNull ILayer iLayer, int i) {
        if (this.mCourier != null) {
            this.mCourier.register(i, iLayer);
        }
    }

    @PublicMethod
    public void unregisterLayer(@NonNull ILayer iLayer) {
        if (this.mCourier != null) {
            this.mCourier.unregister(iLayer);
        }
    }

    public void bind(@NonNull BDVideoPlayer bDVideoPlayer) {
        this.mTargetPlayer = bDVideoPlayer;
    }

    public void unbind() {
        this.mTargetPlayer = null;
    }

    @PublicMethod
    public boolean isBindPlayer() {
        return this.mTargetPlayer != null;
    }

    @PublicMethod
    public BDVideoPlayer getTargetPlayer() {
        return this.mTargetPlayer;
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onInit() {
        init();
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public void onRelease() {
        unbind();
        if (this.mCourier != null) {
            this.mCourier.release();
            this.mCourier = null;
        }
        this.mPlayerEventTrigger.clear();
        this.mControlEventTrigger.clear();
    }

    @Override // com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        return false;
    }

    public String toString() {
        if (BDPlayerConfig.isDebug()) {
            if (this.mDesc == null) {
                this.mDesc = new StringBuilder();
            } else if (this.mDesc.length() > 0) {
                this.mDesc.delete(0, this.mDesc.length());
            }
            this.mDesc.append("VideoSession【TargetPlayer :").append(this.mTargetPlayer).append("，Courier :").append(this.mCourier).append("，VideoKernelState :").append(this.mState).append("，PlayerEventTrigger :").append(this.mPlayerEventTrigger).append("，ControlEventTrigger :").append(this.mControlEventTrigger).append("，hash :").append(hashCode()).append("】");
            return this.mDesc.toString();
        }
        return super.toString();
    }
}
