package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ah {
    private static ah Uu;
    private static long Uw;
    public static int Uz;
    private static volatile int Uv = 0;
    private static int Ux = 300000;
    private static int Uy = 10;

    private ah() {
        Uz = TbadkCoreApplication.m411getInst().getNetWorkCoreType();
    }

    public static synchronized ah sB() {
        ah ahVar;
        synchronized (ah.class) {
            if (Uu == null) {
                Uu = new ah();
            }
            ahVar = Uu;
        }
        return ahVar;
    }

    public s a(com.baidu.tbadk.core.util.httpNet.a aVar) {
        switch (Uz) {
            case 0:
                return new ab(aVar);
            case 1:
                return new ad(aVar);
            default:
                return new ab(aVar);
        }
    }

    public static synchronized void sC() {
        synchronized (ah.class) {
            if (Uz == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - Uw < Ux) {
                    Uv++;
                    if (Uv > Uy) {
                        Uz = 0;
                        BdLog.e("切换会老的网络内核");
                        TbadkCoreApplication.m411getInst().setNetWorkCoreType(Uz);
                        TiebaStatic.eventStat(TbadkCoreApplication.m411getInst().getApp().getApplicationContext(), "network_core", "current Net：" + com.baidu.adp.lib.util.k.iN() + ", TelType:" + com.baidu.adp.lib.util.k.iP() + ", wap:" + getNetType(), 1, new Object[0]);
                    }
                } else {
                    Uv = 0;
                    Uw = currentTimeMillis;
                }
            }
        }
    }

    public static String getNetType() {
        try {
            if (com.baidu.adp.lib.util.k.iH()) {
                if (com.baidu.adp.lib.util.k.iI()) {
                    return "wifi";
                }
                String iQ = com.baidu.adp.lib.util.k.iQ();
                if (iQ != null) {
                    if (iQ.length() > 0) {
                        return "wap";
                    }
                }
                return "net";
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static void bV(int i) {
        Uz = i;
    }
}
