package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class ay extends bk {
    public static final BdUniqueId Ta = BdUniqueId.gen();
    private String title = "";
    private ArrayList<bc> Tb = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    bc bcVar = new bc();
                    bcVar.a(schoolRecomUserInfo);
                    this.Tb.add(bcVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bk
    public String getTitle() {
        return this.title;
    }

    public ArrayList<bc> qN() {
        return this.Tb;
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Ta;
    }
}
