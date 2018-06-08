package com.baidu.ar.util;

import com.baidu.ar.audio.AudioParams;
import com.baidu.ar.recorder.d.d;
/* loaded from: classes3.dex */
public class a {
    public static boolean a(d dVar, AudioParams audioParams) {
        if (dVar == null || audioParams == null) {
            return false;
        }
        dVar.c(audioParams.getSampleRate());
        dVar.d(audioParams.getFrameSize());
        return true;
    }
}
