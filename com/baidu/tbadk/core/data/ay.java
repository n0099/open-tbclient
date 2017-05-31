package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ay extends bl {
    public static final BdUniqueId WK = BdUniqueId.gen();
    private PhotoLiveCardData WL;

    public PhotoLiveCardData qC() {
        return this.WL;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.WL = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return WK;
    }

    @Override // com.baidu.tbadk.core.data.bl
    public String getTid() {
        return this.WL != null ? String.valueOf(this.WL.getThreadId()) : super.getTid();
    }
}
