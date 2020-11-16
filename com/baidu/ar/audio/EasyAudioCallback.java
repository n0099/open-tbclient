package com.baidu.ar.audio;

import java.nio.ByteBuffer;
/* loaded from: classes12.dex */
public interface EasyAudioCallback {
    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j);

    void onAudioStart(boolean z, AudioParams audioParams);

    void onAudioStop(boolean z);
}
