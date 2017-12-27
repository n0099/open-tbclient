package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class BdStatisticsSwitchStatic extends com.baidu.adp.lib.b.a {
    static {
        com.baidu.adp.lib.b.d.mz().f(BdStatisticsSwitchStatic.class);
    }

    public static boolean nu() {
        return com.baidu.adp.lib.b.d.mz().an("newUrlForPerf") == 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void cQ(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "newUrlForPerf";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] mq() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mr() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ms() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int mt() {
        return 10;
    }
}
