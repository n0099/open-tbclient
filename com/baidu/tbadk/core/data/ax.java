package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class ax extends bh {
    public static final BdUniqueId RW = BdUniqueId.gen();
    private String title = "";
    private ArrayList<az> RX = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    az azVar = new az();
                    azVar.a(schoolRecomUserInfo);
                    this.RX.add(azVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bh
    public String getTitle() {
        return this.title;
    }

    public ArrayList<az> qG() {
        return this.RX;
    }

    @Override // com.baidu.tbadk.core.data.bh, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return RW;
    }
}
