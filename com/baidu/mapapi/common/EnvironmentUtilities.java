package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.e;
import com.baidu.sapi2.SapiOptions;
import java.io.File;
/* loaded from: classes2.dex */
public class EnvironmentUtilities {

    /* renamed from: a  reason: collision with root package name */
    public static String f6762a;

    /* renamed from: b  reason: collision with root package name */
    public static String f6763b;

    /* renamed from: c  reason: collision with root package name */
    public static String f6764c;

    /* renamed from: d  reason: collision with root package name */
    public static int f6765d;

    /* renamed from: e  reason: collision with root package name */
    public static int f6766e;

    /* renamed from: f  reason: collision with root package name */
    public static int f6767f;

    /* renamed from: g  reason: collision with root package name */
    public static e f6768g;

    public static String getAppCachePath() {
        return f6763b;
    }

    public static String getAppSDCardPath() {
        String str = f6762a + "/BaiduMapSDKNew";
        if (str.length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str;
    }

    public static String getAppSecondCachePath() {
        return f6764c;
    }

    public static int getDomTmpStgMax() {
        return f6766e;
    }

    public static int getItsTmpStgMax() {
        return f6767f;
    }

    public static int getMapTmpStgMax() {
        return f6765d;
    }

    public static String getSDCardPath() {
        return f6762a;
    }

    public static void initAppDirectory(Context context) {
        String c2;
        if (f6768g == null) {
            e a2 = e.a();
            f6768g = a2;
            a2.a(context);
        }
        String str = f6762a;
        if (str == null || str.length() <= 0) {
            f6762a = f6768g.b().a();
            c2 = f6768g.b().c();
        } else {
            c2 = f6762a + File.separator + "BaiduMapSDKNew" + File.separator + SapiOptions.q;
        }
        f6763b = c2;
        f6764c = f6768g.b().d();
        f6765d = 20971520;
        f6766e = 52428800;
        f6767f = 5242880;
    }

    public static void setSDCardPath(String str) {
        f6762a = str;
    }
}
