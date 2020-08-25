package com.baidu.mapapi.common;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.util.h;
/* loaded from: classes20.dex */
public class SysOSUtil {
    public static float getDensity() {
        return h.c;
    }

    public static int getDensityDpi() {
        return h.m();
    }

    public static String getDeviceID() {
        String p = h.p();
        return TextUtils.isEmpty(p) ? p : p.substring(0, p.indexOf("|"));
    }

    public static String getModuleFileName() {
        return h.o();
    }

    public static String getPhoneType() {
        return h.h();
    }

    public static int getScreenSizeX() {
        return h.i();
    }

    public static int getScreenSizeY() {
        return h.k();
    }
}
