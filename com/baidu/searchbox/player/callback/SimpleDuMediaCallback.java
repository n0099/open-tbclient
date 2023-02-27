package com.baidu.searchbox.player.callback;

import com.baidu.searchbox.player.kernel.IKernelPlayer;
/* loaded from: classes2.dex */
public class SimpleDuMediaCallback implements IKernelPlayer {
    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onBufferingUpdate(int i) {
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onCompletion() {
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onError(int i, int i2, Object obj) {
        return false;
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onInfo(int i, int i2, Object obj) {
        return false;
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        return false;
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onPrepared() {
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onSeekComplete() {
    }

    @Override // com.baidu.searchbox.player.kernel.IKernelPlayer
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
    }
}
