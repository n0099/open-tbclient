package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class m extends w {
    public static final BdUniqueId Qi = BdUniqueId.gen();
    private ArrayList<LiveCardData> Qj;

    public ArrayList<LiveCardData> qJ() {
        return this.Qj;
    }

    public void j(ArrayList<LiveCardData> arrayList) {
        this.Qj = arrayList;
    }

    @Override // com.baidu.tbadk.core.data.w, com.baidu.adp.widget.ListView.ai
    public BdUniqueId getType() {
        return Qi;
    }
}
