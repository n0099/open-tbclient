package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.g;
import java.io.File;
/* loaded from: classes3.dex */
public class EnvironmentUtilities {
    public static String a;
    public static String b;
    public static String c;
    public static int d;
    public static int e;
    public static int f;
    public static int g;
    public static g h;

    public static String getAppCachePath() {
        return b;
    }

    public static String getAppSDCardPath() {
        String str = a + "/BaiduMapSDKNew";
        if (str.length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str;
    }

    public static String getAppSecondCachePath() {
        return c;
    }

    public static int getDomTmpStgMax() {
        return e;
    }

    public static int getItsTmpStgMax() {
        return f;
    }

    public static int getMapTmpStgMax() {
        return d;
    }

    public static String getSDCardPath() {
        return a;
    }

    public static int getSsgTmpStgMax() {
        return g;
    }

    public static void initAppDirectory(Context context) {
        if (h == null) {
            g a2 = g.a();
            h = a2;
            a2.a(context);
        }
        String str = a;
        if (str != null && str.length() > 0) {
            b = a + File.separator + "BaiduMapSDKNew" + File.separator + "cache";
        } else {
            a = h.b().a();
            b = h.b().c();
        }
        c = h.b().d();
        d = 52428800;
        e = 52428800;
        f = 5242880;
        g = 52428800;
    }

    public static void setSDCardPath(String str) {
        a = str;
    }
}
