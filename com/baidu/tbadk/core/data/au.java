package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class au extends bc {
    public static final BdUniqueId ahE = BdUniqueId.gen();
    private String title = "";
    private ArrayList<aw> ahF = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    aw awVar = new aw();
                    awVar.a(schoolRecomUserInfo);
                    this.ahF.add(awVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bc
    public String getTitle() {
        return this.title;
    }

    public ArrayList<aw> uO() {
        return this.ahF;
    }

    @Override // com.baidu.tbadk.core.data.bc, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ahE;
    }
}
