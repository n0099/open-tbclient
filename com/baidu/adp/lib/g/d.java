package com.baidu.adp.lib.g;
/* loaded from: classes.dex */
public class d {
    private static int pl = 0;
    private static int po = 0;
    private static int pp = 0;
    private static int pq = 0;
    private static int pr = 0;
    private static int ps = 0;
    private static Object pt = new Object();

    public static com.baidu.adp.lib.stats.d eB() {
        return com.baidu.adp.lib.stats.a.eI().ao("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (pt) {
                if (dVar != null) {
                    pp = (int) (pp + dVar.eZ());
                }
                if (dVar2 != null) {
                    po = (int) (po + dVar2.eZ());
                }
                int i = pl + 1;
                pl = i;
                if (i + pq > 100) {
                    eC();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (pt) {
                if (dVar != null) {
                    ps = (int) (ps + dVar.eZ());
                }
                if (dVar2 != null) {
                    pr = (int) (pr + dVar2.eZ());
                }
                int i = pq + 1;
                pq = i;
                if (i + pl > 100) {
                    eC();
                }
            }
        }
    }

    public static void eC() {
        if (pl + pq > 10) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("act", "allStat");
            eB.q("diskTaskCostTime", String.valueOf(pp));
            eB.q("diskCostTime", String.valueOf(po));
            eB.q("diskNum", String.valueOf(pl));
            eB.q("netTaskCostTime", String.valueOf(ps));
            eB.q("netCostTime", String.valueOf(pr));
            eB.q("netNum", String.valueOf(pq));
            eB.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.eI().b("img", eB);
            po = 0;
            pl = 0;
            pr = 0;
            pq = 0;
            pp = 0;
            ps = 0;
        }
    }
}
