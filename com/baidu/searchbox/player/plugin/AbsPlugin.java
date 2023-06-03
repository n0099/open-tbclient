package com.baidu.searchbox.player.plugin;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import com.baidu.searchbox.player.message.IMessenger;
/* loaded from: classes4.dex */
public abstract class AbsPlugin implements IPlugin {
    public Context mContext;
    public IMessenger mMessenger;
    public PluginManager mPluginManager;

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int getExpectOrder() {
        return 0;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int getType() {
        return 1;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onInteractiveEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onLayerEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onPlayerStatusChanged(@NonNull PlayerStatus playerStatus, @NonNull PlayerStatus playerStatus2) {
    }

    @Override // com.baidu.searchbox.player.plugin.IPlugin
    public void onPluginEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.plugin.IPlugin
    public void onPluginRelease() {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onSystemEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(@NonNull VideoEvent videoEvent) {
    }

    public AbsPlugin() {
        init(null);
    }

    private void registerEvent() {
        int[] subscribeEvent = getSubscribeEvent();
        if (subscribeEvent != null && subscribeEvent.length > 0) {
            for (int i : subscribeEvent) {
                this.mMessenger.register(i, this);
            }
        }
    }

    public void detachManager() {
        this.mPluginManager = null;
    }

    public void detachMessenger() {
        IMessenger iMessenger = this.mMessenger;
        if (iMessenger != null) {
            iMessenger.unregister(this);
            this.mMessenger = null;
        }
    }

    @Nullable
    public BDVideoPlayer getBindPlayer() {
        PluginManager pluginManager = this.mPluginManager;
        if (pluginManager != null) {
            return pluginManager.getPlayer();
        }
        return null;
    }

    public Context getContext() {
        return this.mContext;
    }

    @Nullable
    public PluginManager getPluginManager() {
        return this.mPluginManager;
    }

    public AbsPlugin(@Nullable Context context) {
        init(context);
    }

    private void sendVideoEvent(VideoEvent videoEvent) {
        if (this.mMessenger != null) {
            videoEvent.setSender(this);
            this.mMessenger.notifyEvent(videoEvent);
        }
    }

    public void addInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        if (getBindPlayer() != null) {
            getBindPlayer().addInterceptor(iVideoEventInterceptor);
        }
    }

    public void attachManager(@NonNull PluginManager pluginManager) {
        this.mPluginManager = pluginManager;
    }

    public void attachMessenger(@NonNull IMessenger iMessenger) {
        this.mMessenger = iMessenger;
        registerEvent();
    }

    public void init(@Nullable Context context) {
        if (context == null) {
            this.mContext = BDPlayerConfig.getAppContext();
        } else {
            this.mContext = context;
        }
    }

    public void removeInterceptor(@NonNull IVideoEventInterceptor iVideoEventInterceptor) {
        if (getBindPlayer() != null) {
            getBindPlayer().removeInterceptor(iVideoEventInterceptor);
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void sendEvent(VideoEvent videoEvent) {
        sendVideoEvent(videoEvent);
    }
}
