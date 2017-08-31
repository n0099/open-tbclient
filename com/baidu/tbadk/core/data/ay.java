package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ay extends bj {
    public static final BdUniqueId XH = BdUniqueId.gen();
    private PhotoLiveCardData XI;

    public PhotoLiveCardData qI() {
        return this.XI;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.XI = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return XH;
    }

    @Override // com.baidu.tbadk.core.data.bj
    public String getTid() {
        return this.XI != null ? String.valueOf(this.XI.getThreadId()) : super.getTid();
    }
}
