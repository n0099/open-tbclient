package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class ae extends as {
    public static final BdUniqueId Ue = BdUniqueId.gen();
    private List<PhotoLiveCardData> Uf;

    public List<PhotoLiveCardData> su() {
        return this.Uf;
    }

    public void m(List<PhotoLiveCardData> list) {
        this.Uf = list;
    }

    @Override // com.baidu.tbadk.core.data.as, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Ue;
    }
}
