package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ay extends bl {
    public static final BdUniqueId Yz = BdUniqueId.gen();
    private PhotoLiveCardData YA;

    public PhotoLiveCardData qN() {
        return this.YA;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.YA = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Yz;
    }

    @Override // com.baidu.tbadk.core.data.bl
    public String getTid() {
        return this.YA != null ? String.valueOf(this.YA.getThreadId()) : super.getTid();
    }
}
