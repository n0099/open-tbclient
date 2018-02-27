package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class au extends bd {
    public static final BdUniqueId aNL = BdUniqueId.gen();
    private String title = "";
    private ArrayList<aw> aNM = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    aw awVar = new aw();
                    awVar.a(schoolRecomUserInfo);
                    this.aNM.add(awVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bd
    public String getTitle() {
        return this.title;
    }

    public ArrayList<aw> yG() {
        return this.aNM;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aNL;
    }
}
