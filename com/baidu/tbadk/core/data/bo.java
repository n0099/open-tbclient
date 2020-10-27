package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes.dex */
public class bo extends AbsThreadDataSupport {
    public static final BdUniqueId euv = BdUniqueId.gen();
    public int ewK;
    private boolean ewV;
    public String title;
    public boolean ewX = true;
    private List<MetaData> ewW = new ArrayList();

    public void bd(List<User> list) {
        if (list != null) {
            int min = Math.min(list.size(), this.ewX ? 10 : list.size());
            for (int i = 0; i < min; i++) {
                MetaData metaData = new MetaData();
                metaData.parserProtobuf(list.get(i));
                this.ewW.add(metaData);
            }
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return euv;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bw bhz() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ar bhB() {
        return new ar();
    }

    public List<MetaData> bjn() {
        return this.ewW;
    }

    public boolean bjo() {
        return this.ewV;
    }

    public void iC(boolean z) {
        this.ewV = z;
    }
}
