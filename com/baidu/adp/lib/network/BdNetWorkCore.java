package com.baidu.adp.lib.network;

import android.content.Context;
import android.os.Handler;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public final class BdNetWorkCore {
    private static String a = IOUtils.LINE_SEPARATOR_WINDOWS;
    private static String b = "--";
    private static String c = "--------7da3d81520810*";
    private static int d = AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END;
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
        BINARY;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static DataFormat[] valuesCustom() {
            DataFormat[] valuesCustom = values();
            int length = valuesCustom.length;
            DataFormat[] dataFormatArr = new DataFormat[length];
            System.arraycopy(valuesCustom, 0, dataFormatArr, 0, length);
            return dataFormatArr;
        }
    }

    /* loaded from: classes.dex */
    public enum DetailedNetworkType {
        UNAVAIL,
        WIFI,
        WAP_2G,
        WAP_3G,
        NET_2G,
        NET_3G;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static DetailedNetworkType[] valuesCustom() {
            DetailedNetworkType[] valuesCustom = values();
            int length = valuesCustom.length;
            DetailedNetworkType[] detailedNetworkTypeArr = new DetailedNetworkType[length];
            System.arraycopy(valuesCustom, 0, detailedNetworkTypeArr, 0, length);
            return detailedNetworkTypeArr;
        }
    }

    /* loaded from: classes.dex */
    public enum NetworkType {
        UNAVAIL,
        WIFI,
        MOBILE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static NetworkType[] valuesCustom() {
            NetworkType[] valuesCustom = values();
            int length = valuesCustom.length;
            NetworkType[] networkTypeArr = new NetworkType[length];
            System.arraycopy(valuesCustom, 0, networkTypeArr, 0, length);
            return networkTypeArr;
        }
    }
}
