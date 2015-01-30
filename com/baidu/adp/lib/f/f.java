package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.q;
/* loaded from: classes.dex */
public class f {
    private static int ls = 0;
    private static int lt = 0;
    private static int lu = 0;
    private static int lv = 0;
    private static int lw = 0;
    private static int lx = 0;
    private static Object ly = new Object();

    public static q ed() {
        return com.baidu.adp.lib.stats.f.eq().ak("dbg");
    }

    public static void a(q qVar, q qVar2) {
        if (qVar != null || qVar2 != null) {
            synchronized (ly) {
                if (qVar != null) {
                    lu = (int) (lu + qVar.eL());
                }
                if (qVar2 != null) {
                    lt = (int) (lt + qVar2.eL());
                }
                int i = ls + 1;
                ls = i;
                if (i + lv > 100) {
                    ee();
                }
            }
        }
    }

    public static void b(q qVar, q qVar2) {
        if (qVar != null || qVar2 != null) {
            synchronized (ly) {
                if (qVar != null) {
                    lx = (int) (lx + qVar.eL());
                }
                if (qVar2 != null) {
                    lw = (int) (lw + qVar2.eL());
                }
                int i = lv + 1;
                lv = i;
                if (i + ls > 100) {
                    ee();
                }
            }
        }
    }

    public static void ee() {
        if (ls + lv > 10) {
            q ed = ed();
            ed.r("act", "allStat");
            ed.r("diskTaskCostTime", String.valueOf(lu));
            ed.r("diskCostTime", String.valueOf(lt));
            ed.r("diskNum", String.valueOf(ls));
            ed.r("netTaskCostTime", String.valueOf(lx));
            ed.r("netCostTime", String.valueOf(lw));
            ed.r("netNum", String.valueOf(lv));
            ed.r("isWifi", "1");
            com.baidu.adp.lib.stats.f.eq().a("img", ed);
            lt = 0;
            ls = 0;
            lw = 0;
            lv = 0;
            lu = 0;
            lx = 0;
        }
    }
}
