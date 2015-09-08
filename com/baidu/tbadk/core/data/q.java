package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends x {
    public static final BdUniqueId Vl = BdUniqueId.gen();
    private PhotoLiveCardData Vm;

    public PhotoLiveCardData rT() {
        return this.Vm;
    }

    public void a(PhotoLiveCardData photoLiveCardData) {
        this.Vm = photoLiveCardData;
    }

    @Override // com.baidu.tbadk.core.data.x, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Vl;
    }

    @Override // com.baidu.tbadk.core.data.x
    public String getTid() {
        return this.Vm != null ? String.valueOf(this.Vm.getThreadId()) : super.getTid();
    }
}
