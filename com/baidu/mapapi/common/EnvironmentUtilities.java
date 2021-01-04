package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.g;
import com.baidubce.services.bos.BosClientConfiguration;
import java.io.File;
/* loaded from: classes15.dex */
public class EnvironmentUtilities {

    /* renamed from: a  reason: collision with root package name */
    static String f2776a;

    /* renamed from: b  reason: collision with root package name */
    static String f2777b;
    static String c;
    static int d;
    static int e;
    static int f;
    static int g;
    private static g h = null;

    public static String getAppCachePath() {
        return f2777b;
    }

    public static String getAppSDCardPath() {
        String str = f2776a + "/BaiduMapSDKNew";
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
        return f2776a;
    }

    public static int getSsgTmpStgMax() {
        return g;
    }

    public static void initAppDirectory(Context context) {
        if (h == null) {
            h = g.a();
            h.a(context);
        }
        if (f2776a == null || f2776a.length() <= 0) {
            f2776a = h.b().a();
            f2777b = h.b().c();
        } else {
            f2777b = f2776a + File.separator + "BaiduMapSDKNew" + File.separator + "cache";
        }
        c = h.b().d();
        d = 52428800;
        e = 52428800;
        f = BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE;
        g = 52428800;
    }

    public static void setSDCardPath(String str) {
        f2776a = str;
    }
}
