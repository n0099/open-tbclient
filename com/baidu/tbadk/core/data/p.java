package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends w {
    public static final BdUniqueId Va = BdUniqueId.gen();
    private List<PhotoLiveCardData> Vb;

    public List<PhotoLiveCardData> rK() {
        return this.Vb;
    }

    public void j(List<PhotoLiveCardData> list) {
        this.Vb = list;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Va;
    }
}
