package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.h;
import com.baidu.sapi2.SapiOptions;
import java.io.File;
/* loaded from: classes2.dex */
public class EnvironmentUtilities {

    /* renamed from: a  reason: collision with root package name */
    public static String f6788a;

    /* renamed from: b  reason: collision with root package name */
    public static String f6789b;

    /* renamed from: c  reason: collision with root package name */
    public static String f6790c;

    /* renamed from: d  reason: collision with root package name */
    public static int f6791d;

    /* renamed from: e  reason: collision with root package name */
    public static int f6792e;

    /* renamed from: f  reason: collision with root package name */
    public static int f6793f;

    /* renamed from: g  reason: collision with root package name */
    public static h f6794g;

    public static String getAppCachePath() {
        return f6789b;
    }

    public static String getAppSDCardPath() {
        String str = f6788a + "/BaiduMapSDKNew";
        if (str.length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str;
    }

    public static String getAppSecondCachePath() {
        return f6790c;
    }

    public static int getDomTmpStgMax() {
        return f6792e;
    }

    public static int getItsTmpStgMax() {
        return f6793f;
    }

    public static int getMapTmpStgMax() {
        return f6791d;
    }

    public static String getSDCardPath() {
        return f6788a;
    }

    public static void initAppDirectory(Context context) {
        String c2;
        if (f6794g == null) {
            h a2 = h.a();
            f6794g = a2;
            a2.a(context);
        }
        String str = f6788a;
        if (str == null || str.length() <= 0) {
            f6788a = f6794g.b().a();
            c2 = f6794g.b().c();
        } else {
            c2 = f6788a + File.separator + "BaiduMapSDKNew" + File.separator + SapiOptions.KEY_CACHE;
        }
        f6789b = c2;
        f6790c = f6794g.b().d();
        f6791d = 20971520;
        f6792e = 52428800;
        f6793f = 5242880;
    }

    public static void setSDCardPath(String str) {
        f6788a = str;
    }
}
