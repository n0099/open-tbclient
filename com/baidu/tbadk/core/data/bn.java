package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes.dex */
public class bn extends AbsThreadDataSupport {
    public static final BdUniqueId dOm = BdUniqueId.gen();
    public int dQB;
    private boolean dQM;
    private List<MetaData> dQN = new ArrayList();
    public String title;

    public void aM(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.dQN.add(metaData);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dOm;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bv aTN() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public aq aTP() {
        return new aq();
    }

    public List<MetaData> aVy() {
        return this.dQN;
    }

    public boolean aVz() {
        return this.dQM;
    }

    public void hz(boolean z) {
        this.dQM = z;
    }
}
