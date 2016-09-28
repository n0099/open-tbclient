package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class at extends bi {
    public static final BdUniqueId St = BdUniqueId.gen();
    private PhotoLiveCardData Su;

    public PhotoLiveCardData qJ() {
        return this.Su;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Su = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return St;
    }

    @Override // com.baidu.tbadk.core.data.bi
    public String getTid() {
        return this.Su != null ? String.valueOf(this.Su.getThreadId()) : super.getTid();
    }
}
