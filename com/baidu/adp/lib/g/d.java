package com.baidu.adp.lib.g;
/* loaded from: classes.dex */
public class d {
    private static int vO = 0;
    private static int vP = 0;
    private static int vQ = 0;
    private static int vR = 0;
    private static int vS = 0;
    private static int vT = 0;
    private static Object vU = new Object();

    public static com.baidu.adp.lib.stats.d he() {
        return com.baidu.adp.lib.stats.a.hl().ar("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (vU) {
                if (dVar != null) {
                    vQ = (int) (vQ + dVar.hC());
                }
                if (dVar2 != null) {
                    vP = (int) (vP + dVar2.hC());
                }
                int i = vO + 1;
                vO = i;
                if (i + vR > 100) {
                    hf();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (vU) {
                if (dVar != null) {
                    vT = (int) (vT + dVar.hC());
                }
                if (dVar2 != null) {
                    vS = (int) (vS + dVar2.hC());
                }
                int i = vR + 1;
                vR = i;
                if (i + vO > 100) {
                    hf();
                }
            }
        }
    }

    public static void hf() {
        if (vO + vR > 10) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("act", "allStat");
            he.q("diskTaskCostTime", String.valueOf(vQ));
            he.q("diskCostTime", String.valueOf(vP));
            he.q("diskNum", String.valueOf(vO));
            he.q("netTaskCostTime", String.valueOf(vT));
            he.q("netCostTime", String.valueOf(vS));
            he.q("netNum", String.valueOf(vR));
            he.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.hl().b("img", he);
            vP = 0;
            vO = 0;
            vS = 0;
            vR = 0;
            vQ = 0;
            vT = 0;
        }
    }
}
