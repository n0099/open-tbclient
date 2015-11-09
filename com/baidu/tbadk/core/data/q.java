package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends w {
    public static final BdUniqueId Ve = BdUniqueId.gen();
    private PhotoLiveCardData Vf;

    public PhotoLiveCardData rN() {
        return this.Vf;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Vf = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Ve;
    }

    @Override // com.baidu.tbadk.core.data.w
    public String getTid() {
        return this.Vf != null ? String.valueOf(this.Vf.getThreadId()) : super.getTid();
    }
}
