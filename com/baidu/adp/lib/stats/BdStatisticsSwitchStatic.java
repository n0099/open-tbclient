package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class BdStatisticsSwitchStatic extends com.baidu.adp.lib.b.a {
    static {
        com.baidu.adp.lib.b.d.hI().h(BdStatisticsSwitchStatic.class);
    }

    public static boolean iE() {
        return com.baidu.adp.lib.b.d.hI().ay("newUrlForPerf") == 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "newUrlForPerf";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hy() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hz() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hA() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hB() {
        return 10;
    }
}
