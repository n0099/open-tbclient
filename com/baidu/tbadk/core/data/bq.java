package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import tbclient.GeneralResource;
/* loaded from: classes.dex */
public class bq extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId exa = BdUniqueId.gen();
    public int exb;
    public String res_image;
    public String res_link;

    public void a(GeneralResource generalResource) {
        if (generalResource != null) {
            this.res_image = generalResource.res_image;
            this.res_link = generalResource.res_link;
            this.exb = generalResource.res_floor.intValue();
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return exa;
    }
}
