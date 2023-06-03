package com.baidu.searchbox.player.element;

import android.content.Context;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.layer.ElementLayer;
/* loaded from: classes4.dex */
public abstract class AbsElement implements IElement {
    public ElementLayer mParent;

    public boolean attachToRootAtOnce() {
        return true;
    }

    @Nullable
    public ViewGroup.LayoutParams getLayoutParams() {
        return null;
    }

    public void handleLayerMessage(Message message) {
    }

    public abstract void initElement();

    @Override // com.baidu.searchbox.player.element.IElement
    public void onContainerDetach() {
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public void onEventNotify(@NonNull VideoEvent videoEvent) {
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public void onLayerDetach() {
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public void onLayerRelease() {
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public void onPlayerStatusChanged(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public Context getContext() {
        return this.mParent.getContentView().getContext();
    }

    @NonNull
    public ElementLayer getParent() {
        return this.mParent;
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public BDVideoPlayer getVideoPlayer() {
        return this.mParent.getBindPlayer();
    }

    public void dispatchElementEvent(VideoEvent videoEvent) {
        this.mParent.dispatchEvent(videoEvent);
    }

    public void onParentVisibleChanged(int i) {
        getContentView().setVisibility(i);
    }

    @Override // com.baidu.searchbox.player.element.IElement
    public void sendEvent(VideoEvent videoEvent) {
        this.mParent.sendEvent(videoEvent);
    }

    public void setParent(@NonNull ElementLayer elementLayer) {
        this.mParent = elementLayer;
    }
}
