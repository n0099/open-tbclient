package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class as extends bd {
    public static final BdUniqueId Ya = BdUniqueId.gen();
    private PhotoLiveCardData Yb;

    public PhotoLiveCardData qD() {
        return this.Yb;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Yb = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Ya;
    }

    @Override // com.baidu.tbadk.core.data.bd
    public String getTid() {
        return this.Yb != null ? String.valueOf(this.Yb.getThreadId()) : super.getTid();
    }
}
