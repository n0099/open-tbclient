package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class bk extends bv {
    public static final BdUniqueId dQE = BdUniqueId.gen();
    private String title = "";
    private ArrayList<bm> dQF = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    bm bmVar = new bm();
                    bmVar.a(schoolRecomUserInfo);
                    this.dQF.add(bmVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bv
    public String getTitle() {
        return this.title;
    }

    public ArrayList<bm> aVs() {
        return this.dQF;
    }

    @Override // com.baidu.tbadk.core.data.bv, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dQE;
    }
}
