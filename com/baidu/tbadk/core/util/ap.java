package com.baidu.tbadk.core.util;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class ap {
    public static int a;
    private static ap b;
    private static long d;
    private static volatile int c = 0;
    private static int e = 300000;
    private static int f = 10;

    private ap() {
        a = TbadkApplication.j().H();
    }

    public static synchronized ap a() {
        ap apVar;
        synchronized (ap.class) {
            if (b == null) {
                b = new ap();
            }
            apVar = b;
        }
        return apVar;
    }

    public static z a(com.baidu.tbadk.core.util.a.a aVar) {
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
        synchronized (ap.class) {
            if (a == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - d < e) {
                    c++;
                    com.baidu.adp.lib.util.f.c(ap.class.getName(), "addError", "发生一次新网络内核不通畅警告！ errotime:" + c);
                    if (c > f) {
                        a = 0;
                        com.baidu.adp.lib.util.f.b(ap.class.getName(), "addError", "切换会老的网络内核");
                        TbadkApplication.j().c(a);
                        TiebaStatic.a(TbadkApplication.j().b().getApplicationContext(), "network_core", "current Net：" + UtilHelper.d(TbadkApplication.j().b().getApplicationContext()) + ", TelType:" + com.baidu.adp.lib.network.willdelete.h.b() + ", wap:" + c(), 1, new Object[0]);
                    }
                } else {
                    c = 0;
                    d = currentTimeMillis;
                }
            }
        }
    }

    private static String c() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) TbadkApplication.j().b().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    return "wifi";
                }
                String defaultHost = Proxy.getDefaultHost();
                if (defaultHost != null) {
                    if (defaultHost.length() > 0) {
                        return com.baidu.loginshare.e.d;
                    }
                }
                return com.baidu.loginshare.e.e;
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
