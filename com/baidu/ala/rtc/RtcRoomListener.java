package com.baidu.ala.rtc;

import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public interface RtcRoomListener {
    void onEnterRoomResult(boolean z);

    void onError(int i, String str);

    void onPeerConnectStateUpdate(int i);

    void onRoomDataMessage(ByteBuffer byteBuffer);

    void onRoomEventUpdate(int i, long j, String str);

    void onStartSpeek();

    void onStopSpeak();

    void onStreamInfoUpdate(String[] strArr);
}
