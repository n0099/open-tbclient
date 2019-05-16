package com.baidu.mario.a;

import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public interface a {
    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i, long j);

    void onAudioRelease();

    void onAudioSetup(boolean z);

    void onAudioStart(boolean z);

    void onAudioStop(boolean z);
}
