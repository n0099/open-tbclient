package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class ba extends bj {
    public static final BdUniqueId XK = BdUniqueId.gen();
    private String title = "";
    private ArrayList<bc> XL = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    bc bcVar = new bc();
                    bcVar.a(schoolRecomUserInfo);
                    this.XL.add(bcVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bj
    public String getTitle() {
        return this.title;
    }

    public ArrayList<bc> qJ() {
        return this.XL;
    }

    @Override // com.baidu.tbadk.core.data.bj, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return XK;
    }
}
