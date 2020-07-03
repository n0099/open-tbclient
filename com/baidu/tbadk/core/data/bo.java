package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import tbclient.GeneralResource;
/* loaded from: classes.dex */
public class bo extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dKE = BdUniqueId.gen();
    public int dKF;
    public String res_image;
    public String res_link;

    public void a(GeneralResource generalResource) {
        if (generalResource != null) {
            this.res_image = generalResource.res_image;
            this.res_link = generalResource.res_link;
            this.dKF = generalResource.res_floor.intValue();
        }
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dKE;
    }
}
