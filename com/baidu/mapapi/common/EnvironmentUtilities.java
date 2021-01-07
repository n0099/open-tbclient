package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.g;
import com.baidubce.services.bos.BosClientConfiguration;
import java.io.File;
/* loaded from: classes3.dex */
public class EnvironmentUtilities {

    /* renamed from: a  reason: collision with root package name */
    static String f2777a;

    /* renamed from: b  reason: collision with root package name */
    static String f2778b;
    static String c;
    static int d;
    static int e;
    static int f;
    static int g;
    private static g h = null;

    public static String getAppCachePath() {
        return f2778b;
    }

    public static String getAppSDCardPath() {
        String str = f2777a + "/BaiduMapSDKNew";
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
        return f2777a;
    }

    public static int getSsgTmpStgMax() {
        return g;
    }

    public static void initAppDirectory(Context context) {
        if (h == null) {
            h = g.a();
            h.a(context);
        }
        if (f2777a == null || f2777a.length() <= 0) {
            f2777a = h.b().a();
            f2778b = h.b().c();
        } else {
            f2778b = f2777a + File.separator + "BaiduMapSDKNew" + File.separator + "cache";
        }
        c = h.b().d();
        d = 52428800;
        e = 52428800;
        f = BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE;
        g = 52428800;
    }

    public static void setSDCardPath(String str) {
        f2777a = str;
    }
}
