package com.baidu.ar.record;

import android.content.Context;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public interface b {
    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i2, long j2);

    void onVideoFrameAvailable(long j2);

    void startRecorder(Context context, EncoderParams encoderParams, MovieRecorderCallback movieRecorderCallback);

    void stopRecorder();
}
