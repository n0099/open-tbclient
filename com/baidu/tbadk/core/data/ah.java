package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ah extends ax {
    public static final BdUniqueId Pc = BdUniqueId.gen();
    private PhotoLiveCardData Pd;

    public PhotoLiveCardData pR() {
        return this.Pd;
    }

    @Override // com.baidu.tbadk.core.data.ax, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Pc;
    }

    @Override // com.baidu.tbadk.core.data.ax
    public String getTid() {
        return this.Pd != null ? String.valueOf(this.Pd.getThreadId()) : super.getTid();
    }
}
