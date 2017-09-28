package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class BdStatisticsSwitchStatic extends com.baidu.adp.lib.b.a {
    static {
        com.baidu.adp.lib.b.d.eV().f(BdStatisticsSwitchStatic.class);
    }

    public static boolean fS() {
        return com.baidu.adp.lib.b.d.eV().af("newUrlForPerf") == 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void X(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "newUrlForPerf";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] eM() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eN() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eO() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eP() {
        return 10;
    }
}
