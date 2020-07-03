package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes.dex */
public class bm extends AbsThreadDataSupport {
    public static final BdUniqueId dIb = BdUniqueId.gen();
    private boolean dKA;
    private List<MetaData> dKB = new ArrayList();
    public int dKp;
    public String title;

    public void aF(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.dKB.add(metaData);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dIb;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bu aPS() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ap aPU() {
        return new ap();
    }

    public List<MetaData> aRC() {
        return this.dKB;
    }

    public boolean aRD() {
        return this.dKA;
    }

    public void gV(boolean z) {
        this.dKA = z;
    }
}
