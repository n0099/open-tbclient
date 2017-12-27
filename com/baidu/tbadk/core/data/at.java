package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class at extends be {
    public static final BdUniqueId aMB = BdUniqueId.gen();
    private PhotoLiveCardData aMC;

    public PhotoLiveCardData yg() {
        return this.aMC;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.aMC = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aMB;
    }

    @Override // com.baidu.tbadk.core.data.be
    public String getTid() {
        return this.aMC != null ? String.valueOf(this.aMC.getThreadId()) : super.getTid();
    }
}
