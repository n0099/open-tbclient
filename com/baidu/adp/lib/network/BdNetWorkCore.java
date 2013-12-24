package com.baidu.adp.lib.network;

import android.content.Context;
import android.os.Handler;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class BdNetWorkCore {
    private static String a = "\r\n";
    private static String b = "--";
    private static String c = "--------7da3d81520810*";
    private static int d = 2097152;
    private static Handler e = null;
    private static Context f = null;
    private static volatile String g = null;
    private static volatile boolean h = false;
    private static Pattern i = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);
    private static ArrayList<StatisticsData> j = new ArrayList<>();
    private static AtomicInteger k = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public enum DataFormat {
        JSON,
        HTML,
        BINARY
    }

    /* loaded from: classes.dex */
    public enum DetailedNetworkType {
        UNAVAIL,
        WIFI,
        WAP_2G,
        WAP_3G,
        NET_2G,
        NET_3G
    }

    /* loaded from: classes.dex */
    public enum NetworkType {
        UNAVAIL,
        WIFI,
        MOBILE
    }
}
