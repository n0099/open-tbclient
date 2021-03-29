package com.baidu.searchbox.player.component;

import android.content.Context;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.ComponentLayer;
/* loaded from: classes2.dex */
public abstract class AbsComponent implements IComponent {
    public ComponentLayer mParent;

    public boolean attachToRootAtOnce() {
        return true;
    }

    public void dispatchComponentEvent(VideoEvent videoEvent) {
        this.mParent.dispatcherEvent(videoEvent);
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public Context getContext() {
        return this.mParent.getContentView().getContext();
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public BDVideoPlayer getVideoPlayer() {
        return this.mParent.getBindPlayer();
    }

    public void handleLayerMessage(Message message) {
    }

    public abstract void initComponent();

    @Override // com.baidu.searchbox.player.component.IComponent
    public void onContainerDetach() {
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public void onEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public void onLayerDetach() {
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public void onLayerRelease() {
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public void sendEvent(VideoEvent videoEvent) {
        this.mParent.sendEvent(videoEvent);
    }

    @Override // com.baidu.searchbox.player.component.IComponent
    public void setParent(@NonNull ComponentLayer componentLayer) {
        this.mParent = componentLayer;
    }
}
