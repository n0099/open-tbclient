package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class av extends bh {
    public static final BdUniqueId RT = BdUniqueId.gen();
    private PhotoLiveCardData RU;

    public PhotoLiveCardData qF() {
        return this.RU;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.RU = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return RT;
    }

    @Override // com.baidu.tbadk.core.data.bh
    public String getTid() {
        return this.RU != null ? String.valueOf(this.RU.getThreadId()) : super.getTid();
    }
}
