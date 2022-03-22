package com.baidu.livesdk.api.player;
/* loaded from: classes4.dex */
public interface PlayerCallback {
    void onBufferEnd();

    void onBufferStart();

    void onEnded();

    void onError(int i, int i2);

    void onInfo(int i, int i2);

    void onInfoExtent(int i, Object obj);

    void onPause();

    void onPrepared();

    void onResume();

    void onStart();
}
