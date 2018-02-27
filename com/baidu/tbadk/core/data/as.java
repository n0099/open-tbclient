package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class as extends bd {
    public static final BdUniqueId aNI = BdUniqueId.gen();
    private PhotoLiveCardData aNJ;

    public PhotoLiveCardData yF() {
        return this.aNJ;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.aNJ = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aNI;
    }

    @Override // com.baidu.tbadk.core.data.bd
    public String getTid() {
        return this.aNJ != null ? String.valueOf(this.aNJ.getThreadId()) : super.getTid();
    }
}
