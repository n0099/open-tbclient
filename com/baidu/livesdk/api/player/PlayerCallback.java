package com.baidu.livesdk.api.player;
/* loaded from: classes4.dex */
public interface PlayerCallback {
    void onBufferEnd();

    void onBufferStart();

    void onEnded();

    void onError(int i2, int i3);

    void onInfo(int i2, int i3);

    void onInfoExtent(int i2, Object obj);

    void onPause();

    void onPrepared();

    void onResume();

    void onStart();
}
