package com.baidu.adp.lib.stats;
/* loaded from: classes.dex */
public class BdStatisticsSwitchStatic extends com.baidu.adp.lib.c.a {
    static {
        com.baidu.adp.lib.c.e.cS().f(BdStatisticsSwitchStatic.class);
    }

    public static boolean ec() {
        return com.baidu.adp.lib.c.e.cS().Z("newUrlForPerf") == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.c.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.c.a
    protected String getName() {
        return "newUrlForPerf";
    }

    @Override // com.baidu.adp.lib.c.a
    protected String[] getCrashKeys() {
        return null;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getDefaultType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getOffType() {
        return 0;
    }

    @Override // com.baidu.adp.lib.c.a
    protected int getMaxCrashTimes() {
        return 10;
    }
}
