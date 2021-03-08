package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import tbclient.GeneralResource;
/* loaded from: classes.dex */
public class bv extends BaseCardInfo {
    public static final BdUniqueId eRd = BdUniqueId.gen();
    public int eRe;
    public String res_image;
    public String res_link;

    public void a(GeneralResource generalResource) {
        if (generalResource != null) {
            this.res_image = generalResource.res_image;
            this.res_link = generalResource.res_link;
            this.eRe = generalResource.res_floor.intValue();
        }
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eRd;
    }
}
