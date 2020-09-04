package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes.dex */
public class bo extends AbsThreadDataSupport {
    public static final BdUniqueId dXJ = BdUniqueId.gen();
    public int dZY;
    private boolean eaj;
    public String title;
    public boolean eal = true;
    private List<MetaData> eak = new ArrayList();

    public void aM(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), this.eal ? 10 : list.size());
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eak.add(metaData);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dXJ;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bce() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bcg() {
        return new ar();
    }

    public List<MetaData> bdR() {
        return this.eak;
    }

    public boolean bdS() {
        return this.eaj;
    }

    public void hW(boolean z) {
        this.eaj = z;
    }
}
