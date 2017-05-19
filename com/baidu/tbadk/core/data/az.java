package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class az extends bk {
    public static final BdUniqueId WS = BdUniqueId.gen();
    private String title = "";
    private ArrayList<bb> WT = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    bb bbVar = new bb();
                    bbVar.a(schoolRecomUserInfo);
                    this.WT.add(bbVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bk
    public String getTitle() {
        return this.title;
    }

    public ArrayList<bb> qH() {
        return this.WT;
    }

    @Override // com.baidu.tbadk.core.data.bk, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return WS;
    }
}
