package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m extends w {
    public static final BdUniqueId PK = BdUniqueId.gen();
    private ArrayList<LiveCardData> PL;

    public ArrayList<LiveCardData> qd() {
        return this.PL;
    }

    public void k(ArrayList<LiveCardData> arrayList) {
        this.PL = arrayList;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return PK;
    }
}
