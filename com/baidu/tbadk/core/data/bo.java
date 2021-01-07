package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class bo extends bz {
    public static final BdUniqueId eRO = BdUniqueId.gen();
    private String title = "";
    private ArrayList<bq> eRP = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    bq bqVar = new bq();
                    bqVar.a(schoolRecomUserInfo);
                    this.eRP.add(bqVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bz
    public String getTitle() {
        return this.title;
    }

    public ArrayList<bq> bqy() {
        return this.eRP;
    }

    @Override // com.baidu.tbadk.core.data.bz, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eRO;
    }
}
