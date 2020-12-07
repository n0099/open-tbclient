package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class bn extends by {
    public static final BdUniqueId eHW = BdUniqueId.gen();
    private String title = "";
    private ArrayList<bp> eHX = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    bp bpVar = new bp();
                    bpVar.a(schoolRecomUserInfo);
                    this.eHX.add(bpVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.by
    public String getTitle() {
        return this.title;
    }

    public ArrayList<bp> bnW() {
        return this.eHX;
    }

    @Override // com.baidu.tbadk.core.data.by, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eHW;
    }
}
