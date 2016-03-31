package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class af extends as {
    public static final BdUniqueId Ug = BdUniqueId.gen();
    private PhotoLiveCardData Uh;

    public PhotoLiveCardData sv() {
        return this.Uh;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Uh = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.as, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Ug;
    }

    @Override // com.baidu.tbadk.core.data.as
    public String getTid() {
        return this.Uh != null ? String.valueOf(this.Uh.getThreadId()) : super.getTid();
    }
}
