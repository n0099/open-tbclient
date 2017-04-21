package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class ay extends bi {
    public static final BdUniqueId XA = BdUniqueId.gen();
    private String title = "";
    private ArrayList<ba> XB = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    ba baVar = new ba();
                    baVar.a(schoolRecomUserInfo);
                    this.XB.add(baVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bi
    public String getTitle() {
        return this.title;
    }

    public ArrayList<ba> rx() {
        return this.XB;
    }

    @Override // com.baidu.tbadk.core.data.bi, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return XA;
    }
}
