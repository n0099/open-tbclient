package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.h;
import com.baidu.sapi2.SapiOptions;
import java.io.File;
/* loaded from: classes2.dex */
public class EnvironmentUtilities {

    /* renamed from: a  reason: collision with root package name */
    public static String f6845a;

    /* renamed from: b  reason: collision with root package name */
    public static String f6846b;

    /* renamed from: c  reason: collision with root package name */
    public static String f6847c;

    /* renamed from: d  reason: collision with root package name */
    public static int f6848d;

    /* renamed from: e  reason: collision with root package name */
    public static int f6849e;

    /* renamed from: f  reason: collision with root package name */
    public static int f6850f;

    /* renamed from: g  reason: collision with root package name */
    public static h f6851g;

    public static String getAppCachePath() {
        return f6846b;
    }

    public static String getAppSDCardPath() {
        String str = f6845a + "/BaiduMapSDKNew";
        if (str.length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str;
    }

    public static String getAppSecondCachePath() {
        return f6847c;
    }

    public static int getDomTmpStgMax() {
        return f6849e;
    }

    public static int getItsTmpStgMax() {
        return f6850f;
    }

    public static int getMapTmpStgMax() {
        return f6848d;
    }

    public static String getSDCardPath() {
        return f6845a;
    }

    public static void initAppDirectory(Context context) {
        String c2;
        if (f6851g == null) {
            h a2 = h.a();
            f6851g = a2;
            a2.a(context);
        }
        String str = f6845a;
        if (str == null || str.length() <= 0) {
            f6845a = f6851g.b().a();
            c2 = f6851g.b().c();
        } else {
            c2 = f6845a + File.separator + "BaiduMapSDKNew" + File.separator + SapiOptions.KEY_CACHE;
        }
        f6846b = c2;
        f6847c = f6851g.b().d();
        f6848d = 20971520;
        f6849e = 52428800;
        f6850f = 5242880;
    }

    public static void setSDCardPath(String str) {
        f6845a = str;
    }
}
