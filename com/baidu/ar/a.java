package com.baidu.ar;

import com.baidu.ar.audio.IEasyAudio;
import com.baidu.ar.g.n;
/* loaded from: classes12.dex */
public class a {
    public static com.baidu.ar.imu.c a() {
        return (com.baidu.ar.imu.c) n.aS("com.baidu.ar.imu.IMUController");
    }

    public static com.baidu.ar.record.b b() {
        return (com.baidu.ar.record.b) n.m("com.baidu.ar.recorder.MovieRecorder", "getInstance");
    }

    public static IEasyAudio c() {
        return (IEasyAudio) n.m("com.baidu.ar.audio.EasyAudio", "getInstance");
    }
}
