package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class BdStatisticsSwitchStatic extends com.baidu.adp.lib.b.a {
    static {
        com.baidu.adp.lib.b.d.eE().f(BdStatisticsSwitchStatic.class);
    }

    public static boolean fz() {
        return com.baidu.adp.lib.b.d.eE().ak("newUrlForPerf") == 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void Q(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "newUrlForPerf";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] ev() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ew() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ex() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ey() {
        return 10;
    }
}
