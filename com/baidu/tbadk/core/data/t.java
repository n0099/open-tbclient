package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class t extends z {
    public static final BdUniqueId Wj = BdUniqueId.gen();
    private PhotoLiveCardData Wk;

    public PhotoLiveCardData rT() {
        return this.Wk;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Wk = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.z, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Wj;
    }

    @Override // com.baidu.tbadk.core.data.z
    public String getTid() {
        return this.Wk != null ? String.valueOf(this.Wk.getThreadId()) : super.getTid();
    }
}
