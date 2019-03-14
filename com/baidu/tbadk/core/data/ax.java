package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class ax extends bg {
    public static final BdUniqueId bAi = BdUniqueId.gen();
    private String title = "";
    private ArrayList<az> bAj = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    az azVar = new az();
                    azVar.a(schoolRecomUserInfo);
                    this.bAj.add(azVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bg
    public String getTitle() {
        return this.title;
    }

    public ArrayList<az> XZ() {
        return this.bAj;
    }

    @Override // com.baidu.tbadk.core.data.bg, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return bAi;
    }
}
