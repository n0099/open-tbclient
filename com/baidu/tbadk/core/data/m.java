package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m extends w {
    public static final BdUniqueId PM = BdUniqueId.gen();
    private ArrayList<LiveCardData> PN;

    public ArrayList<LiveCardData> qd() {
        return this.PN;
    }

    public void k(ArrayList<LiveCardData> arrayList) {
        this.PN = arrayList;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return PM;
    }
}
