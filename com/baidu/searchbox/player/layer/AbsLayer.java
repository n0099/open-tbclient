package com.baidu.searchbox.player.layer;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEventTrigger;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.utils.BdVideoLog;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public abstract class AbsLayer implements ILayer {
    public Context mContext;
    public IMessenger mCourier;
    public Handler mHandler;
    public LayerContainer mLayerContainer;

    /* loaded from: classes3.dex */
    public static class PrivateHandler extends Handler {
        public WeakReference<AbsLayer> mWeakControl;

        public PrivateHandler(AbsLayer absLayer) {
            this.mWeakControl = new WeakReference<>(absLayer);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            AbsLayer absLayer = this.mWeakControl.get();
            if (absLayer == null || absLayer.getContentView() == null || absLayer.getContentView().getParent() == null) {
                return;
            }
            absLayer.handleLayerMessage(message);
        }
    }

    public AbsLayer() {
        init(null);
    }

    private void init(@Nullable Context context) {
        if (context == null) {
            this.mContext = BDPlayerConfig.getAppContext();
        } else {
            this.mContext = context;
        }
        this.mHandler = new PrivateHandler(this);
    }

    private boolean isCourierValid() {
        return this.mCourier != null;
    }

    private void registerEvent() {
        int[] subscribeEvent;
        if (!isCourierValid() || (subscribeEvent = getSubscribeEvent()) == null || subscribeEvent.length <= 0) {
            return;
        }
        for (int i : subscribeEvent) {
            this.mCourier.register(i, this);
        }
    }

    private void sendVideoEvent(VideoEvent videoEvent) {
        if (isCourierValid()) {
            videoEvent.setSender(this);
            this.mCourier.notifyEvent(videoEvent);
        }
    }

    @Nullable
    @PublicMethod
    public Activity getActivity() {
        return getBindPlayer().getActivity();
    }

    @NonNull
    @PublicMethod
    public Context getAppContext() {
        return this.mContext.getApplicationContext();
    }

    @NonNull
    @PublicMethod
    public BDVideoPlayer getBindPlayer() {
        return this.mLayerContainer.getBindPlayer();
    }

    @PublicMethod
    public ControlEventTrigger getController() {
        return getBindPlayer().getVideoSession().getControlEventTrigger();
    }

    @PublicMethod
    public Handler getHandlerInnerLayer() {
        return this.mHandler;
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    @NonNull
    public LayerContainer getLayerContainer() {
        return this.mLayerContainer;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int getType() {
        return 2;
    }

    public void handleLayerMessage(Message message) {
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void initLayer() {
    }

    public void injectMessenger(@NonNull IMessenger iMessenger) {
        this.mCourier = iMessenger;
        registerEvent();
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void onContainerDetach() {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void onLayerDetach() {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void onLayerRelease() {
        BdVideoLog.d("onLayerRelease:" + this);
        this.mHandler.removeCallbacksAndMessages(null);
        this.mContext = null;
        this.mCourier = null;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onSystemEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void sendEvent(VideoEvent videoEvent) {
        sendVideoEvent(videoEvent);
    }

    public void sendPluginEvent(VideoEvent videoEvent) {
        if (isCourierValid()) {
            videoEvent.setTargetType(1);
            this.mCourier.notifyEvent(videoEvent);
        }
    }

    public void setInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        getBindPlayer().getVideoSession().setInterceptor(iVideoEventInterceptor);
    }

    public void setLayerContainer(@NonNull LayerContainer layerContainer) {
        this.mLayerContainer = layerContainer;
    }

    public AbsLayer(@Nullable Context context) {
        init(context);
    }
}
