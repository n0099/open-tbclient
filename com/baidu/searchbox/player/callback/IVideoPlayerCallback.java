package com.baidu.searchbox.player.callback;
/* loaded from: classes4.dex */
public interface IVideoPlayerCallback {
    void goBackOrForeground(boolean z);

    void onBufferEnd();

    void onBufferStart();

    void onEnd(int i);

    void onError(int i, int i2, String str);

    void onInfo(int i, int i2);

    void onNetworkSpeedUpdate(int i);

    void onPause();

    void onPrepared();

    void onResume();

    void onSeekEnd();

    void onStart();

    void onUpdateProgress(int i, int i2, int i3);

    void onVideoSizeChanged(int i, int i2);
}
