package com.baidu.rtc.camera.a;

import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
/* loaded from: classes6.dex */
public class b {
    private static b buN = new b();
    public com.baidu.rtc.camera.b.a buO;
    public int encodeWidth = 270;
    public int encodeHeight = 480;
    public int encodeBitrate = UnitedSchemeMainDispatcher.SCHEME_TIME_LIMIT;
    public int H264GOP = 2;
    public int H264FPS = 15;
    public boolean isLandscape = false;

    private b() {
    }

    public static b Nc() {
        return buN;
    }
}
