package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class as extends bd {
    public static final BdUniqueId aMx = BdUniqueId.gen();
    private PhotoLiveCardData aMy;

    public PhotoLiveCardData yd() {
        return this.aMy;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.aMy = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aMx;
    }

    @Override // com.baidu.tbadk.core.data.bd
    public String getTid() {
        return this.aMy != null ? String.valueOf(this.aMy.getThreadId()) : super.getTid();
    }
}
