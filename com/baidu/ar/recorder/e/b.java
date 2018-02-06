package com.baidu.ar.recorder.e;

import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.recorder.encoder.EncoderParams;
/* loaded from: classes3.dex */
public class b {
    public static boolean a(EncoderParams encoderParams, AudioParams audioParams) {
        if (encoderParams == null || audioParams == null) {
            return false;
        }
        encoderParams.c(audioParams.b());
        encoderParams.d(audioParams.e());
        return true;
    }
}
