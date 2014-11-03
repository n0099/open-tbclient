package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class aj {
    public static int EC;
    private static aj Ex;
    private static long Ez;
    private static volatile int Ey = 0;
    private static int EA = 300000;
    private static int EB = 10;

    private aj() {
        EC = TbadkApplication.m251getInst().getNetWorkCoreType();
    }

    public static synchronized aj mo() {
        aj ajVar;
        synchronized (aj.class) {
            if (Ex == null) {
                Ex = new aj();
            }
            ajVar = Ex;
        }
        return ajVar;
    }

    public u a(com.baidu.tbadk.core.util.httpNet.e eVar) {
        switch (EC) {
            case 0:
                return new ad(eVar);
            case 1:
                return new af(eVar);
            default:
                return new ad(eVar);
        }
    }

    public static synchronized void mp() {
        synchronized (aj.class) {
            if (EC == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - Ez < EA) {
                    Ey++;
                    if (Ey > EB) {
                        EC = 0;
                        BdLog.e("切换会老的网络内核");
                        TbadkApplication.m251getInst().setNetWorkCoreType(EC);
                        TiebaStatic.eventStat(TbadkApplication.m251getInst().getApp().getApplicationContext(), "network_core", "current Net：" + com.baidu.adp.lib.util.j.fn() + ", TelType:" + com.baidu.adp.lib.util.j.fp() + ", wap:" + getNetType(), 1, new Object[0]);
                    }
                } else {
                    Ey = 0;
                    Ez = currentTimeMillis;
                }
            }
        }
    }

    public static String getNetType() {
        try {
            if (com.baidu.adp.lib.util.j.fh()) {
                if (com.baidu.adp.lib.util.j.fi()) {
                    return "wifi";
                }
                String fq = com.baidu.adp.lib.util.j.fq();
                if (fq != null) {
                    if (fq.length() > 0) {
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

    public static void bs(int i) {
        EC = i;
    }
}
