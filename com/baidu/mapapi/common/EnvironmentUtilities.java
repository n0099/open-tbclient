package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.e;
import com.baidubce.services.bos.BosClientConfiguration;
import java.io.File;
/* loaded from: classes4.dex */
public class EnvironmentUtilities {

    /* renamed from: a  reason: collision with root package name */
    static String f2675a;

    /* renamed from: b  reason: collision with root package name */
    static String f2676b;
    static String c;
    static int d;
    static int e;
    static int f;
    private static e g = null;

    public static String getAppCachePath() {
        return f2676b;
    }

    public static String getAppSDCardPath() {
        String str = f2675a + "/BaiduMapSDKNew";
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
        return f2675a;
    }

    public static void initAppDirectory(Context context) {
        if (g == null) {
            g = e.a();
            g.a(context);
        }
        if (f2675a == null || f2675a.length() <= 0) {
            f2675a = g.b().a();
            f2676b = g.b().c();
        } else {
            f2676b = f2675a + File.separator + "BaiduMapSDKNew" + File.separator + "cache";
        }
        c = g.b().d();
        d = 20971520;
        e = 52428800;
        f = BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE;
    }

    public static void setSDCardPath(String str) {
        f2675a = str;
    }
}
