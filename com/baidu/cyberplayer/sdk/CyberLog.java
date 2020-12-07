package com.baidu.cyberplayer.sdk;

import android.util.Log;
/* loaded from: classes17.dex */
public class CyberLog {

    /* renamed from: a  reason: collision with root package name */
    public static int f1343a = 1;

    public static void a(int i) {
        f1343a = i;
    }

    @Keep
    public static void d(String str, String str2) {
        if (7 - f1343a <= 3) {
            Log.i("duplayer-" + str, str2);
        }
    }

    @Keep
    public static void e(String str, String str2) {
        if (7 - f1343a <= 6) {
            Log.e("duplayer-" + str, str2);
        }
    }

    @Keep
    public static void e(String str, String str2, Throwable th) {
        if (7 - f1343a <= 6) {
            Log.e("duplayer-" + str, str2, th);
        }
    }

    @Keep
    public static int getLogLevel() {
        return f1343a;
    }

    @Keep
    public static void i(String str, String str2) {
        if (7 - f1343a <= 4) {
            Log.i("duplayer-" + str, str2);
        }
    }

    @Keep
    public static void v(String str, String str2) {
        if (7 - f1343a <= 2) {
            Log.v("duplayer-" + str, str2);
        }
    }

    @Keep
    public static void w(String str, String str2) {
        if (7 - f1343a <= 5) {
            Log.w("duplayer-" + str, str2);
        }
    }
}
