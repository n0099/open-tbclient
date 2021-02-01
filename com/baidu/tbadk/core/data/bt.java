package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes.dex */
public class bt extends a {
    public static final BdUniqueId eMV = BdUniqueId.gen();
    public int ePm;
    private boolean ePx;
    public String title;
    public boolean ePz = true;
    private List<MetaData> ePy = new ArrayList();

    public void bp(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), this.ePz ? 10 : list.size());
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.ePy.add(metaData);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eMV;
    }

    @Override // com.baidu.tbadk.core.data.a
    public cb bln() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public av blp() {
        return new av();
    }

    public List<MetaData> bnd() {
        return this.ePy;
    }

    public boolean bne() {
        return this.ePx;
    }

    public void jv(boolean z) {
        this.ePx = z;
    }
}
