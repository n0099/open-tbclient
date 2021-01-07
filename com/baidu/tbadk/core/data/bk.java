package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bk extends bz {
    public static final BdUniqueId eRH = BdUniqueId.gen();
    private ArrayList<RecommendForumData> eRI = new ArrayList<>();

    public ArrayList<RecommendForumData> bqu() {
        return this.eRI;
    }

    @Override // com.baidu.tbadk.core.data.bz, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return eRH;
    }
}
