package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class au extends bg {
    public static final BdUniqueId SJ = BdUniqueId.gen();
    private PhotoLiveCardData SK;

    public PhotoLiveCardData qM() {
        return this.SK;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.SK = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return SJ;
    }

    @Override // com.baidu.tbadk.core.data.bg
    public String getTid() {
        return this.SK != null ? String.valueOf(this.SK.getThreadId()) : super.getTid();
    }
}
