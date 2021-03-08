package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes.dex */
public class bt extends a {
    public static final BdUniqueId eOw = BdUniqueId.gen();
    public int eQN;
    private boolean eQY;
    public String title;
    public boolean eRa = true;
    private List<MetaData> eQZ = new ArrayList();

    public void bp(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), this.eRa ? 10 : list.size());
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eQZ.add(metaData);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eOw;
    }

    @Override // com.baidu.tbadk.core.data.a
    public cb blp() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public av blr() {
        return new av();
    }

    public List<MetaData> bnf() {
        return this.eQZ;
    }

    public boolean bng() {
        return this.eQY;
    }

    public void jv(boolean z) {
        this.eQY = z;
    }
}
