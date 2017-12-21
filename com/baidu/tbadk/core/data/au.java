package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class au extends bd {
    public static final BdUniqueId Yg = BdUniqueId.gen();
    private String title = "";
    private ArrayList<aw> Yh = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    aw awVar = new aw();
                    awVar.a(schoolRecomUserInfo);
                    this.Yh.add(awVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bd
    public String getTitle() {
        return this.title;
    }

    public ArrayList<aw> qE() {
        return this.Yh;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return Yg;
    }
}
