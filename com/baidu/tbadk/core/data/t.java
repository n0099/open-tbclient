package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class t extends z {
    public static final BdUniqueId VJ = BdUniqueId.gen();
    private PhotoLiveCardData VK;

    public PhotoLiveCardData sk() {
        return this.VK;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.VK = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.z, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return VJ;
    }

    @Override // com.baidu.tbadk.core.data.z
    public String getTid() {
        return this.VK != null ? String.valueOf(this.VK.getThreadId()) : super.getTid();
    }
}
