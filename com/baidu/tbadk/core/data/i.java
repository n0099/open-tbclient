package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i extends q {
    public static final BdUniqueId zN = BdUniqueId.gen();
    private ArrayList<LiveCardData> zO;

    public ArrayList<LiveCardData> jY() {
        return this.zO;
    }

    public void g(ArrayList<LiveCardData> arrayList) {
        this.zO = arrayList;
    }

    @Override // com.baidu.tbadk.core.data.q, com.baidu.adp.widget.ListView.al
    public BdUniqueId hu() {
        return zN;
    }
}
