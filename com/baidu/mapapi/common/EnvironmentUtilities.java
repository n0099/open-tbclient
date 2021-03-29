package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.e;
import com.baidu.sapi2.SapiOptions;
import java.io.File;
/* loaded from: classes2.dex */
public class EnvironmentUtilities {

    /* renamed from: a  reason: collision with root package name */
    public static String f6763a;

    /* renamed from: b  reason: collision with root package name */
    public static String f6764b;

    /* renamed from: c  reason: collision with root package name */
    public static String f6765c;

    /* renamed from: d  reason: collision with root package name */
    public static int f6766d;

    /* renamed from: e  reason: collision with root package name */
    public static int f6767e;

    /* renamed from: f  reason: collision with root package name */
    public static int f6768f;

    /* renamed from: g  reason: collision with root package name */
    public static e f6769g;

    public static String getAppCachePath() {
        return f6764b;
    }

    public static String getAppSDCardPath() {
        String str = f6763a + "/BaiduMapSDKNew";
        if (str.length() != 0) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str;
    }

    public static String getAppSecondCachePath() {
        return f6765c;
    }

    public static int getDomTmpStgMax() {
        return f6767e;
    }

    public static int getItsTmpStgMax() {
        return f6768f;
    }

    public static int getMapTmpStgMax() {
        return f6766d;
    }

    public static String getSDCardPath() {
        return f6763a;
    }

    public static void initAppDirectory(Context context) {
        String c2;
        if (f6769g == null) {
            e a2 = e.a();
            f6769g = a2;
            a2.a(context);
        }
        String str = f6763a;
        if (str == null || str.length() <= 0) {
            f6763a = f6769g.b().a();
            c2 = f6769g.b().c();
        } else {
            c2 = f6763a + File.separator + "BaiduMapSDKNew" + File.separator + SapiOptions.q;
        }
        f6764b = c2;
        f6765c = f6769g.b().d();
        f6766d = 20971520;
        f6767e = 52428800;
        f6768f = 5242880;
    }

    public static void setSDCardPath(String str) {
        f6763a = str;
    }
}
