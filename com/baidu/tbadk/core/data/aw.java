package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class aw extends bi {
    public static final BdUniqueId Xw = BdUniqueId.gen();
    private PhotoLiveCardData Xx;

    public PhotoLiveCardData rw() {
        return this.Xx;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Xx = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Xw;
    }

    @Override // com.baidu.tbadk.core.data.bi
    public String getTid() {
        return this.Xx != null ? String.valueOf(this.Xx.getThreadId()) : super.getTid();
    }
}
