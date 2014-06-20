package com.baidu.android.systemmonitor.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class a {
    private static int a;
    private static String b;
    private static int c;
    private static int d;
    private static int e;
    private static int f;
    private static int g;
    private static int h;
    private static int i;
    private static int j;
    private static int k;
    private static int l;
    private static int m;
    private static int n = -1;
    private static int o;
    private static int p;
    private static int q;
    private static int r;
    private static int s;
    private static String t;
    private static String u;
    private static String v;
    private static String w;
    private static String x;

    static {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        a = 0;
        b = null;
        c = 0;
        d = 0;
        e = -1;
        f = 0;
        g = -1;
        h = -1;
        i = -1;
        j = -1;
        k = 0;
        l = 0;
        m = -1;
        o = -1;
        p = -1;
        q = -1;
        r = -1;
        s = -1;
        t = "";
        u = null;
        v = null;
        w = null;
        x = null;
        File file = new File(Environment.getExternalStorageDirectory(), "sysmonitor.cfg");
        if (!file.exists()) {
            return;
        }
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                properties.load(fileInputStream);
                if (properties.getProperty("uefilesize") != null) {
                    a = Integer.valueOf(properties.getProperty("uefilesize")).intValue();
                }
                if (properties.getProperty("server") != null) {
                    b = String.valueOf(properties.getProperty("server"));
                }
                if (properties.getProperty("freqcountday") != null) {
                    d = Integer.valueOf(properties.getProperty("freqcountday")).intValue();
                }
                if (properties.getProperty("sdk_int") != null) {
                    c = Integer.valueOf(properties.getProperty("sdk_int")).intValue();
                }
                if (properties.getProperty("statistictype") != null) {
                    e = Integer.valueOf(properties.getProperty("statistictype")).intValue();
                }
                if (properties.getProperty("restartstatisticafter") != null) {
                    f = Integer.valueOf(properties.getProperty("restartstatisticafter")).intValue();
                }
                if (properties.getProperty("fixedurl") != null) {
                    u = String.valueOf(properties.getProperty("fixedurl"));
                }
                if (properties.getProperty("set_urls_action_version") != null) {
                    v = String.valueOf(properties.getProperty("set_urls_action_version"));
                }
                if (properties.getProperty("set_settings_action_version") != null) {
                    w = String.valueOf(properties.getProperty("set_settings_action_version"));
                }
                if (properties.getProperty("set_events_action_version") != null) {
                    x = String.valueOf(properties.getProperty("set_events_action_version"));
                }
                if (properties.getProperty("istjenable") != null) {
                    g = Integer.valueOf(properties.getProperty("istjenable")).intValue();
                }
                if (properties.getProperty("isdevicetjenable") != null) {
                    h = Integer.valueOf(properties.getProperty("isdevicetjenable")).intValue();
                }
                if (properties.getProperty("isnetworktjenable") != null) {
                    i = Integer.valueOf(properties.getProperty("isnetworktjenable")).intValue();
                }
                if (properties.getProperty("isdownloadtjenable") != null) {
                    j = Integer.valueOf(properties.getProperty("isdownloadtjenable")).intValue();
                }
                if (properties.getProperty("ispushenable") != null) {
                    m = Integer.valueOf(properties.getProperty("ispushenable")).intValue();
                }
                if (properties.getProperty("islocalserverenable") != null) {
                    o = Integer.valueOf(properties.getProperty("islocalserverenable")).intValue();
                }
                if (properties.getProperty("check_uninstallapp_interval") != null) {
                    k = Integer.valueOf(properties.getProperty("check_uninstallapp_interval")).intValue();
                }
                if (properties.getProperty("get_storeinfo_interval") != null) {
                    l = Integer.valueOf(properties.getProperty("get_storeinfo_interval")).intValue();
                }
                if (properties.getProperty("tj_data_remain_time") != null) {
                    p = Integer.valueOf(properties.getProperty("tj_data_remain_time")).intValue();
                }
                if (properties.getProperty("tj_data_upload_interval") != null) {
                    q = Integer.valueOf(properties.getProperty("tj_data_upload_interval")).intValue();
                }
                if (properties.getProperty("applist_tjenable") != null) {
                    r = Integer.valueOf(properties.getProperty("applist_tjenable")).intValue();
                }
                if (properties.getProperty("moplus_enable") != null) {
                    s = Integer.valueOf(properties.getProperty("moplus_enable")).intValue();
                }
                if (properties.getProperty("moplus_from_control") != null) {
                    t = properties.getProperty("moplus_from_control");
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (Exception e3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                fileInputStream2 = fileInputStream;
                th = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private a() {
    }

    public static int a() {
        return n;
    }

    public static int b() {
        return o;
    }

    public static int c() {
        return p;
    }

    public static int d() {
        return q;
    }

    public static int e() {
        return l;
    }

    public static int f() {
        return g;
    }

    public static int g() {
        return h;
    }

    public static int h() {
        return i;
    }

    public static int i() {
        return j;
    }

    public static String j() {
        return u;
    }

    public static int k() {
        return e;
    }

    public static int l() {
        return d;
    }

    public static String m() {
        return b;
    }

    public static int n() {
        return r;
    }
}
