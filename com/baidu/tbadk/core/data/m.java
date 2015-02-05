package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m extends x {
    public static final BdUniqueId DV = BdUniqueId.gen();
    private ArrayList<LiveCardData> DW;

    public ArrayList<LiveCardData> mJ() {
        return this.DW;
    }

    public void o(ArrayList<LiveCardData> arrayList) {
        this.DW = arrayList;
    }

    @Override // com.baidu.tbadk.core.data.x, com.baidu.adp.widget.ListView.am
    public BdUniqueId jl() {
        return DV;
    }
}
