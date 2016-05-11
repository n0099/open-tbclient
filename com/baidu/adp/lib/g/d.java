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

    public static com.baidu.adp.lib.stats.d dG() {
        return com.baidu.adp.lib.stats.a.dN().al("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (mp) {
                if (dVar != null) {
                    ml = (int) (ml + dVar.ee());
                }
                if (dVar2 != null) {
                    mk = (int) (mk + dVar2.ee());
                }
                int i = mj + 1;
                mj = i;
                if (i + mm > 100) {
                    dH();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (mp) {
                if (dVar != null) {
                    mo = (int) (mo + dVar.ee());
                }
                if (dVar2 != null) {
                    mn = (int) (mn + dVar2.ee());
                }
                int i = mm + 1;
                mm = i;
                if (i + mj > 100) {
                    dH();
                }
            }
        }
    }

    public static void dH() {
        if (mj + mm > 10) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("act", "allStat");
            dG.q("diskTaskCostTime", String.valueOf(ml));
            dG.q("diskCostTime", String.valueOf(mk));
            dG.q("diskNum", String.valueOf(mj));
            dG.q("netTaskCostTime", String.valueOf(mo));
            dG.q("netCostTime", String.valueOf(mn));
            dG.q("netNum", String.valueOf(mm));
            dG.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.dN().b("img", dG);
            mk = 0;
            mj = 0;
            mn = 0;
            mm = 0;
            ml = 0;
            mo = 0;
        }
    }
}
