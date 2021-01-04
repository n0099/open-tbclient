package com.baidu.ala.player;

import com.baidu.ala.helper.AlaLiveDebugInfo;
/* loaded from: classes15.dex */
public interface AlaLivePlayerCallback {
    public static final int BUFFER_EVENT_MEDIA_NOT_SYNC = 0;
    public static final int BUFFER_EVENT_NET_DELAY = 1;
    public static final int BUFFER_EVENT_NO_DATA = 2;
    public static final int STREAM_CHANGED_STATUS_CONNECT_FAILED = 1;
    public static final int STREAM_CHANGED_STATUS_CONNECT_SUCCESS = 0;

    void onBufferingEvent(int i, int i2, long j, int i3);

    void onDebugInfo(int i, AlaLiveDebugInfo alaLiveDebugInfo);

    void onFastOpen(int i, int i2);

    void onFirstFrame(int i, int i2, int i3);

    void onFrameDelay(int i, int i2, int i3);

    void onStreamChanged(int i, int i2);

    void onStreamStuck(int i, int i2, int i3);
}
