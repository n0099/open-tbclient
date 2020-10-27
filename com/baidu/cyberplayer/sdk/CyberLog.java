package com.baidu.cyberplayer.sdk;

import android.util.Log;
/* loaded from: classes12.dex */
public class CyberLog {

    /* renamed from: a  reason: collision with root package name */
    public static int f1339a = 1;

    public static void a(int i) {
        f1339a = i;
    }

    @Keep
    public static void d(String str, String str2) {
        if (7 - f1339a <= 3) {
            Log.i("duplayer-" + str, str2);
        }
    }

    @Keep
    public static void e(String str, String str2) {
        if (7 - f1339a <= 6) {
            Log.e("duplayer-" + str, str2);
        }
    }

    @Keep
    public static void e(String str, String str2, Throwable th) {
        if (7 - f1339a <= 6) {
            Log.e("duplayer-" + str, str2, th);
        }
    }

    @Keep
    public static int getLogLevel() {
        return f1339a;
    }

    @Keep
    public static void i(String str, String str2) {
        if (7 - f1339a <= 4) {
            Log.i("duplayer-" + str, str2);
        }
    }

    @Keep
    public static void v(String str, String str2) {
        if (7 - f1339a <= 2) {
            Log.v("duplayer-" + str, str2);
        }
    }

    @Keep
    public static void w(String str, String str2) {
        if (7 - f1339a <= 5) {
            Log.w("duplayer-" + str, str2);
        }
    }
}
