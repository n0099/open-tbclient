package com.baidu.adp.lib.g;
/* loaded from: classes.dex */
public class d {
    private static int mO = 0;
    private static int mP = 0;
    private static int mQ = 0;
    private static int mS = 0;
    private static int mT = 0;
    private static int mU = 0;
    private static Object mV = new Object();

    public static com.baidu.adp.lib.stats.d dG() {
        return com.baidu.adp.lib.stats.a.dN().an("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (mV) {
                if (dVar != null) {
                    mQ = (int) (mQ + dVar.ee());
                }
                if (dVar2 != null) {
                    mP = (int) (mP + dVar2.ee());
                }
                int i = mO + 1;
                mO = i;
                if (i + mS > 100) {
                    dH();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (mV) {
                if (dVar != null) {
                    mU = (int) (mU + dVar.ee());
                }
                if (dVar2 != null) {
                    mT = (int) (mT + dVar2.ee());
                }
                int i = mS + 1;
                mS = i;
                if (i + mO > 100) {
                    dH();
                }
            }
        }
    }

    public static void dH() {
        if (mO + mS > 10) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("act", "allStat");
            dG.q("diskTaskCostTime", String.valueOf(mQ));
            dG.q("diskCostTime", String.valueOf(mP));
            dG.q("diskNum", String.valueOf(mO));
            dG.q("netTaskCostTime", String.valueOf(mU));
            dG.q("netCostTime", String.valueOf(mT));
            dG.q("netNum", String.valueOf(mS));
            dG.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.dN().b("img", dG);
            mP = 0;
            mO = 0;
            mT = 0;
            mS = 0;
            mQ = 0;
            mU = 0;
        }
    }
}
