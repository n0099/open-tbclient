package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ax extends bj {
    public static final BdUniqueId Xg = BdUniqueId.gen();
    private PhotoLiveCardData Xh;

    public PhotoLiveCardData qY() {
        return this.Xh;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Xh = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Xg;
    }

    @Override // com.baidu.tbadk.core.data.bj
    public String getTid() {
        return this.Xh != null ? String.valueOf(this.Xh.getThreadId()) : super.getTid();
    }
}
