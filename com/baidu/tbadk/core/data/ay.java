package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class ay extends bh {
    public static final BdUniqueId bZS = BdUniqueId.gen();
    private String title = "";
    private ArrayList<ba> bZT = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    ba baVar = new ba();
                    baVar.a(schoolRecomUserInfo);
                    this.bZT.add(baVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bh
    public String getTitle() {
        return this.title;
    }

    public ArrayList<ba> ahM() {
        return this.bZT;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bZS;
    }
}
