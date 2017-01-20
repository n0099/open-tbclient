package com.baidu.adp.lib.f;
/* loaded from: classes.dex */
public class d {
    private static int pe = 0;
    private static int pf = 0;
    private static int pg = 0;
    private static int ph = 0;
    private static int pi = 0;
    private static int pj = 0;
    private static Object pl = new Object();

    public static com.baidu.adp.lib.stats.d ez() {
        return com.baidu.adp.lib.stats.a.eG().an("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (pl) {
                if (dVar != null) {
                    pg = (int) (pg + dVar.eX());
                }
                if (dVar2 != null) {
                    pf = (int) (pf + dVar2.eX());
                }
                int i = pe + 1;
                pe = i;
                if (i + ph > 100) {
                    eA();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (pl) {
                if (dVar != null) {
                    pj = (int) (pj + dVar.eX());
                }
                if (dVar2 != null) {
                    pi = (int) (pi + dVar2.eX());
                }
                int i = ph + 1;
                ph = i;
                if (i + pe > 100) {
                    eA();
                }
            }
        }
    }

    public static void eA() {
        if (pe + ph > 10) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("act", "allStat");
            ez.q("diskTaskCostTime", String.valueOf(pg));
            ez.q("diskCostTime", String.valueOf(pf));
            ez.q("diskNum", String.valueOf(pe));
            ez.q("netTaskCostTime", String.valueOf(pj));
            ez.q("netCostTime", String.valueOf(pi));
            ez.q("netNum", String.valueOf(ph));
            ez.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.eG().b("img", ez);
            pf = 0;
            pe = 0;
            pi = 0;
            ph = 0;
            pg = 0;
            pj = 0;
        }
    }
}
