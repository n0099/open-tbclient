package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends w {
    public static final BdUniqueId Vc = BdUniqueId.gen();
    private PhotoLiveCardData Vd;

    public PhotoLiveCardData rL() {
        return this.Vd;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Vd = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Vc;
    }

    @Override // com.baidu.tbadk.core.data.w
    public String getTid() {
        return this.Vd != null ? String.valueOf(this.Vd.getThreadId()) : super.getTid();
    }
}
