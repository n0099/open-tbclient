package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ak {
    private static ak II;
    private static long IK;
    public static int IN;
    private static volatile int IJ = 0;
    private static int IL = 300000;
    private static int IM = 10;

    private ak() {
        IN = TbadkCoreApplication.m255getInst().getNetWorkCoreType();
    }

    public static synchronized ak pi() {
        ak akVar;
        synchronized (ak.class) {
            if (II == null) {
                II = new ak();
            }
            akVar = II;
        }
        return akVar;
    }

    public v a(com.baidu.tbadk.core.util.httpNet.c cVar) {
        switch (IN) {
            case 0:
                return new ae(cVar);
            case 1:
                return new ag(cVar);
            default:
                return new ae(cVar);
        }
    }

    public static synchronized void pj() {
        synchronized (ak.class) {
            if (IN == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - IK < IL) {
                    IJ++;
                    if (IJ > IM) {
                        IN = 0;
                        BdLog.e("切换会老的网络内核");
                        TbadkCoreApplication.m255getInst().setNetWorkCoreType(IN);
                        TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getApp().getApplicationContext(), "network_core", "current Net：" + com.baidu.adp.lib.util.i.fm() + ", TelType:" + com.baidu.adp.lib.util.i.fo() + ", wap:" + getNetType(), 1, new Object[0]);
                    }
                } else {
                    IJ = 0;
                    IK = currentTimeMillis;
                }
            }
        }
    }

    public static String getNetType() {
        try {
            if (com.baidu.adp.lib.util.i.fg()) {
                if (com.baidu.adp.lib.util.i.fh()) {
                    return "wifi";
                }
                String fp = com.baidu.adp.lib.util.i.fp();
                if (fp != null) {
                    if (fp.length() > 0) {
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

    public static void bP(int i) {
        IN = i;
    }
}
