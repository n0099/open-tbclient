package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ak {
    private static ak IP;
    private static long IR;
    public static int IU;
    private static volatile int IQ = 0;
    private static int IS = 300000;
    private static int IT = 10;

    private ak() {
        IU = TbadkCoreApplication.m255getInst().getNetWorkCoreType();
    }

    public static synchronized ak pe() {
        ak akVar;
        synchronized (ak.class) {
            if (IP == null) {
                IP = new ak();
            }
            akVar = IP;
        }
        return akVar;
    }

    public v a(com.baidu.tbadk.core.util.httpNet.c cVar) {
        switch (IU) {
            case 0:
                return new ae(cVar);
            case 1:
                return new ag(cVar);
            default:
                return new ae(cVar);
        }
    }

    public static synchronized void pf() {
        synchronized (ak.class) {
            if (IU == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - IR < IS) {
                    IQ++;
                    if (IQ > IT) {
                        IU = 0;
                        BdLog.e("切换会老的网络内核");
                        TbadkCoreApplication.m255getInst().setNetWorkCoreType(IU);
                        TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getApp().getApplicationContext(), "network_core", "current Net：" + com.baidu.adp.lib.util.i.fl() + ", TelType:" + com.baidu.adp.lib.util.i.fn() + ", wap:" + getNetType(), 1, new Object[0]);
                    }
                } else {
                    IQ = 0;
                    IR = currentTimeMillis;
                }
            }
        }
    }

    public static String getNetType() {
        try {
            if (com.baidu.adp.lib.util.i.ff()) {
                if (com.baidu.adp.lib.util.i.fg()) {
                    return "wifi";
                }
                String fo = com.baidu.adp.lib.util.i.fo();
                if (fo != null) {
                    if (fo.length() > 0) {
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

    public static void bU(int i) {
        IU = i;
    }
}
