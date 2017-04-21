package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class BdStatisticsSwitchStatic extends com.baidu.adp.lib.b.a {
    static {
        com.baidu.adp.lib.b.e.eZ().f(BdStatisticsSwitchStatic.class);
    }

    public static boolean fV() {
        return com.baidu.adp.lib.b.e.eZ().Y("newUrlForPerf") == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void X(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "newUrlForPerf";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] eQ() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eR() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eS() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eT() {
        return 10;
    }
}
