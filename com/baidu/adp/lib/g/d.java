package com.baidu.adp.lib.g;
/* loaded from: classes.dex */
public class d {
    private static int vY = 0;
    private static int vZ = 0;
    private static int wa = 0;
    private static int wb = 0;
    private static int wc = 0;
    private static int wd = 0;
    private static Object we = new Object();

    public static com.baidu.adp.lib.stats.d hm() {
        return com.baidu.adp.lib.stats.a.ht().aq("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (we) {
                if (dVar != null) {
                    wa = (int) (wa + dVar.hK());
                }
                if (dVar2 != null) {
                    vZ = (int) (vZ + dVar2.hK());
                }
                int i = vY + 1;
                vY = i;
                if (i + wb > 100) {
                    hn();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (we) {
                if (dVar != null) {
                    wd = (int) (wd + dVar.hK());
                }
                if (dVar2 != null) {
                    wc = (int) (wc + dVar2.hK());
                }
                int i = wb + 1;
                wb = i;
                if (i + vY > 100) {
                    hn();
                }
            }
        }
    }

    public static void hn() {
        if (vY + wb > 10) {
            com.baidu.adp.lib.stats.d hm = hm();
            hm.r("act", "allStat");
            hm.r("diskTaskCostTime", String.valueOf(wa));
            hm.r("diskCostTime", String.valueOf(vZ));
            hm.r("diskNum", String.valueOf(vY));
            hm.r("netTaskCostTime", String.valueOf(wd));
            hm.r("netCostTime", String.valueOf(wc));
            hm.r("netNum", String.valueOf(wb));
            hm.r("isWifi", "1");
            com.baidu.adp.lib.stats.a.ht().b("img", hm);
            vZ = 0;
            vY = 0;
            wc = 0;
            wb = 0;
            wa = 0;
            wd = 0;
        }
    }
}
