package com.baidu.ar.audio;

import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public interface a {
    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j);

    void onAudioRelease();

    void onAudioSetup(boolean z);

    void onAudioStart(boolean z);

    void onAudioStop(boolean z);
}
