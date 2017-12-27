package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class av extends be {
    public static final BdUniqueId aME = BdUniqueId.gen();
    private String title = "";
    private ArrayList<ax> aMF = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    ax axVar = new ax();
                    axVar.a(schoolRecomUserInfo);
                    this.aMF.add(axVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.be
    public String getTitle() {
        return this.title;
    }

    public ArrayList<ax> yh() {
        return this.aMF;
    }

    @Override // com.baidu.tbadk.core.data.be, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return aME;
    }
}
