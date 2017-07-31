package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ay extends bl {
    public static final BdUniqueId Yw = BdUniqueId.gen();
    private PhotoLiveCardData Yx;

    public PhotoLiveCardData qM() {
        return this.Yx;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Yx = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Yw;
    }

    @Override // com.baidu.tbadk.core.data.bl
    public String getTid() {
        return this.Yx != null ? String.valueOf(this.Yx.getThreadId()) : super.getTid();
    }
}
