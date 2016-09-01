package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ar extends bg {
    public static final BdUniqueId Sn = BdUniqueId.gen();
    private PhotoLiveCardData So;

    public PhotoLiveCardData qy() {
        return this.So;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.So = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Sn;
    }

    @Override // com.baidu.tbadk.core.data.bg
    public String getTid() {
        return this.So != null ? String.valueOf(this.So.getThreadId()) : super.getTid();
    }
}
