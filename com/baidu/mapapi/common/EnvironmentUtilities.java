package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.e;
import com.baidu.sapi2.SapiOptions;
import java.io.File;
/* loaded from: classes2.dex */
public class EnvironmentUtilities {

    /* renamed from: a  reason: collision with root package name */
    public static String f7034a;

    /* renamed from: b  reason: collision with root package name */
    public static String f7035b;

    /* renamed from: c  reason: collision with root package name */
    public static String f7036c;

    /* renamed from: d  reason: collision with root package name */
    public static int f7037d;

    /* renamed from: e  reason: collision with root package name */
    public static int f7038e;

    /* renamed from: f  reason: collision with root package name */
    public static int f7039f;

    /* renamed from: g  reason: collision with root package name */
    public static e f7040g;

    public static String getAppCachePath() {
        return f7035b;
    }

    public static String getAppSDCardPath() {
        String str = f7034a + "/BaiduMapSDKNew";
        if (str.length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str;
    }

    public static String getAppSecondCachePath() {
        return f7036c;
    }

    public static int getDomTmpStgMax() {
        return f7038e;
    }

    public static int getItsTmpStgMax() {
        return f7039f;
    }

    public static int getMapTmpStgMax() {
        return f7037d;
    }

    public static String getSDCardPath() {
        return f7034a;
    }

    public static void initAppDirectory(Context context) {
        String c2;
        if (f7040g == null) {
            e a2 = e.a();
            f7040g = a2;
            a2.a(context);
        }
        String str = f7034a;
        if (str == null || str.length() <= 0) {
            f7034a = f7040g.b().a();
            c2 = f7040g.b().c();
        } else {
            c2 = f7034a + File.separator + "BaiduMapSDKNew" + File.separator + SapiOptions.KEY_CACHE;
        }
        f7035b = c2;
        f7036c = f7040g.b().d();
        f7037d = 20971520;
        f7038e = 52428800;
        f7039f = 5242880;
    }

    public static void setSDCardPath(String str) {
        f7034a = str;
    }
}
