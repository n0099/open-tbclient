package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.h;
import com.baidu.sapi2.SapiOptions;
import java.io.File;
/* loaded from: classes2.dex */
public class EnvironmentUtilities {

    /* renamed from: a  reason: collision with root package name */
    public static String f6745a;

    /* renamed from: b  reason: collision with root package name */
    public static String f6746b;

    /* renamed from: c  reason: collision with root package name */
    public static String f6747c;

    /* renamed from: d  reason: collision with root package name */
    public static int f6748d;

    /* renamed from: e  reason: collision with root package name */
    public static int f6749e;

    /* renamed from: f  reason: collision with root package name */
    public static int f6750f;

    /* renamed from: g  reason: collision with root package name */
    public static h f6751g;

    public static String getAppCachePath() {
        return f6746b;
    }

    public static String getAppSDCardPath() {
        String str = f6745a + "/BaiduMapSDKNew";
        if (str.length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str;
    }

    public static String getAppSecondCachePath() {
        return f6747c;
    }

    public static int getDomTmpStgMax() {
        return f6749e;
    }

    public static int getItsTmpStgMax() {
        return f6750f;
    }

    public static int getMapTmpStgMax() {
        return f6748d;
    }

    public static String getSDCardPath() {
        return f6745a;
    }

    public static void initAppDirectory(Context context) {
        String c2;
        if (f6751g == null) {
            h a2 = h.a();
            f6751g = a2;
            a2.a(context);
        }
        String str = f6745a;
        if (str == null || str.length() <= 0) {
            f6745a = f6751g.b().a();
            c2 = f6751g.b().c();
        } else {
            c2 = f6745a + File.separator + "BaiduMapSDKNew" + File.separator + SapiOptions.KEY_CACHE;
        }
        f6746b = c2;
        f6747c = f6751g.b().d();
        f6748d = 20971520;
        f6749e = 52428800;
        f6750f = 5242880;
    }

    public static void setSDCardPath(String str) {
        f6745a = str;
    }
}
