package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class s extends z {
    public static final BdUniqueId Wh = BdUniqueId.gen();
    private List<PhotoLiveCardData> Wi;

    public List<PhotoLiveCardData> rS() {
        return this.Wi;
    }

    public void i(List<PhotoLiveCardData> list) {
        this.Wi = list;
    }

    @Override // com.baidu.tbadk.core.data.z, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Wh;
    }
}
