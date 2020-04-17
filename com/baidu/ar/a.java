package com.baidu.ar;

import com.baidu.ar.audio.IEasyAudio;
import com.baidu.ar.f.l;
/* loaded from: classes3.dex */
public class a {
    public static com.baidu.ar.imu.c a() {
        return (com.baidu.ar.imu.c) l.aN("com.baidu.ar.imu.IMUController");
    }

    public static com.baidu.ar.record.b b() {
        return (com.baidu.ar.record.b) l.k("com.baidu.ar.recorder.MovieRecorder", "getInstance");
    }

    public static IEasyAudio c() {
        return (IEasyAudio) l.k("com.baidu.ar.audio.EasyAudio", "getInstance");
    }
}
