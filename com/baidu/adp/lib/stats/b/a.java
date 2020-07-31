package com.baidu.adp.lib.stats.b;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.stats.base.a {
    public a(j jVar) {
        super(jVar);
        this.Nb = 10;
        this.mMustSuccess = true;
        this.Nc = "alert";
    }

    @Override // com.baidu.adp.lib.stats.base.a
    public String md() {
        return BdStatsConstant.FILE_MON;
    }
}
