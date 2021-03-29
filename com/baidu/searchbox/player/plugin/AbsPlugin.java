package com.baidu.searchbox.player.plugin;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.message.IMessenger;
/* loaded from: classes2.dex */
public abstract class AbsPlugin implements IPlugin {
    public Context mContext;
    public IMessenger mCourier;
    public PluginManager mPluginManager;

    public AbsPlugin() {
        init(null);
    }

    private void registerEvent() {
        int[] subscribeEvent = getSubscribeEvent();
        if (subscribeEvent == null || subscribeEvent.length <= 0) {
            return;
        }
        for (int i : subscribeEvent) {
            this.mCourier.register(i, this);
        }
    }

    private void sendVideoEvent(VideoEvent videoEvent) {
        if (this.mCourier != null) {
            videoEvent.setSender(this);
            this.mCourier.notifyEvent(videoEvent);
        }
    }

    public void attachManager(@NonNull PluginManager pluginManager) {
        this.mPluginManager = pluginManager;
    }

    public void attachMessenger(@NonNull IMessenger iMessenger) {
        this.mCourier = iMessenger;
        registerEvent();
    }

    public void detachManager() {
        this.mPluginManager = null;
    }

    public void detachMessenger() {
        this.mCourier.unregister(this);
        this.mCourier = null;
    }

    @Nullable
    @PublicMethod
    public BDVideoPlayer getBindPlayer() {
        PluginManager pluginManager = this.mPluginManager;
        if (pluginManager != null) {
            return pluginManager.getPlayer();
        }
        return null;
    }

    @PublicMethod
    public Context getContext() {
        return this.mContext;
    }

    @Nullable
    @PublicMethod
    public PluginManager getPluginManager() {
        return this.mPluginManager;
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @PublicMethod
    public int getType() {
        return 1;
    }

    public void init(@Nullable Context context) {
        if (context == null) {
            this.mContext = BDPlayerConfig.getAppContext();
        } else {
            this.mContext = context;
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onControlEventNotify(@NonNull VideoEvent videoEvent) {
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

    @Override // com.baidu.searchbox.player.plugin.IPlugin
    public void onPluginRelease() {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onSystemEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @PublicMethod
    public void sendEvent(VideoEvent videoEvent) {
        sendVideoEvent(videoEvent);
    }

    public AbsPlugin(@Nullable Context context) {
        init(context);
    }
}
