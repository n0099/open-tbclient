package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
/* loaded from: classes.dex */
public class m extends BaseCardInfo implements com.baidu.adp.widget.ListView.n {
    public static BdUniqueId eMu = BdUniqueId.gen();
    public List<l> dataList = new ArrayList();

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eMu;
    }

    public void parserProtobuf(List<BannerImage> list) {
        if (list != null) {
            for (BannerImage bannerImage : list) {
                l lVar = new l();
                lVar.a(bannerImage);
                this.dataList.add(lVar);
            }
        }
    }
}
