package com.baidu.adp.lib.f;

import com.baidu.adp.lib.stats.q;
/* loaded from: classes.dex */
public class f {
    private static int wH = 0;
    private static int wI = 0;
    private static int wJ = 0;
    private static int wK = 0;
    private static int wL = 0;
    private static int wM = 0;
    private static Object wN = new Object();

    public static q hC() {
        return com.baidu.adp.lib.stats.f.hP().ar("dbg");
    }

    public static void a(q qVar, q qVar2) {
        if (qVar != null || qVar2 != null) {
            synchronized (wN) {
                if (qVar != null) {
                    wJ = (int) (wJ + qVar.im());
                }
                if (qVar2 != null) {
                    wI = (int) (wI + qVar2.im());
                }
                int i = wH + 1;
                wH = i;
                if (i + wK > 100) {
                    hD();
                }
            }
        }
    }

    public static void b(q qVar, q qVar2) {
        if (qVar != null || qVar2 != null) {
            synchronized (wN) {
                if (qVar != null) {
                    wM = (int) (wM + qVar.im());
                }
                if (qVar2 != null) {
                    wL = (int) (wL + qVar2.im());
                }
                int i = wK + 1;
                wK = i;
                if (i + wH > 100) {
                    hD();
                }
            }
        }
    }

    public static void hD() {
        if (wH + wK > 10) {
            q hC = hC();
            hC.r("act", "allStat");
            hC.r("diskTaskCostTime", String.valueOf(wJ));
            hC.r("diskCostTime", String.valueOf(wI));
            hC.r("diskNum", String.valueOf(wH));
            hC.r("netTaskCostTime", String.valueOf(wM));
            hC.r("netCostTime", String.valueOf(wL));
            hC.r("netNum", String.valueOf(wK));
            hC.r("isWifi", "1");
            com.baidu.adp.lib.stats.f.hP().a("img", hC);
            wI = 0;
            wH = 0;
            wL = 0;
            wK = 0;
            wJ = 0;
            wM = 0;
        }
    }
}
