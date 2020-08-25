package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes2.dex */
public class bo extends AbsThreadDataSupport {
    public static final BdUniqueId dXF = BdUniqueId.gen();
    public int dZU;
    private boolean eaf;
    public String title;
    public boolean eah = true;
    private List<MetaData> eag = new ArrayList();

    public void aM(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), this.eah ? 10 : list.size());
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.eag.add(metaData);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dXF;
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
        return this.eag;
    }

    public boolean bdS() {
        return this.eaf;
    }

    public void hV(boolean z) {
        this.eaf = z;
    }
}
