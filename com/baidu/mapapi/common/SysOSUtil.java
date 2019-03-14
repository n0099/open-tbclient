package com.baidu.mapapi.common;

import com.baidu.mapsdkplatform.comapi.util.f;
/* loaded from: classes5.dex */
public class SysOSUtil {
    public static float getDensity() {
        return f.y;
    }

    public static int getDensityDpi() {
        return f.l();
    }

    public static String getDeviceID() {
        return f.o();
    }

    public static String getModuleFileName() {
        return f.n();
    }

    public static String getPhoneType() {
        return f.g();
    }

    public static int getScreenSizeX() {
        return f.h();
    }

    public static int getScreenSizeY() {
        return f.j();
    }
}
