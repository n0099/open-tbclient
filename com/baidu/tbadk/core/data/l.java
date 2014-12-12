package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends w {
    public static final BdUniqueId DU = BdUniqueId.gen();
    private ArrayList<LiveCardData> DV;

    public ArrayList<LiveCardData> mO() {
        return this.DV;
    }

    public void o(ArrayList<LiveCardData> arrayList) {
        this.DV = arrayList;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.am
    public BdUniqueId jr() {
        return DU;
    }
}
