package com.baidu.tbadk.cdnOptimize;

import com.baidu.adp.lib.b.f;
/* loaded from: classes.dex */
public class TBCdnPortraitSwitchStatic extends com.baidu.adp.lib.b.a {
    static {
        f.gD().l(TBCdnPortraitSwitchStatic.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.b.a
    public void changeSettingByType(int i) {
    }

    @Override // com.baidu.adp.lib.b.a
    protected String[] getCrashKeys() {
        return null;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getDefaultType() {
        return 1;
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getMaxCrashTimes() {
        return 10;
    }

    @Override // com.baidu.adp.lib.b.a
    protected String getName() {
        return "portrait_cdn_open";
    }

    @Override // com.baidu.adp.lib.b.a
    protected int getOffType() {
        return 0;
    }
}
