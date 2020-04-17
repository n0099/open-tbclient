package com.baidu.adp.lib.stats.b;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.lib.stats.base.a {
    public a(j jVar) {
        super(jVar);
        this.Ml = 10;
        this.mMustSuccess = true;
        this.Mm = "alert";
    }

    @Override // com.baidu.adp.lib.stats.base.a
    public String lL() {
        return BdStatsConstant.FILE_MON;
    }
}
