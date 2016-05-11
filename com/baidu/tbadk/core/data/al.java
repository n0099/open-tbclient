package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class al extends ax {
    public static final BdUniqueId Pg = BdUniqueId.gen();
    private String title = "";
    private ArrayList<ap> Ph = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    ap apVar = new ap();
                    apVar.a(schoolRecomUserInfo);
                    this.Ph.add(apVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.ax
    public String getTitle() {
        return this.title;
    }

    public ArrayList<ap> pT() {
        return this.Ph;
    }

    @Override // com.baidu.tbadk.core.data.ax, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return Pg;
    }
}
