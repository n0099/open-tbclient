package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class as extends bd {
    public static final BdUniqueId aNJ = BdUniqueId.gen();
    private PhotoLiveCardData aNK;

    public PhotoLiveCardData yF() {
        return this.aNK;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.aNK = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aNJ;
    }

    @Override // com.baidu.tbadk.core.data.bd
    public String getTid() {
        return this.aNK != null ? String.valueOf(this.aNK.getThreadId()) : super.getTid();
    }
}
