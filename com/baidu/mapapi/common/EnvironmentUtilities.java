package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.e;
import com.baidubce.services.bos.BosClientConfiguration;
import java.io.File;
/* loaded from: classes10.dex */
public class EnvironmentUtilities {
    static String a;
    static String b;
    static String c;
    static int d;
    static int e;
    static int f;
    private static e g = null;

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

    public static void initAppDirectory(Context context) {
        if (g == null) {
            g = e.a();
            g.a(context);
        }
        if (a == null || a.length() <= 0) {
            a = g.b().a();
            b = g.b().c();
        } else {
            b = a + File.separator + "BaiduMapSDKNew" + File.separator + "cache";
        }
        c = g.b().d();
        d = 20971520;
        e = 52428800;
        f = BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE;
    }

    public static void setSDCardPath(String str) {
        a = str;
    }
}
