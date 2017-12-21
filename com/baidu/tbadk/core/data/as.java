package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class as extends bd {
    public static final BdUniqueId Yd = BdUniqueId.gen();
    private PhotoLiveCardData Ye;

    public PhotoLiveCardData qD() {
        return this.Ye;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Ye = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Yd;
    }

    @Override // com.baidu.tbadk.core.data.bd
    public String getTid() {
        return this.Ye != null ? String.valueOf(this.Ye.getThreadId()) : super.getTid();
    }
}
