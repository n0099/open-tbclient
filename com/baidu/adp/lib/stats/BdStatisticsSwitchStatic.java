package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class BdStatisticsSwitchStatic extends com.baidu.adp.lib.b.a {
    static {
        com.baidu.adp.lib.b.d.iQ().i(BdStatisticsSwitchStatic.class);
    }

    public static boolean jK() {
        return com.baidu.adp.lib.b.d.iQ().aO("newUrlForPerf") == 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void Z(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "newUrlForPerf";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] iG() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iH() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iI() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int iJ() {
        return 10;
    }
}
