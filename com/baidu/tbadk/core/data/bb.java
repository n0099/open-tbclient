package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class bb extends bk {
    public static final BdUniqueId dDS = BdUniqueId.gen();
    private String title = "";
    private ArrayList<bd> dDT = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    bd bdVar = new bd();
                    bdVar.a(schoolRecomUserInfo);
                    this.dDT.add(bdVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bk
    public String getTitle() {
        return this.title;
    }

    public ArrayList<bd> aPH() {
        return this.dDT;
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return dDS;
    }
}
