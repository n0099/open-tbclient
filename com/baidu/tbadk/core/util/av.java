package com.baidu.tbadk.core.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
/* loaded from: classes.dex */
public class av {
    public static int a;
    private static av b;
    private static long d;
    private static volatile int c = 0;
    private static int e = 300000;
    private static int f = 10;

    private av() {
        a = TbadkApplication.m252getInst().getNetWorkCoreType();
    }

    public static synchronized av a() {
        av avVar;
        synchronized (av.class) {
            if (b == null) {
                b = new av();
            }
            avVar = b;
        }
        return avVar;
    }

    public ac a(com.baidu.tbadk.core.util.httpNet.c cVar) {
        switch (a) {
            case 0:
                return new NetWorkCore(cVar);
            case 1:
                return new NetWorkCoreByBdHttp(cVar);
            default:
                return new NetWorkCore(cVar);
        }
    }

    public static synchronized void b() {
        synchronized (av.class) {
            if (a == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - d < e) {
                    c++;
                    if (c > f) {
                        a = 0;
                        BdLog.e("切换会老的网络内核");
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
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase(NetworkChangeReceiver.WIFI_STRING)) {
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
