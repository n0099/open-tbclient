package com.baidu.adp.lib.stats.b;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.stats.base.a {
    public a(i iVar) {
        super(iVar);
        this.tb = 10;
        this.mMustSuccess = true;
        this.tc = "alert";
    }

    @Override // com.baidu.adp.lib.stats.base.a
    public String gX() {
        return BdStatsConstant.FILE_MON;
    }
}
