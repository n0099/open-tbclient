package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class x extends ah {
    public static final BdUniqueId VY = BdUniqueId.gen();
    private PhotoLiveCardData VZ;

    public PhotoLiveCardData sA() {
        return this.VZ;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.VZ = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.ah, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return VY;
    }

    @Override // com.baidu.tbadk.core.data.ah
    public String getTid() {
        return this.VZ != null ? String.valueOf(this.VZ.getThreadId()) : super.getTid();
    }
}
