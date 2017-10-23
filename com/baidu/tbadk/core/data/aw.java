package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class aw extends bh {
    public static final BdUniqueId Xw = BdUniqueId.gen();
    private PhotoLiveCardData Xx;

    public PhotoLiveCardData qv() {
        return this.Xx;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Xx = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Xw;
    }

    @Override // com.baidu.tbadk.core.data.bh
    public String getTid() {
        return this.Xx != null ? String.valueOf(this.Xx.getThreadId()) : super.getTid();
    }
}
