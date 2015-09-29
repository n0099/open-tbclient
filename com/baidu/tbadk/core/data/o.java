package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class o extends v {
    public static final BdUniqueId UY = BdUniqueId.gen();
    private List<PhotoLiveCardData> UZ;

    public List<PhotoLiveCardData> rN() {
        return this.UZ;
    }

    public void j(List<PhotoLiveCardData> list) {
        this.UZ = list;
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return UY;
    }
}
