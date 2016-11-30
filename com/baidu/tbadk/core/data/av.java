package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class av extends bk {
    public static final BdUniqueId SO = BdUniqueId.gen();
    private PhotoLiveCardData SP;

    public PhotoLiveCardData qL() {
        return this.SP;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.SP = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return SO;
    }

    @Override // com.baidu.tbadk.core.data.bk
    public String getTid() {
        return this.SP != null ? String.valueOf(this.SP.getThreadId()) : super.getTid();
    }
}
