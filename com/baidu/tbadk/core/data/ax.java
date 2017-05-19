package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ax extends bk {
    public static final BdUniqueId WP = BdUniqueId.gen();
    private PhotoLiveCardData WQ;

    public PhotoLiveCardData qG() {
        return this.WQ;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.WQ = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return WP;
    }

    @Override // com.baidu.tbadk.core.data.bk
    public String getTid() {
        return this.WQ != null ? String.valueOf(this.WQ.getThreadId()) : super.getTid();
    }
}
