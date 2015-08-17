package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends v {
    public static final BdUniqueId Va = BdUniqueId.gen();
    private ArrayList<LiveCardData> Vb;

    public ArrayList<LiveCardData> rL() {
        return this.Vb;
    }

    public void i(ArrayList<LiveCardData> arrayList) {
        this.Vb = arrayList;
    }

    @Override // com.baidu.tbadk.core.data.v, com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return Va;
    }
}
