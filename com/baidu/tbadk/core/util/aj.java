package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class aj {
    public static int EB;
    private static aj Ew;
    private static long Ey;
    private static volatile int Ex = 0;
    private static int Ez = 300000;
    private static int EA = 10;

    private aj() {
        EB = TbadkApplication.m251getInst().getNetWorkCoreType();
    }

    public static synchronized aj mo() {
        aj ajVar;
        synchronized (aj.class) {
            if (Ew == null) {
                Ew = new aj();
            }
            ajVar = Ew;
        }
        return ajVar;
    }

    public u a(com.baidu.tbadk.core.util.httpNet.e eVar) {
        switch (EB) {
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
            if (EB == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - Ey < Ez) {
                    Ex++;
                    if (Ex > EA) {
                        EB = 0;
                        BdLog.e("切换会老的网络内核");
                        TbadkApplication.m251getInst().setNetWorkCoreType(EB);
                        TiebaStatic.eventStat(TbadkApplication.m251getInst().getApp().getApplicationContext(), "network_core", "current Net：" + com.baidu.adp.lib.util.j.fn() + ", TelType:" + com.baidu.adp.lib.util.j.fp() + ", wap:" + getNetType(), 1, new Object[0]);
                    }
                } else {
                    Ex = 0;
                    Ey = currentTimeMillis;
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
        EB = i;
    }
}
