package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class au extends bd {
    public static final BdUniqueId Zj = BdUniqueId.gen();
    private String title = "";
    private ArrayList<aw> Zk = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    aw awVar = new aw();
                    awVar.a(schoolRecomUserInfo);
                    this.Zk.add(awVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bd
    public String getTitle() {
        return this.title;
    }

    public ArrayList<aw> rl() {
        return this.Zk;
    }

    @Override // com.baidu.tbadk.core.data.bd, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return Zj;
    }
}
