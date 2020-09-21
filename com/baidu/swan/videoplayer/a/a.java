package com.baidu.swan.videoplayer.a;

import com.baidu.swan.videoplayer.SwanVideoView;
/* loaded from: classes25.dex */
public interface a {
    void h(SwanVideoView swanVideoView);

    void hk(boolean z);

    void onBufferingUpdate(int i);

    void onEnd();

    void onError(int i, int i2, String str);

    void onPause();

    void onPrepared();

    void onResume();

    void onSeekEnd();

    void onStart();

    void onVideoSizeChanged(int i, int i2);
}
