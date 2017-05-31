package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes.dex */
public class ba extends bl {
    public static final BdUniqueId WN = BdUniqueId.gen();
    private String title = "";
    private ArrayList<bc> WO = new ArrayList<>();

    public void a(RecommendInfo recommendInfo) {
        if (recommendInfo != null) {
            this.title = recommendInfo.title;
            for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
                if (schoolRecomUserInfo != null) {
                    bc bcVar = new bc();
                    bcVar.a(schoolRecomUserInfo);
                    this.WO.add(bcVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.data.bl
    public String getTitle() {
        return this.title;
    }

    public ArrayList<bc> qD() {
        return this.WO;
    }

    @Override // com.baidu.tbadk.core.data.bl, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return WN;
    }
}
