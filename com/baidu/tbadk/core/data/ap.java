package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ap extends be {
    public static final BdUniqueId PC = BdUniqueId.gen();
    private PhotoLiveCardData PD;

    public PhotoLiveCardData pu() {
        return this.PD;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.PD = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return PC;
    }

    @Override // com.baidu.tbadk.core.data.be
    public String getTid() {
        return this.PD != null ? String.valueOf(this.PD.getThreadId()) : super.getTid();
    }
}
