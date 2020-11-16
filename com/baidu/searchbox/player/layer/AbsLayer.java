package com.baidu.searchbox.player.layer;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
/* loaded from: classes11.dex */
public abstract class AbsLayer implements ILayer {
    protected Context mContext;
    private IMessenger mCourier;
    protected Handler mHandler;
    private LayerContainer mLayerContainer;

    public AbsLayer() {
        init(null);
    }

    public AbsLayer(@Nullable Context context) {
        init(context);
    }

    private void init(@Nullable Context context) {
        if (context == null) {
            this.mContext = BDPlayerConfig.getAppContext();
        } else {
            this.mContext = context;
        }
        this.mHandler = new PrivateHandler(this);
    }

    public void injectMessenger(@NonNull IMessenger iMessenger) {
        this.mCourier = iMessenger;
        registerEvent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLayerContainer(@NonNull LayerContainer layerContainer) {
        this.mLayerContainer = layerContainer;
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void initLayer() {
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void onLayerRelease() {
        BdVideoLog.d("onLayerRelease:" + this);
        this.mHandler.removeCallbacksAndMessages(null);
        this.mContext = null;
        this.mCourier = null;
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    @NonNull
    public LayerContainer getLayerContainer() {
        return this.mLayerContainer;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onSystemEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void sendEvent(VideoEvent videoEvent) {
        sendVideoEvent(videoEvent);
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int getType() {
        return 2;
    }

    protected void sendPluginEvent(VideoEvent videoEvent) {
        if (isCourierValid()) {
            videoEvent.setTargetType(1);
            this.mCourier.notifyEvent(videoEvent);
        }
    }

    private void sendVideoEvent(VideoEvent videoEvent) {
        if (isCourierValid()) {
            videoEvent.setSender(this);
            this.mCourier.notifyEvent(videoEvent);
        }
    }

    private void registerEvent() {
        int[] subscribeEvent;
        if (isCourierValid() && (subscribeEvent = getSubscribeEvent()) != null && subscribeEvent.length > 0) {
            for (int i : subscribeEvent) {
                this.mCourier.register(i, this);
            }
        }
    }

    @PublicMethod
    @NonNull
    public BDVideoPlayer getBindPlayer() {
        return this.mLayerContainer.getBindPlayer();
    }

    @PublicMethod
    public ControlEventTrigger getController() {
        return getBindPlayer().getVideoSession().getControlEventTrigger();
    }

    protected void setInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        getBindPlayer().getVideoSession().setInterceptor(iVideoEventInterceptor);
    }

    @PublicMethod
    @Nullable
    protected Activity getActivity() {
        return getBindPlayer().getActivity();
    }

    @PublicMethod
    @NonNull
    protected Context getAppContext() {
        return this.mContext.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class PrivateHandler extends Handler {
        protected WeakReference<AbsLayer> mWeakControl;

        public PrivateHandler(AbsLayer absLayer) {
            this.mWeakControl = new WeakReference<>(absLayer);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            AbsLayer absLayer = this.mWeakControl.get();
            if (absLayer != null && absLayer.getContentView() != null && absLayer.getContentView().getParent() != null) {
                absLayer.handleLayerMessage(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleLayerMessage(Message message) {
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void onLayerDetach() {
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void onContainerDetach() {
    }

    @PublicMethod
    public Handler getHandlerInnerLayer() {
        return this.mHandler;
    }

    private boolean isCourierValid() {
        return this.mCourier != null;
    }
}
