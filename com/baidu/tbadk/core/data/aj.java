package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
/* loaded from: classes.dex */
public class aj extends BaseCardInfo implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId TYPE = BdUniqueId.gen();
    public List<k> dataList = new ArrayList();

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return TYPE;
    }

    public void parserProtobuf(List<BannerImage> list) {
        if (list != null) {
            this.dataList.clear();
            int min = Math.min(list.size(), 10);
            for (int i = 0; i < min; i++) {
                k kVar = new k();
                kVar.a(list.get(i));
                this.dataList.add(kVar);
            }
        }
    }
}
