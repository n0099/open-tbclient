package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class bb extends bm {
    public static final BdUniqueId WN = BdUniqueId.gen();
    private String title = "";
    private ArrayList<bd> WO = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    bd bdVar = new bd();
                    bdVar.a(schoolRecomUserInfo);
                    this.WO.add(bdVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bm
    public String getTitle() {
        return this.title;
    }

    public ArrayList<bd> qA() {
        return this.WO;
    }

    @Override // com.baidu.tbadk.core.data.bm, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return WN;
    }
}
