package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class an extends az {
    public static final BdUniqueId Pq = BdUniqueId.gen();
    private String title = "";
    private ArrayList<ar> Pr = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    ar arVar = new ar();
                    arVar.a(schoolRecomUserInfo);
                    this.Pr.add(arVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.az
    public String getTitle() {
        return this.title;
    }

    public ArrayList<ar> pN() {
        return this.Pr;
    }

    @Override // com.baidu.tbadk.core.data.az, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Pq;
    }
}
