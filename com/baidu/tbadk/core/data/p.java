package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p extends v {
    public static final BdUniqueId Va = BdUniqueId.gen();
    private PhotoLiveCardData Vb;

    public PhotoLiveCardData rO() {
        return this.Vb;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Vb = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Va;
    }

    @Override // com.baidu.tbadk.core.data.v
    public String getTid() {
        return this.Vb != null ? String.valueOf(this.Vb.getThreadId()) : super.getTid();
    }
}
