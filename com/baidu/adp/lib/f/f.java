package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.q;
/* loaded from: classes.dex */
public class f {
    private static int lo = 0;
    private static int lp = 0;
    private static int lq = 0;
    private static int lr = 0;
    private static int ls = 0;
    private static int lt = 0;
    private static Object lu = new Object();

    public static q getLogItem() {
        return com.baidu.adp.lib.stats.f.er().ag("dbg");
    }

    public static void a(q qVar, q qVar2) {
        if (qVar != null || qVar2 != null) {
            synchronized (lu) {
                if (qVar != null) {
                    lq = (int) (lq + qVar.eM());
                }
                if (qVar2 != null) {
                    lp = (int) (lp + qVar2.eM());
                }
                int i = lo + 1;
                lo = i;
                if (i + lr > 100) {
                    eg();
                }
            }
        }
    }

    public static void b(q qVar, q qVar2) {
        if (qVar != null || qVar2 != null) {
            synchronized (lu) {
                if (qVar != null) {
                    lt = (int) (lt + qVar.eM());
                }
                if (qVar2 != null) {
                    ls = (int) (ls + qVar2.eM());
                }
                int i = lr + 1;
                lr = i;
                if (i + lo > 100) {
                    eg();
                }
            }
        }
    }

    public static void eg() {
        if (lo + lr > 10) {
            q logItem = getLogItem();
            logItem.n("act", "allStat");
            logItem.n("diskTaskCostTime", String.valueOf(lq));
            logItem.n("diskCostTime", String.valueOf(lp));
            logItem.n("diskNum", String.valueOf(lo));
            logItem.n("netTaskCostTime", String.valueOf(lt));
            logItem.n("netCostTime", String.valueOf(ls));
            logItem.n("netNum", String.valueOf(lr));
            logItem.n("isWifi", "1");
            com.baidu.adp.lib.stats.f.er().a("img", logItem);
            lp = 0;
            lo = 0;
            ls = 0;
            lr = 0;
            lq = 0;
            lt = 0;
        }
    }
}
