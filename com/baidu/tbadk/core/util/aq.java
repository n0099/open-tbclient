package com.baidu.tbadk.core.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class aq {
    public static int a;
    private static aq b;
    private static long d;
    private static volatile int c = 0;
    private static int e = 300000;
    private static int f = 10;

    private aq() {
        a = TbadkApplication.m252getInst().getNetWorkCoreType();
    }

    public static synchronized aq a() {
        aq aqVar;
        synchronized (aq.class) {
            if (b == null) {
                b = new aq();
            }
            aqVar = b;
        }
        return aqVar;
    }

    public aa a(com.baidu.tbadk.core.util.a.a aVar) {
        switch (a) {
            case 0:
                return new NetWorkCore(aVar);
            case 1:
                return new NetWorkCoreByBdHttp(aVar);
            default:
                return new NetWorkCore(aVar);
        }
    }

    public static synchronized void b() {
        synchronized (aq.class) {
            if (a == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - d < e) {
                    c++;
                    BdLog.w(aq.class.getName(), "addError", "发生一次新网络内核不通畅警告！ errotime:" + c);
                    if (c > f) {
                        a = 0;
                        BdLog.e(aq.class.getName(), "addError", "切换会老的网络内核");
                        TbadkApplication.m252getInst().setNetWorkCoreType(a);
                        TiebaStatic.eventStat(TbadkApplication.m252getInst().getApp().getApplicationContext(), "network_core", "current Net：" + UtilHelper.getNetStatusInfo(TbadkApplication.m252getInst().getApp().getApplicationContext()) + ", TelType:" + com.baidu.adp.lib.network.willdelete.h.d() + ", wap:" + c(), 1, new Object[0]);
                    }
                } else {
                    c = 0;
                    d = currentTimeMillis;
                }
            }
        }
    }

    public static String c() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) TbadkApplication.m252getInst().getApp().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    return "wifi";
                }
                String defaultHost = Proxy.getDefaultHost();
                if (defaultHost != null) {
                    if (defaultHost.length() > 0) {
                        return "wap";
                    }
                }
                return "net";
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    public static void a(int i) {
        a = i;
    }
}
