package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class bm extends bx {
    public static final BdUniqueId eAW = BdUniqueId.gen();
    private String title = "";
    private ArrayList<bo> eAX = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    bo boVar = new bo();
                    boVar.a(schoolRecomUserInfo);
                    this.eAX.add(boVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bx
    public String getTitle() {
        return this.title;
    }

    public ArrayList<bo> bkJ() {
        return this.eAX;
    }

    @Override // com.baidu.tbadk.core.data.bx, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eAW;
    }
}
