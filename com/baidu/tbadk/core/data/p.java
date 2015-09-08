package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends x {
    public static final BdUniqueId Vj = BdUniqueId.gen();
    private List<PhotoLiveCardData> Vk;

    public List<PhotoLiveCardData> rS() {
        return this.Vk;
    }

    public void j(List<PhotoLiveCardData> list) {
        this.Vk = list;
    }

    @Override // com.baidu.tbadk.core.data.x, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Vj;
    }
}
