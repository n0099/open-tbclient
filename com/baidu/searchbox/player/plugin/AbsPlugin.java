package com.baidu.searchbox.player.plugin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.message.IMessenger;
/* loaded from: classes8.dex */
public abstract class AbsPlugin implements IPlugin {
    private Context mContext;
    private IMessenger mCourier;
    private PluginManager mPluginManager;

    public AbsPlugin() {
        init(null);
    }

    public AbsPlugin(@Nullable Context context) {
        init(context);
    }

    protected void init(@Nullable Context context) {
        if (context == null) {
            this.mContext = BDPlayerConfig.getAppContext();
        } else {
            this.mContext = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void attachManager(@NonNull PluginManager pluginManager) {
        this.mPluginManager = pluginManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void detachManager() {
        this.mPluginManager = null;
    }

    public void attachMessenger(@NonNull IMessenger iMessenger) {
        this.mCourier = iMessenger;
        registerEvent();
    }

    public void detachMessenger() {
        this.mCourier.unregister(this);
        this.mCourier = null;
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
    @PublicMethod
    public void sendEvent(VideoEvent videoEvent) {
        sendVideoEvent(videoEvent);
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @PublicMethod
    public int getType() {
        return 1;
    }

    private void sendVideoEvent(VideoEvent videoEvent) {
        if (this.mCourier != null) {
            videoEvent.setSender(this);
            this.mCourier.notifyEvent(videoEvent);
        }
    }

    private void registerEvent() {
        int[] subscribeEvent = getSubscribeEvent();
        if (subscribeEvent != null && subscribeEvent.length > 0) {
            for (int i : subscribeEvent) {
                this.mCourier.register(i, this);
            }
        }
    }

    @PublicMethod
    @Nullable
    public BDVideoPlayer getBindPlayer() {
        if (this.mPluginManager != null) {
            return this.mPluginManager.getPlayer();
        }
        return null;
    }

    @PublicMethod
    @Nullable
    public PluginManager getPluginManager() {
        return this.mPluginManager;
    }

    @PublicMethod
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.baidu.searchbox.player.plugin.IPlugin
    public void onPluginRelease() {
    }
}
