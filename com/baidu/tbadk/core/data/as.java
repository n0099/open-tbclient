package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class as extends bd {
    public static final BdUniqueId aNT = BdUniqueId.gen();
    private PhotoLiveCardData aNU;

    public PhotoLiveCardData yF() {
        return this.aNU;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.aNU = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aNT;
    }

    @Override // com.baidu.tbadk.core.data.bd
    public String getTid() {
        return this.aNU != null ? String.valueOf(this.aNU.getThreadId()) : super.getTid();
    }
}
