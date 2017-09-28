package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class aw extends bh {
    public static final BdUniqueId XI = BdUniqueId.gen();
    private PhotoLiveCardData XJ;

    public PhotoLiveCardData qC() {
        return this.XJ;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.XJ = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return XI;
    }

    @Override // com.baidu.tbadk.core.data.bh
    public String getTid() {
        return this.XJ != null ? String.valueOf(this.XJ.getThreadId()) : super.getTid();
    }
}
