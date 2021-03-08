package com.baidu.adp.lib.stats.c;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.stats.base.a {
    public a(j jVar) {
        super(jVar);
        this.QK = 10;
        this.mMustSuccess = true;
        this.QL = "alert";
    }

    @Override // com.baidu.adp.lib.stats.base.a
    public String ni() {
        return BdStatsConstant.FILE_MON;
    }
}
