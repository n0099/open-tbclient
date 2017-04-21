package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class aw extends bi {
    public static final BdUniqueId Xx = BdUniqueId.gen();
    private PhotoLiveCardData Xy;

    public PhotoLiveCardData rw() {
        return this.Xy;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Xy = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Xx;
    }

    @Override // com.baidu.tbadk.core.data.bi
    public String getTid() {
        return this.Xy != null ? String.valueOf(this.Xy.getThreadId()) : super.getTid();
    }
}
