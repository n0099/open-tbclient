package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.q;
/* loaded from: classes.dex */
public class f {
    private static int lp = 0;
    private static int lq = 0;
    private static int lr = 0;
    private static int ls = 0;
    private static int lt = 0;
    private static int lu = 0;
    private static Object lv = new Object();

    public static q ef() {
        return com.baidu.adp.lib.stats.f.es().ak("dbg");
    }

    public static void a(q qVar, q qVar2) {
        if (qVar != null || qVar2 != null) {
            synchronized (lv) {
                if (qVar != null) {
                    lr = (int) (lr + qVar.eM());
                }
                if (qVar2 != null) {
                    lq = (int) (lq + qVar2.eM());
                }
                int i = lp + 1;
                lp = i;
                if (i + ls > 100) {
                    eg();
                }
            }
        }
    }

    public static void b(q qVar, q qVar2) {
        if (qVar != null || qVar2 != null) {
            synchronized (lv) {
                if (qVar != null) {
                    lu = (int) (lu + qVar.eM());
                }
                if (qVar2 != null) {
                    lt = (int) (lt + qVar2.eM());
                }
                int i = ls + 1;
                ls = i;
                if (i + lp > 100) {
                    eg();
                }
            }
        }
    }

    public static void eg() {
        if (lp + ls > 10) {
            q ef = ef();
            ef.r("act", "allStat");
            ef.r("diskTaskCostTime", String.valueOf(lr));
            ef.r("diskCostTime", String.valueOf(lq));
            ef.r("diskNum", String.valueOf(lp));
            ef.r("netTaskCostTime", String.valueOf(lu));
            ef.r("netCostTime", String.valueOf(lt));
            ef.r("netNum", String.valueOf(ls));
            ef.r("isWifi", "1");
            com.baidu.adp.lib.stats.f.es().a("img", ef);
            lq = 0;
            lp = 0;
            lt = 0;
            ls = 0;
            lr = 0;
            lu = 0;
        }
    }
}
