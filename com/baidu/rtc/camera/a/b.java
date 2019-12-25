package com.baidu.rtc.camera.a;
/* loaded from: classes4.dex */
public class b {
    private static b aQM = new b();
    public com.baidu.rtc.camera.b.a aQN;
    public int encodeWidth = 270;
    public int encodeHeight = 480;
    public int encodeBitrate = 600000;
    public int H264GOP = 2;
    public int H264FPS = 15;
    public boolean isLandscape = false;

    private b() {
    }

    public static b Cr() {
        return aQM;
    }
}
