package com.baidu.adp.lib.g;
/* loaded from: classes.dex */
public class d {
    private static int mj = 0;
    private static int mk = 0;
    private static int ml = 0;
    private static int mm = 0;
    private static int mn = 0;
    private static int mo = 0;
    private static Object mp = new Object();

    public static com.baidu.adp.lib.stats.d dH() {
        return com.baidu.adp.lib.stats.a.dO().al("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (mp) {
                if (dVar != null) {
                    ml = (int) (ml + dVar.ef());
                }
                if (dVar2 != null) {
                    mk = (int) (mk + dVar2.ef());
                }
                int i = mj + 1;
                mj = i;
                if (i + mm > 100) {
                    dI();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (mp) {
                if (dVar != null) {
                    mo = (int) (mo + dVar.ef());
                }
                if (dVar2 != null) {
                    mn = (int) (mn + dVar2.ef());
                }
                int i = mm + 1;
                mm = i;
                if (i + mj > 100) {
                    dI();
                }
            }
        }
    }

    public static void dI() {
        if (mj + mm > 10) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("act", "allStat");
            dH.q("diskTaskCostTime", String.valueOf(ml));
            dH.q("diskCostTime", String.valueOf(mk));
            dH.q("diskNum", String.valueOf(mj));
            dH.q("netTaskCostTime", String.valueOf(mo));
            dH.q("netCostTime", String.valueOf(mn));
            dH.q("netNum", String.valueOf(mm));
            dH.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.dO().b("img", dH);
            mk = 0;
            mj = 0;
            mn = 0;
            mm = 0;
            ml = 0;
            mo = 0;
        }
    }
}
