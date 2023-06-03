package com.baidu.cyberplayer.sdk;

import android.util.Log;
import com.baidu.cyberplayer.sdk.statistics.YalogWrap;
/* loaded from: classes3.dex */
public class CyberLog {
    public static int a = 1;
    public static int b = 6;

    @Keep
    public static int getLogLevel() {
        return a;
    }

    public static void a(int i) {
        a = i;
    }

    public static void b(int i) {
        b = i;
    }

    @Keep
    public static void d(String str, String str2) {
        if (3 >= b) {
            YalogWrap yalogWrap = YalogWrap.getInstance();
            yalogWrap.writeYalog(3, "duplayer-" + str, str2);
        }
        if (7 - a <= 3) {
            Log.i("duplayer-" + str, str2);
        }
    }

    @Keep
    public static void e(String str, String str2) {
        if (6 >= b) {
            YalogWrap yalogWrap = YalogWrap.getInstance();
            yalogWrap.writeYalog(6, "duplayer-" + str, str2);
        }
        if (7 - a <= 6) {
            Log.e("duplayer-" + str, str2);
        }
    }

    @Keep
    public static void i(String str, String str2) {
        if (4 >= b) {
            YalogWrap yalogWrap = YalogWrap.getInstance();
            yalogWrap.writeYalog(4, "duplayer-" + str, str2);
        }
        if (7 - a <= 4) {
            Log.i("duplayer-" + str, str2);
        }
    }

    @Keep
    public static void v(String str, String str2) {
        if (2 >= b) {
            YalogWrap yalogWrap = YalogWrap.getInstance();
            yalogWrap.writeYalog(2, "duplayer-" + str, str2);
        }
        if (7 - a <= 2) {
            Log.v("duplayer-" + str, str2);
        }
    }

    @Keep
    public static void w(String str, String str2) {
        if (5 >= b) {
            YalogWrap yalogWrap = YalogWrap.getInstance();
            yalogWrap.writeYalog(5, "duplayer-" + str, str2);
        }
        if (7 - a <= 5) {
            Log.w("duplayer-" + str, str2);
        }
    }

    @Keep
    public static void e(String str, String str2, Throwable th) {
        if (6 >= b) {
            YalogWrap yalogWrap = YalogWrap.getInstance();
            yalogWrap.writeYalog(6, "duplayer-" + str, str2);
        }
        if (7 - a <= 6) {
            Log.e("duplayer-" + str, str2, th);
        }
    }

    @Keep
    public static void y(String str, String str2) {
        YalogWrap yalogWrap = YalogWrap.getInstance();
        yalogWrap.writeYalog(9, "duplayer-" + str, str2);
    }
}
