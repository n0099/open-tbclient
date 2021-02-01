package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class bq extends cb {
    public static final BdUniqueId ePp = BdUniqueId.gen();
    private String title = "";
    private ArrayList<bs> ePq = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    bs bsVar = new bs();
                    bsVar.a(schoolRecomUserInfo);
                    this.ePq.add(bsVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.cb
    public String getTitle() {
        return this.title;
    }

    public ArrayList<bs> bmX() {
        return this.ePq;
    }

    @Override // com.baidu.tbadk.core.data.cb, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ePp;
    }
}
