package com.baidu.searchbox.player.kernel;
/* loaded from: classes11.dex */
public interface IKernelPlayer {
    void onBufferingUpdate(int i2);

    void onCompletion();

    boolean onError(int i2, int i3, Object obj);

    boolean onInfo(int i2, int i3, Object obj);

    boolean onMediaSourceChanged(int i2, int i3, Object obj);

    void onPrepared();

    void onSeekComplete();

    void onVideoSizeChanged(int i2, int i3, int i4, int i5);
}
