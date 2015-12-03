package com.baidu.adp.lib.g;
/* loaded from: classes.dex */
public class d {
    private static int vM = 0;
    private static int vN = 0;
    private static int vO = 0;
    private static int vP = 0;
    private static int vQ = 0;
    private static int vR = 0;
    private static Object vS = new Object();

    public static com.baidu.adp.lib.stats.d he() {
        return com.baidu.adp.lib.stats.a.hl().ar("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (vS) {
                if (dVar != null) {
                    vO = (int) (vO + dVar.hC());
                }
                if (dVar2 != null) {
                    vN = (int) (vN + dVar2.hC());
                }
                int i = vM + 1;
                vM = i;
                if (i + vP > 100) {
                    hf();
                }
            }
        }
    }

    public static void b(com.baidu.adp.lib.stats.d dVar, com.baidu.adp.lib.stats.d dVar2) {
        if (dVar != null || dVar2 != null) {
            synchronized (vS) {
                if (dVar != null) {
                    vR = (int) (vR + dVar.hC());
                }
                if (dVar2 != null) {
                    vQ = (int) (vQ + dVar2.hC());
                }
                int i = vP + 1;
                vP = i;
                if (i + vM > 100) {
                    hf();
                }
            }
        }
    }

    public static void hf() {
        if (vM + vP > 10) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("act", "allStat");
            he.q("diskTaskCostTime", String.valueOf(vO));
            he.q("diskCostTime", String.valueOf(vN));
            he.q("diskNum", String.valueOf(vM));
            he.q("netTaskCostTime", String.valueOf(vR));
            he.q("netCostTime", String.valueOf(vQ));
            he.q("netNum", String.valueOf(vP));
            he.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.hl().b("img", he);
            vN = 0;
            vM = 0;
            vQ = 0;
            vP = 0;
            vO = 0;
            vR = 0;
        }
    }
}
