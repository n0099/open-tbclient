package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ay extends bl {
    public static final BdUniqueId Yy = BdUniqueId.gen();
    private PhotoLiveCardData Yz;

    public PhotoLiveCardData qM() {
        return this.Yz;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Yz = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Yy;
    }

    @Override // com.baidu.tbadk.core.data.bl
    public String getTid() {
        return this.Yz != null ? String.valueOf(this.Yz.getThreadId()) : super.getTid();
    }
}
