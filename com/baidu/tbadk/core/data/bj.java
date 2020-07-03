package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class bj extends bu {
    public static final BdUniqueId dKs = BdUniqueId.gen();
    private String title = "";
    private ArrayList<bl> dKt = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    bl blVar = new bl();
                    blVar.a(schoolRecomUserInfo);
                    this.dKt.add(blVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bu
    public String getTitle() {
        return this.title;
    }

    public ArrayList<bl> aRw() {
        return this.dKt;
    }

    @Override // com.baidu.tbadk.core.data.bu, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dKs;
    }
}
