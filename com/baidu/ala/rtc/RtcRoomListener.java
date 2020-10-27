package com.baidu.ala.rtc;

import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public interface RtcRoomListener {
    void onError(int i, String str);

    void onPeerConnectStateUpdate(int i);

    void onRoomDataMessage(ByteBuffer byteBuffer);

    void onRoomEventUpdate(int i, long j, String str);

    void onStartSpeek();

    void onStopSpeak();

    void onStreamInfoUpdate(String[] strArr);
}
