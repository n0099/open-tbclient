package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class aw extends bh {
    public static final BdUniqueId XO = BdUniqueId.gen();
    private PhotoLiveCardData XP;

    public PhotoLiveCardData qA() {
        return this.XP;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.XP = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return XO;
    }

    @Override // com.baidu.tbadk.core.data.bh
    public String getTid() {
        return this.XP != null ? String.valueOf(this.XP.getThreadId()) : super.getTid();
    }
}
