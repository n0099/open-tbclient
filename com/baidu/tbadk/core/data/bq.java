package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class bq extends cb {
    public static final BdUniqueId eQQ = BdUniqueId.gen();
    private String title = "";
    private ArrayList<bs> eQR = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    bs bsVar = new bs();
                    bsVar.a(schoolRecomUserInfo);
                    this.eQR.add(bsVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.cb
    public String getTitle() {
        return this.title;
    }

    public ArrayList<bs> bmZ() {
        return this.eQR;
    }

    @Override // com.baidu.tbadk.core.data.cb, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eQQ;
    }
}
