package com.baidu.adp.lib.g;
/* loaded from: classes.dex */
public class d {
    private static int po = 0;
    private static int pp = 0;
    private static int pq = 0;
    private static int pr = 0;
    private static int ps = 0;
    private static int pt = 0;
    private static Object pu = new Object();

    public static com.baidu.adp.lib.stats.d eB() {
        return com.baidu.adp.lib.stats.a.eI().ao("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (pu) {
                if (dVar != null) {
                    pq = (int) (pq + dVar.eZ());
                }
                if (dVar2 != null) {
                    pp = (int) (pp + dVar2.eZ());
                }
                int i = po + 1;
                po = i;
                if (i + pr > 100) {
                    eC();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (pu) {
                if (dVar != null) {
                    pt = (int) (pt + dVar.eZ());
                }
                if (dVar2 != null) {
                    ps = (int) (ps + dVar2.eZ());
                }
                int i = pr + 1;
                pr = i;
                if (i + po > 100) {
                    eC();
                }
            }
        }
    }

    public static void eC() {
        if (po + pr > 10) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("act", "allStat");
            eB.q("diskTaskCostTime", String.valueOf(pq));
            eB.q("diskCostTime", String.valueOf(pp));
            eB.q("diskNum", String.valueOf(po));
            eB.q("netTaskCostTime", String.valueOf(pt));
            eB.q("netCostTime", String.valueOf(ps));
            eB.q("netNum", String.valueOf(pr));
            eB.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.eI().b("img", eB);
            pp = 0;
            po = 0;
            ps = 0;
            pr = 0;
            pq = 0;
            pt = 0;
        }
    }
}
