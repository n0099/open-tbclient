package com.baidu.ar.audio.easy;

import com.baidu.ar.audio.AudioParams;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public interface EasyAudioCallback {
    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j);

    void onAudioStart(boolean z, AudioParams audioParams);

    void onAudioStop(boolean z);
}
