package com.baidu.ar.audio;

import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public interface EasyAudioCallback {
    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i2, long j);

    void onAudioStart(boolean z, AudioParams audioParams);

    void onAudioStop(boolean z);
}
