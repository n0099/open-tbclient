package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class ay extends bh {
    public static final BdUniqueId XL = BdUniqueId.gen();
    private String title = "";
    private ArrayList<ba> XM = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    ba baVar = new ba();
                    baVar.a(schoolRecomUserInfo);
                    this.XM.add(baVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bh
    public String getTitle() {
        return this.title;
    }

    public ArrayList<ba> qD() {
        return this.XM;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return XL;
    }
}
