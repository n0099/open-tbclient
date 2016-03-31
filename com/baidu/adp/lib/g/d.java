package com.baidu.adp.lib.g;
/* loaded from: classes.dex */
public class d {
    private static int wp = 0;
    private static int wq = 0;
    private static int wr = 0;
    private static int ws = 0;
    private static int wt = 0;
    private static int wu = 0;
    private static Object wv = new Object();

    public static com.baidu.adp.lib.stats.d hs() {
        return com.baidu.adp.lib.stats.a.hz().as("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (wv) {
                if (dVar != null) {
                    wr = (int) (wr + dVar.hQ());
                }
                if (dVar2 != null) {
                    wq = (int) (wq + dVar2.hQ());
                }
                int i = wp + 1;
                wp = i;
                if (i + ws > 100) {
                    ht();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (wv) {
                if (dVar != null) {
                    wu = (int) (wu + dVar.hQ());
                }
                if (dVar2 != null) {
                    wt = (int) (wt + dVar2.hQ());
                }
                int i = ws + 1;
                ws = i;
                if (i + wp > 100) {
                    ht();
                }
            }
        }
    }

    public static void ht() {
        if (wp + ws > 10) {
            com.baidu.adp.lib.stats.d hs = hs();
            hs.r("act", "allStat");
            hs.r("diskTaskCostTime", String.valueOf(wr));
            hs.r("diskCostTime", String.valueOf(wq));
            hs.r("diskNum", String.valueOf(wp));
            hs.r("netTaskCostTime", String.valueOf(wu));
            hs.r("netCostTime", String.valueOf(wt));
            hs.r("netNum", String.valueOf(ws));
            hs.r("isWifi", "1");
            com.baidu.adp.lib.stats.a.hz().b("img", hs);
            wq = 0;
            wp = 0;
            wt = 0;
            ws = 0;
            wr = 0;
            wu = 0;
        }
    }
}
