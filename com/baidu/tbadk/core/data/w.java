package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class w extends ah {
    public static final BdUniqueId VW = BdUniqueId.gen();
    private List<PhotoLiveCardData> VX;

    public List<PhotoLiveCardData> sz() {
        return this.VX;
    }

    public void l(List<PhotoLiveCardData> list) {
        this.VX = list;
    }

    @Override // com.baidu.tbadk.core.data.ah, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return VW;
    }
}
