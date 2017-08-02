package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ay extends bl {
    public static final BdUniqueId Xa = BdUniqueId.gen();
    private PhotoLiveCardData Xb;

    public PhotoLiveCardData qC() {
        return this.Xb;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Xb = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Xa;
    }

    @Override // com.baidu.tbadk.core.data.bl
    public String getTid() {
        return this.Xb != null ? String.valueOf(this.Xb.getThreadId()) : super.getTid();
    }
}
