package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class BdStatisticsSwitchStatic extends com.baidu.adp.lib.b.a {
    static {
        com.baidu.adp.lib.b.d.hS().h(BdStatisticsSwitchStatic.class);
    }

    public static boolean iN() {
        return com.baidu.adp.lib.b.d.hS().az("newUrlForPerf") == 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "newUrlForPerf";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hI() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hJ() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hK() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hL() {
        return 10;
    }
}
