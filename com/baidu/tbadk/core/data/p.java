package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.List;
/* loaded from: classes.dex */
public class p extends w {
    public static final BdUniqueId Vc = BdUniqueId.gen();
    private List<PhotoLiveCardData> Vd;

    public List<PhotoLiveCardData> rM() {
        return this.Vd;
    }

    public void j(List<PhotoLiveCardData> list) {
        this.Vd = list;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Vc;
    }
}
