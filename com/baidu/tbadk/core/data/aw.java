package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class aw extends bg {
    public static final BdUniqueId SM = BdUniqueId.gen();
    private String title = "";
    private ArrayList<ay> SN = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    ay ayVar = new ay();
                    ayVar.a(schoolRecomUserInfo);
                    this.SN.add(ayVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bg
    public String getTitle() {
        return this.title;
    }

    public ArrayList<ay> qO() {
        return this.SN;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return SM;
    }
}
