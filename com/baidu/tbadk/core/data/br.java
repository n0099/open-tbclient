package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes.dex */
public class br extends a {
    public static final BdUniqueId ePu = BdUniqueId.gen();
    public int eRL;
    private boolean eRW;
    public String title;
    public boolean eRY = true;
    private List<MetaData> eRX = new ArrayList();

    public void bu(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), this.eRY ? 10 : list.size());
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eRX.add(metaData);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ePu;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bz boP() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at boR() {
        return new at();
    }

    public List<MetaData> bqE() {
        return this.eRX;
    }

    public boolean bqF() {
        return this.eRW;
    }

    public void jx(boolean z) {
        this.eRW = z;
    }
}
