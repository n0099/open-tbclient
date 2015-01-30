package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m extends x {
    public static final BdUniqueId DY = BdUniqueId.gen();
    private ArrayList<LiveCardData> DZ;

    public ArrayList<LiveCardData> mQ() {
        return this.DZ;
    }

    public void o(ArrayList<LiveCardData> arrayList) {
        this.DZ = arrayList;
    }

    @Override // com.baidu.tbadk.core.data.x, com.baidu.adp.widget.ListView.am
    public BdUniqueId js() {
        return DY;
    }
}
