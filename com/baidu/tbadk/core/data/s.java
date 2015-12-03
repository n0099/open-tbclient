package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class s extends z {
    public static final BdUniqueId VH = BdUniqueId.gen();
    private List<PhotoLiveCardData> VI;

    public List<PhotoLiveCardData> sj() {
        return this.VI;
    }

    public void i(List<PhotoLiveCardData> list) {
        this.VI = list;
    }

    @Override // com.baidu.tbadk.core.data.z, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return VH;
    }
}
