package com.baidu.mapapi.common;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.util.h;
/* loaded from: classes2.dex */
public class SysOSUtil {
    public static float getDensity() {
        return h.b;
    }

    public static int getDensityDpi() {
        return h.n();
    }

    public static String getDeviceID() {
        String r = h.r();
        if (TextUtils.isEmpty(r)) {
            return r;
        }
        return r.substring(0, r.indexOf("|"));
    }

    public static String getModuleFileName() {
        return h.q();
    }

    public static String getPhoneType() {
        return h.i();
    }

    public static int getScreenSizeX() {
        return h.j();
    }

    public static int getScreenSizeY() {
        return h.l();
    }
}
