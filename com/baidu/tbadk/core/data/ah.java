package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public List<j> dataList = new ArrayList();

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return TYPE;
    }

    public void parserProtobuf(List<BannerImage> list) {
        if (list != null) {
            this.dataList.clear();
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                j jVar = new j();
                jVar.a(list.get(i));
                this.dataList.add(jVar);
            }
        }
    }
}
