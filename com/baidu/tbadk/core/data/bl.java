package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class bl extends bw {
    public static final BdUniqueId eoq = BdUniqueId.gen();
    private String title = "";
    private ArrayList<bn> eor = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    bn bnVar = new bn();
                    bnVar.a(schoolRecomUserInfo);
                    this.eor.add(bnVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bw
    public String getTitle() {
        return this.title;
    }

    public ArrayList<bn> bho() {
        return this.eor;
    }

    @Override // com.baidu.tbadk.core.data.bw, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eoq;
    }
}
