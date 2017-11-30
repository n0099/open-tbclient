package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class as extends bd {
    public static final BdUniqueId Yg = BdUniqueId.gen();
    private PhotoLiveCardData Yh;

    public PhotoLiveCardData qF() {
        return this.Yh;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Yh = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Yg;
    }

    @Override // com.baidu.tbadk.core.data.bd
    public String getTid() {
        return this.Yh != null ? String.valueOf(this.Yh.getThreadId()) : super.getTid();
    }
}
