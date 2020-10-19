package com.baidu.adp.lib.stats.b;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.stats.base.a {
    public a(j jVar) {
        super(jVar);
        this.Oq = 10;
        this.mMustSuccess = true;
        this.Or = "alert";
    }

    @Override // com.baidu.adp.lib.stats.base.a
    public String nI() {
        return BdStatsConstant.FILE_MON;
    }
}
