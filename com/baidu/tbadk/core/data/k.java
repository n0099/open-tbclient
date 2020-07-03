package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.q {
    public static BdUniqueId dHK = BdUniqueId.gen();
    public List<j> dataList = new ArrayList();

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dHK;
    }

    public void parserProtobuf(List<BannerImage> list) {
        if (list != null) {
            for (BannerImage bannerImage : list) {
                j jVar = new j();
                jVar.a(bannerImage);
                this.dataList.add(jVar);
            }
        }
    }
}
