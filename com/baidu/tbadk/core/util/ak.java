package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ak {
    private static ak IS;
    private static long IU;
    public static int IX;
    private static volatile int IT = 0;
    private static int IV = 300000;
    private static int IW = 10;

    private ak() {
        IX = TbadkCoreApplication.m255getInst().getNetWorkCoreType();
    }

    public static synchronized ak pl() {
        ak akVar;
        synchronized (ak.class) {
            if (IS == null) {
                IS = new ak();
            }
            akVar = IS;
        }
        return akVar;
    }

    public v a(com.baidu.tbadk.core.util.httpNet.c cVar) {
        switch (IX) {
            case 0:
                return new ae(cVar);
            case 1:
                return new ag(cVar);
            default:
                return new ae(cVar);
        }
    }

    public static synchronized void pm() {
        synchronized (ak.class) {
            if (IX == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - IU < IV) {
                    IT++;
                    if (IT > IW) {
                        IX = 0;
                        BdLog.e("切换会老的网络内核");
                        TbadkCoreApplication.m255getInst().setNetWorkCoreType(IX);
                        TiebaStatic.eventStat(TbadkCoreApplication.m255getInst().getApp().getApplicationContext(), "network_core", "current Net：" + com.baidu.adp.lib.util.i.fl() + ", TelType:" + com.baidu.adp.lib.util.i.fn() + ", wap:" + getNetType(), 1, new Object[0]);
                    }
                } else {
                    IT = 0;
                    IU = currentTimeMillis;
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
        IX = i;
    }
}
