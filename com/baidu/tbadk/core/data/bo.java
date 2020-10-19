package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes.dex */
public class bo extends AbsThreadDataSupport {
    public static final BdUniqueId elV = BdUniqueId.gen();
    public int eon;
    private boolean eoy;
    public String title;
    public boolean eoA = true;
    private List<MetaData> eoz = new ArrayList();

    public void aT(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), this.eoA ? 10 : list.size());
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eoz.add(metaData);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return elV;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bfG() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bfI() {
        return new ar();
    }

    public List<MetaData> bhu() {
        return this.eoz;
    }

    public boolean bhv() {
        return this.eoy;
    }

    public void ip(boolean z) {
        this.eoy = z;
    }
}
