package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes.dex */
public class bo extends AbsThreadDataSupport {
    public static final BdUniqueId eAo = BdUniqueId.gen();
    public int eCC;
    private boolean eCN;
    public String title;
    public boolean eCP = true;
    private List<MetaData> eCO = new ArrayList();

    public void bk(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), this.eCP ? 10 : list.size());
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eCO.add(metaData);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eAo;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bjZ() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bkb() {
        return new ar();
    }

    public List<MetaData> blN() {
        return this.eCO;
    }

    public boolean blO() {
        return this.eCN;
    }

    public void iL(boolean z) {
        this.eCN = z;
    }
}
