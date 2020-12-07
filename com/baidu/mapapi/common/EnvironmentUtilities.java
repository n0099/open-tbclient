package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.g;
import com.baidubce.services.bos.BosClientConfiguration;
import java.io.File;
/* loaded from: classes26.dex */
public class EnvironmentUtilities {

    /* renamed from: a  reason: collision with root package name */
    static String f1990a;
    static String b;
    static String c;
    static int d;
    static int e;
    static int f;
    static int g;
    private static g h = null;

    public static String getAppCachePath() {
        return b;
    }

    public static String getAppSDCardPath() {
        String str = f1990a + "/BaiduMapSDKNew";
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
        return f1990a;
    }

    public static int getSsgTmpStgMax() {
        return g;
    }

    public static void initAppDirectory(Context context) {
        if (h == null) {
            h = g.a();
            h.a(context);
        }
        if (f1990a == null || f1990a.length() <= 0) {
            f1990a = h.b().a();
            b = h.b().c();
        } else {
            b = f1990a + File.separator + "BaiduMapSDKNew" + File.separator + "cache";
        }
        c = h.b().d();
        d = 52428800;
        e = 52428800;
        f = BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE;
        g = 52428800;
    }

    public static void setSDCardPath(String str) {
        f1990a = str;
    }
}
