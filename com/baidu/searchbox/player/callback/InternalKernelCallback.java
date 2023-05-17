package com.baidu.searchbox.player.callback;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.event.PlayerEventTrigger;
import com.baidu.searchbox.player.message.IMessenger;
/* loaded from: classes3.dex */
public class InternalKernelCallback extends SimpleDuMediaCallback {
    public final PlayerEventTrigger mTrigger;

    public InternalKernelCallback(@NonNull IMessenger iMessenger) {
        PlayerEventTrigger playerEventTrigger = new PlayerEventTrigger();
        this.mTrigger = playerEventTrigger;
        playerEventTrigger.setMessenger(iMessenger);
    }

    @Override // com.baidu.searchbox.player.callback.SimpleDuMediaCallback, com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onBufferingUpdate(int i) {
        this.mTrigger.onBufferingUpdate(i);
    }

    @Override // com.baidu.searchbox.player.callback.SimpleDuMediaCallback, com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onCompletion() {
        this.mTrigger.onCompletion();
    }

    @Override // com.baidu.searchbox.player.callback.SimpleDuMediaCallback, com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onPrepared() {
        this.mTrigger.onPrepared();
    }

    @Override // com.baidu.searchbox.player.callback.SimpleDuMediaCallback, com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onSeekComplete() {
        this.mTrigger.onSeekComplete();
    }

    @Override // com.baidu.searchbox.player.callback.SimpleDuMediaCallback, com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onError(int i, int i2, @Nullable Object obj) {
        this.mTrigger.onError(i, i2, obj);
        return true;
    }

    @Override // com.baidu.searchbox.player.callback.SimpleDuMediaCallback, com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onInfo(int i, int i2, @Nullable Object obj) {
        this.mTrigger.onInfo(i, i2, obj);
        return false;
    }

    @Override // com.baidu.searchbox.player.callback.SimpleDuMediaCallback, com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        this.mTrigger.onMediaSourceChanged(i, i2, obj);
        return true;
    }

    @Override // com.baidu.searchbox.player.callback.SimpleDuMediaCallback, com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        this.mTrigger.onVideoSizeChanged(i, i2, i3, i4);
    }
}
