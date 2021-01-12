package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes.dex */
public class br extends a {
    public static final BdUniqueId eKJ = BdUniqueId.gen();
    public int eNa;
    private boolean eNl;
    public String title;
    public boolean eNn = true;
    private List<MetaData> eNm = new ArrayList();

    public void bu(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), this.eNn ? 10 : list.size());
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eNm.add(metaData);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eKJ;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bz bkV() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at bkX() {
        return new at();
    }

    public List<MetaData> bmK() {
        return this.eNm;
    }

    public boolean bmL() {
        return this.eNl;
    }

    public void jt(boolean z) {
        this.eNl = z;
    }
}
