package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ak extends az {
    public static final BdUniqueId Pf = BdUniqueId.gen();
    private PhotoLiveCardData Pg;

    public PhotoLiveCardData pL() {
        return this.Pg;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Pg = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.az, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Pf;
    }

    @Override // com.baidu.tbadk.core.data.az
    public String getTid() {
        return this.Pg != null ? String.valueOf(this.Pg.getThreadId()) : super.getTid();
    }
}
