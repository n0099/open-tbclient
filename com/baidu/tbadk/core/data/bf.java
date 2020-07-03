package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bf extends bu {
    public static final BdUniqueId dKm = BdUniqueId.gen();
    private ArrayList<RecommendForumData> dKn = new ArrayList<>();

    public ArrayList<RecommendForumData> aRs() {
        return this.dKn;
    }

    @Override // com.baidu.tbadk.core.data.bu, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return dKm;
    }
}
