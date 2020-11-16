package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes.dex */
public class bp extends a {
    public static final BdUniqueId eyF = BdUniqueId.gen();
    public int eAT;
    private boolean eBe;
    public String title;
    public boolean eBg = true;
    private List<MetaData> eBf = new ArrayList();

    public void bk(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), this.eBg ? 10 : list.size());
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eBf.add(metaData);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eyF;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bx bjd() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public as bjf() {
        return new as();
    }

    public List<MetaData> bkP() {
        return this.eBf;
    }

    public boolean bkQ() {
        return this.eBe;
    }

    public void iM(boolean z) {
        this.eBe = z;
    }
}
