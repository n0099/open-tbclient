package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class at extends bb {
    public static final BdUniqueId apg = BdUniqueId.gen();
    private String title = "";
    private ArrayList<av> aph = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    av avVar = new av();
                    avVar.a(schoolRecomUserInfo);
                    this.aph.add(avVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bb
    public String getTitle() {
        return this.title;
    }

    public ArrayList<av> xT() {
        return this.aph;
    }

    @Override // com.baidu.tbadk.core.data.bb, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return apg;
    }
}
