package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.q;
/* loaded from: classes.dex */
public class f {
    private static int vL = 0;
    private static int vM = 0;
    private static int vN = 0;
    private static int vO = 0;
    private static int vP = 0;
    private static int vQ = 0;
    private static Object vR = new Object();

    public static q hm() {
        return com.baidu.adp.lib.stats.f.hz().as("dbg");
    }

    public static void a(q qVar, q qVar2) {
        if (qVar != null || qVar2 != null) {
            synchronized (vR) {
                if (qVar != null) {
                    vN = (int) (vN + qVar.hV());
                }
                if (qVar2 != null) {
                    vM = (int) (vM + qVar2.hV());
                }
                int i = vL + 1;
                vL = i;
                if (i + vO > 100) {
                    hn();
                }
            }
        }
    }

    public static void b(q qVar, q qVar2) {
        if (qVar != null || qVar2 != null) {
            synchronized (vR) {
                if (qVar != null) {
                    vQ = (int) (vQ + qVar.hV());
                }
                if (qVar2 != null) {
                    vP = (int) (vP + qVar2.hV());
                }
                int i = vO + 1;
                vO = i;
                if (i + vL > 100) {
                    hn();
                }
            }
        }
    }

    public static void hn() {
        if (vL + vO > 10) {
            q hm = hm();
            hm.r("act", "allStat");
            hm.r("diskTaskCostTime", String.valueOf(vN));
            hm.r("diskCostTime", String.valueOf(vM));
            hm.r("diskNum", String.valueOf(vL));
            hm.r("netTaskCostTime", String.valueOf(vQ));
            hm.r("netCostTime", String.valueOf(vP));
            hm.r("netNum", String.valueOf(vO));
            hm.r("isWifi", "1");
            com.baidu.adp.lib.stats.f.hz().a("img", hm);
            vM = 0;
            vL = 0;
            vP = 0;
            vO = 0;
            vN = 0;
            vQ = 0;
        }
    }
}
