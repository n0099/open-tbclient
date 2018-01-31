package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class as extends bd {
    public static final BdUniqueId aMA = BdUniqueId.gen();
    private PhotoLiveCardData aMB;

    public PhotoLiveCardData ye() {
        return this.aMB;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.aMB = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aMA;
    }

    @Override // com.baidu.tbadk.core.data.bd
    public String getTid() {
        return this.aMB != null ? String.valueOf(this.aMB.getThreadId()) : super.getTid();
    }
}
