package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class BdStatisticsSwitchStatic extends com.baidu.adp.lib.b.a {
    static {
        com.baidu.adp.lib.b.d.hv().f(BdStatisticsSwitchStatic.class);
    }

    public static boolean iq() {
        return com.baidu.adp.lib.b.d.hv().ax("newUrlForPerf") == 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void R(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "newUrlForPerf";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] hl() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hm() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int hn() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int ho() {
        return 10;
    }
}
