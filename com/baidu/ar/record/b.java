package com.baidu.ar.record;

import android.content.Context;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public interface b {
    void onAudioFrameAvailable(ByteBuffer byteBuffer, int i2, long j);

    void onVideoFrameAvailable(long j);

    void startRecorder(Context context, EncoderParams encoderParams, MovieRecorderCallback movieRecorderCallback);

    void stopRecorder();
}
