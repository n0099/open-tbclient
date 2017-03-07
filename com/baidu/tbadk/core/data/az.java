package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class az extends bj {
    public static final BdUniqueId Xj = BdUniqueId.gen();
    private String title = "";
    private ArrayList<bb> Xk = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    bb bbVar = new bb();
                    bbVar.a(schoolRecomUserInfo);
                    this.Xk.add(bbVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bj
    public String getTitle() {
        return this.title;
    }

    public ArrayList<bb> qZ() {
        return this.Xk;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Xj;
    }
}
