package com.baidu.searchbox.player.callback;
/* loaded from: classes3.dex */
public interface IVideoPlayerCallback {
    void goBackOrForeground(boolean z);

    void onBufferEnd();

    void onBufferStart();

    void onEnd(int i2);

    void onError(int i2, int i3, String str);

    void onInfo(int i2, int i3);

    void onNetworkSpeedUpdate(int i2);

    void onPause();

    void onPrepared();

    void onResume();

    void onSeekEnd();

    void onStart();

    void onUpdateProgress(int i2, int i3, int i4);

    void onVideoSizeChanged(int i2, int i3);
}
