package com.baidu.searchbox.player.component;

import android.content.Context;
import android.os.Message;
import android.support.annotation.NonNull;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.ComponentLayer;
/* loaded from: classes23.dex */
public abstract class AbsComponent implements IComponent {
    protected ComponentLayer mParent;

    public abstract void initComponent();

    @Override // com.baidu.searchbox.player.component.IComponent
    public void setParent(@NonNull ComponentLayer componentLayer) {
        this.mParent = componentLayer;
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public void sendEvent(VideoEvent videoEvent) {
        this.mParent.sendEvent(videoEvent);
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public Context getContext() {
        return this.mParent.getContentView().getContext();
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public BDVideoPlayer getVideoPlayer() {
        return this.mParent.getBindPlayer();
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public void onEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public void onLayerRelease() {
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public void onLayerDetach() {
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public void onContainerDetach() {
    }

    public boolean attachToRootAtOnce() {
        return true;
    }

    public void handleLayerMessage(Message message) {
    }

    protected void dispatchComponentEvent(VideoEvent videoEvent) {
        this.mParent.dispatcherEvent(videoEvent);
    }
}
