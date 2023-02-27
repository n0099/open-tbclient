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
/* loaded from: classes2.dex */
public abstract class AbsLayer implements ILayer {
    public Context mContext;
    public Handler mHandler;
    public LayerContainer mLayerContainer;
    @Nullable
    public IMessenger mMessenger;

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int getExpectOrder() {
        return 0;
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

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void onContainerDetach() {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onInteractiveEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void onLayerDetach() {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(@NonNull VideoEvent videoEvent) {
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

    /* loaded from: classes2.dex */
    public static class PrivateHandler extends Handler {
        public final WeakReference<AbsLayer> mWeakControl;

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

    public AbsLayer() {
        init(null);
    }

    private boolean isMessengerValid() {
        if (this.mMessenger != null) {
            return true;
        }
        return false;
    }

    private void registerEvent() {
        int[] subscribeEvent;
        if (isMessengerValid() && (subscribeEvent = getSubscribeEvent()) != null && subscribeEvent.length > 0) {
            for (int i : subscribeEvent) {
                this.mMessenger.register(i, this);
            }
        }
    }

    public void detachMessenger() {
        IMessenger iMessenger = this.mMessenger;
        if (iMessenger != null) {
            iMessenger.unregister(this);
            this.mMessenger = null;
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

    @PublicMethod
    public BDVideoPlayer getBindPlayer() {
        LayerContainer layerContainer = this.mLayerContainer;
        if (layerContainer != null) {
            return layerContainer.getBindPlayer();
        }
        return null;
    }

    @PublicMethod
    public ControlEventTrigger getController() {
        return getBindPlayer().getControlEventTrigger();
    }

    @PublicMethod
    public Handler getHandlerInnerLayer() {
        return this.mHandler;
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public LayerContainer getLayerContainer() {
        return this.mLayerContainer;
    }

    @Nullable
    public IMessenger getMessenger() {
        return this.mMessenger;
    }

    @Override // com.baidu.searchbox.player.layer.ILayer
    public void onLayerRelease() {
        BdVideoLog.d("onLayerRelease() = " + this);
        this.mHandler.removeCallbacksAndMessages(null);
        this.mContext = null;
        this.mMessenger = null;
    }

    public AbsLayer(@Nullable Context context) {
        BdVideoLog.d("AbsLayer(context@" + System.identityHashCode(context) + ") = " + this);
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

    private void sendVideoEvent(VideoEvent videoEvent) {
        if (isMessengerValid()) {
            videoEvent.setSender(this);
            this.mMessenger.notifyEvent(videoEvent);
        }
    }

    public void addInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        getBindPlayer().addInterceptor(iVideoEventInterceptor);
    }

    public void attachMessenger(@NonNull IMessenger iMessenger) {
        this.mMessenger = iMessenger;
        registerEvent();
    }

    public void removeInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        getBindPlayer().removeInterceptor(iVideoEventInterceptor);
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void sendEvent(VideoEvent videoEvent) {
        sendVideoEvent(videoEvent);
    }

    public void sendPluginEvent(VideoEvent videoEvent) {
        if (isMessengerValid()) {
            videoEvent.setTargetType(1);
            this.mMessenger.notifyEvent(videoEvent);
        }
    }

    public void setInterceptor(@Nullable IVideoEventInterceptor iVideoEventInterceptor) {
        getBindPlayer().setInterceptor(iVideoEventInterceptor);
    }

    public void setLayerContainer(@NonNull LayerContainer layerContainer) {
        this.mLayerContainer = layerContainer;
    }

    public void addInterceptor(int i, @NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        getBindPlayer().addInterceptor(i, iVideoEventInterceptor);
    }
}
