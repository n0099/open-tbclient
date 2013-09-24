package com.baidu.android.systemmonitor.d;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static int f711a;
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
    private static String n;
    private static String o;
    private static String p;
    private static String q;

    static {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        f711a = 0;
        b = null;
        c = 0;
        d = 0;
        e = -1;
        f = 0;
        g = -1;
        h = 0;
        i = 0;
        j = -1;
        k = -1;
        l = -1;
        m = -1;
        n = null;
        o = null;
        p = null;
        q = null;
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
                    f711a = Integer.valueOf(properties.getProperty("uefilesize")).intValue();
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
                    n = String.valueOf(properties.getProperty("fixedurl"));
                }
                if (properties.getProperty("set_urls_action_version") != null) {
                    o = String.valueOf(properties.getProperty("set_urls_action_version"));
                }
                if (properties.getProperty("set_settings_action_version") != null) {
                    p = String.valueOf(properties.getProperty("set_settings_action_version"));
                }
                if (properties.getProperty("set_events_action_version") != null) {
                    q = String.valueOf(properties.getProperty("set_events_action_version"));
                }
                if (properties.getProperty("istjenable") != null) {
                    g = Integer.valueOf(properties.getProperty("istjenable")).intValue();
                }
                if (properties.getProperty("ispushenable") != null) {
                    j = Integer.valueOf(properties.getProperty("ispushenable")).intValue();
                }
                if (properties.getProperty("islocalserverenable") != null) {
                    k = Integer.valueOf(properties.getProperty("islocalserverenable")).intValue();
                }
                if (properties.getProperty("check_uninstallapp_interval") != null) {
                    h = Integer.valueOf(properties.getProperty("check_uninstallapp_interval")).intValue();
                }
                if (properties.getProperty("get_storeinfo_interval") != null) {
                    i = Integer.valueOf(properties.getProperty("get_storeinfo_interval")).intValue();
                }
                if (properties.getProperty("tj_data_remain_time") != null) {
                    l = Integer.valueOf(properties.getProperty("tj_data_remain_time")).intValue();
                }
                if (properties.getProperty("tj_data_upload_interval") != null) {
                    m = Integer.valueOf(properties.getProperty("tj_data_upload_interval")).intValue();
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

    public static int a() {
        return j;
    }

    public static int b() {
        return k;
    }

    public static int c() {
        return l;
    }

    public static int d() {
        return m;
    }

    public static int e() {
        return i;
    }

    public static int f() {
        return g;
    }

    public static String g() {
        return n;
    }

    public static int h() {
        return e;
    }

    public static int i() {
        return d;
    }

    public static String j() {
        return b;
    }

    public static int k() {
        return c;
    }

    public static String l() {
        return o;
    }

    public static String m() {
        return q;
    }
}
