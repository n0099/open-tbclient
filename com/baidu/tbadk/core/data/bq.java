package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes.dex */
public class bq extends a {
    public static final BdUniqueId eFE = BdUniqueId.gen();
    public int eHT;
    private boolean eIe;
    public String title;
    public boolean eIg = true;
    private List<MetaData> eIf = new ArrayList();

    public void bn(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), this.eIg ? 10 : list.size());
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eIf.add(metaData);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eFE;
    }

    @Override // com.baidu.tbadk.core.data.a
    public by bmn() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at bmp() {
        return new at();
    }

    public List<MetaData> boc() {
        return this.eIf;
    }

    public boolean bod() {
        return this.eIe;
    }

    public void jb(boolean z) {
        this.eIe = z;
    }
}
