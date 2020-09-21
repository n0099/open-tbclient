package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes.dex */
public class bo extends AbsThreadDataSupport {
    public static final BdUniqueId dZT = BdUniqueId.gen();
    public int eci;
    private boolean ect;
    public String title;
    public boolean ecv = true;
    private List<MetaData> ecu = new ArrayList();

    public void aQ(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), this.ecv ? 10 : list.size());
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.ecu.add(metaData);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dZT;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bcY() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bda() {
        return new ar();
    }

    public List<MetaData> beL() {
        return this.ecu;
    }

    public boolean beM() {
        return this.ect;
    }

    public void hT(boolean z) {
        this.ect = z;
    }
}
