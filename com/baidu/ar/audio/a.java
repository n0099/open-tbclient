package com.baidu.ar.audio;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public interface a {
    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i2, long j);

    void onAudioRelease();

    void onAudioSetup(boolean z);

    void onAudioStart(boolean z);

    void onAudioStop(boolean z);
}
