package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class BdStatisticsSwitchStatic extends com.baidu.adp.lib.b.a {
    static {
        com.baidu.adp.lib.b.d.fh().f(BdStatisticsSwitchStatic.class);
    }

    public static boolean ge() {
        return com.baidu.adp.lib.b.d.fh().al("newUrlForPerf") == 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected void aa(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "newUrlForPerf";
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] eY() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int eZ() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fa() {
        return 0;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int fb() {
        return 10;
    }
}
