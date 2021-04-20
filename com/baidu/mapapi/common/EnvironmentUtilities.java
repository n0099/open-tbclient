package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.e;
import com.baidu.sapi2.SapiOptions;
import java.io.File;
/* loaded from: classes2.dex */
public class EnvironmentUtilities {

    /* renamed from: a  reason: collision with root package name */
    public static String f6798a;

    /* renamed from: b  reason: collision with root package name */
    public static String f6799b;

    /* renamed from: c  reason: collision with root package name */
    public static String f6800c;

    /* renamed from: d  reason: collision with root package name */
    public static int f6801d;

    /* renamed from: e  reason: collision with root package name */
    public static int f6802e;

    /* renamed from: f  reason: collision with root package name */
    public static int f6803f;

    /* renamed from: g  reason: collision with root package name */
    public static e f6804g;

    public static String getAppCachePath() {
        return f6799b;
    }

    public static String getAppSDCardPath() {
        String str = f6798a + "/BaiduMapSDKNew";
        if (str.length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str;
    }

    public static String getAppSecondCachePath() {
        return f6800c;
    }

    public static int getDomTmpStgMax() {
        return f6802e;
    }

    public static int getItsTmpStgMax() {
        return f6803f;
    }

    public static int getMapTmpStgMax() {
        return f6801d;
    }

    public static String getSDCardPath() {
        return f6798a;
    }

    public static void initAppDirectory(Context context) {
        String c2;
        if (f6804g == null) {
            e a2 = e.a();
            f6804g = a2;
            a2.a(context);
        }
        String str = f6798a;
        if (str == null || str.length() <= 0) {
            f6798a = f6804g.b().a();
            c2 = f6804g.b().c();
        } else {
            c2 = f6798a + File.separator + "BaiduMapSDKNew" + File.separator + SapiOptions.q;
        }
        f6799b = c2;
        f6800c = f6804g.b().d();
        f6801d = 20971520;
        f6802e = 52428800;
        f6803f = 5242880;
    }

    public static void setSDCardPath(String str) {
        f6798a = str;
    }
}
