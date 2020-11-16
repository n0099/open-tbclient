package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
/* loaded from: classes.dex */
public class l extends BaseCardInfo implements com.baidu.adp.widget.ListView.q {
    public static BdUniqueId eyc = BdUniqueId.gen();
    public List<k> dataList = new ArrayList();

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eyc;
    }

    public void parserProtobuf(List<BannerImage> list) {
        if (list != null) {
            for (BannerImage bannerImage : list) {
                k kVar = new k();
                kVar.a(bannerImage);
                this.dataList.add(kVar);
            }
        }
    }
}
